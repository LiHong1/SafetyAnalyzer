package com.lihong.action;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lihong.bean.Case;
import com.lihong.bean.CaseIndex;
import com.lihong.common.bean.PageBean;
import com.lihong.common.bean.ResultObj;
import com.lihong.common.util.JedisUtil;
import com.lihong.dto.CaseDto;
import com.lihong.dto.CasePageBeanDto;
import com.lihong.service.CaseIndexService;
import com.lihong.service.CaseService;
import com.lihong.service.DictionaryService;
@Controller
public class CaseAction{
    
    private static Logger logger = Logger.getLogger(CaseAction.class);
	@Autowired
	private CaseService caseService;
	@Autowired
	private DictionaryService dictionaryService;
	
	
	@RequestMapping(value="/case/{id}",method = RequestMethod.GET)
	public String index(@PathVariable Long id,Model model){
        List<Case> cs = caseService.getCase(id);
		model.addAttribute("cases",cs); 
		return "case/caseShow";
	}

	@RequestMapping(value="/cases",method = RequestMethod.GET)
	public String casesList(HttpServletRequest request){
		return "case/cases";
	}
	
	/*@RequestMapping(value="/casess",method = RequestMethod.GET)
	public @ResponseBody PageBean cases(@RequestParam Integer page,@RequestParam Integer rows){
       PageBean<Case> pageBean = caseService.getPage(page, rows);
		return pageBean;
	}*/
	
	@RequestMapping(value="/casess",method = RequestMethod.POST)
    public @ResponseBody PageBean cases(CasePageBeanDto c,@RequestParam Integer page,@RequestParam Integer rows){
       PageBean<Case> pageBean = caseService.getPage(page, rows,c);
        return pageBean;
    }
	
	@RequiresRoles("admin")
	@RequestMapping(value="/case/add",method = RequestMethod.GET)
    public String addCase(Model model){
	    model.addAttribute("caseType", dictionaryService.getByName("case_type"));
        return "case/caseAdd";
    }
	
	@RequiresRoles("admin")
    @RequestMapping(value="/case/add",method = RequestMethod.POST)
    @ResponseBody
    public  ResultObj addCase(@Valid Case c,BindingResult br){
        if (br.hasErrors()){
            return new ResultObj(1, br.getFieldError().getDefaultMessage());
        }
        caseService.add(c);
        return new ResultObj(0, "新增成功",c.getId());
    }
	   
	@RequiresRoles("admin")
	@RequestMapping(value="/case/import",method = RequestMethod.GET)
    public String addCases(){
        return "case/caseImport";
    }
	
	@RequiresRoles("admin")
	@RequestMapping(value="/case/delete/{id}",method = RequestMethod.GET)
	@ResponseBody
    public ResultObj deleteCases(@PathVariable Long id){
	    caseService.delete(id);
	    ResultObj resultObj = new ResultObj(0, "删除成功");
        return resultObj;
    }
	
	@RequiresRoles("admin")
	@RequestMapping(value="/case/import",method = RequestMethod.POST)
    public String addCases(Model model,MultipartFile file){

	    if (file != null) {
	        try {
                List<CaseDto> cases = caseService.getCase(file.getInputStream());
	            int casesId = new Random().nextInt()&~(1<<31);                               //存在redis上的case集合编号
                JedisUtil.addList(String.valueOf(casesId), cases, 20000);
                
                if(cases != null){
                    model.addAttribute("cases",cases);
                    model.addAttribute("casesId",casesId);
                    logger.error("casesId======="+casesId);
                }
               
            } catch (IOException e) {
               
            }
        }
        return "case/caseImportShow";
    }
	
   @RequiresRoles("admin")
   @RequestMapping(value="/case/import/{casesId}",method = RequestMethod.POST)
   @ResponseBody
    public ResultObj addCases(@PathVariable String casesId){

       List<CaseDto> cases = JedisUtil.getList(casesId);
       ResultObj resultObj ;
       if (cases!=null && cases.size()!=0) {
           int size = caseService.addCase(cases);
           resultObj = new ResultObj(0, "新添加成功"+size+"条记录");
       }else{
           resultObj = new ResultObj(1, "没有添加案例");
       }
        return resultObj;
    }
	
	@RequestMapping(value="/case/templet/download",method = RequestMethod.GET)
    public String getCaseTemplet(){
        return "case/caseAdd";
    }
	
	
	

}
