<#include "../left.ftl"/> 
<#include "../ui/select.ftl"/>
<div class="row  border-bottom white-bg dashboard-header">
                <div class="col-sm-12">
                        <div class="col-sm-12">
                            <div class="col-lg-6 form-horizontal">
		                        <div class="form-group">  
	                                           <label class="col-sm-3 control-label">序号:　</label>
	                                                <div class="col-sm-8"> <input id="id" name="keywords" minlength="2" type="text" class="form-control"  aria-required="true"></div>
	                            </div>
	                        </div>
	                         <div class="col-lg-6 form-horizontal">
		                             <div class="form-group">  
		                                           <label class="col-sm-3 control-label">关键字:</label>
		                                                <div class="col-sm-8"> <input id="keywords" name="keywords" minlength="2" type="text" class="form-control"  aria-required="true"></div>
		                            </div>
	                         </div>
	                         <div class="col-lg-6 form-horizontal">
			                        <div class="form-group">  
	                                               <label class="col-sm-3 control-label">关键字:</label>
	                                                 <div class="col-sm-8">
								                          <@select list=[{'value':'A'},{'value':'B'},{'value':'C'},{'value':'D'},{'value':'E'},{'value':'F'},
								                                         {'value':'G'},{'value':'H'},{'value':'I'},{'value':'J'},{'value':'K'},{'value':'L'},
								                                         {'value':'M'},{'value':'N'},{'value':'O'},{'value':'P'},{'value':'Q'},{'value':'R'},
								                                         {'value':'S'},{'value':'T'},{'value':'U'},{'value':'V'},{'value':'W'},{'value':'X'},
								                                         {'value':'Y'}, {'value':'Z'}]  value='0'
								                            optionName="value" optionValue="value"  class="form-control m-b" defaultOptions= {"":"--请选择类型--"} extendCss="color:#999" id="caseType" name="type"/> 
			                                         </div>
			                         </div>
		                    </div>
                        </div>
                        <div class="col-sm-12 h_1">
                             <div  class="col-sm-12 center">
                               <span style="margin-right:40px">
		                       <button type="submit" value="Submit" class="submit_btn">提交</button>
		                       </span>
		                        <span style="margin-right:40px">
                                  <button id="add" class="btn btn-primary pull-right">新增</button>
                               </span>
		                        <span style="margin-left:40px">
		                       <button type="reset" value="Reset" class="reset_btn">重置</button>
		                       </span>
		                     </div>          
                        </div>
                </div>
                <div class="col-sm-12 top_dash pad_btm_1">
                    <div id="keywordsGrid" style="width:400px"></div>
                </div>
         
	<script type="text/javascript">
     
	$(function(){
		$('#keywordsGrid').datagrid({
		url : 'keyword',
		title:'案例列表',
		method : 'post',
		loadMsg : "数据装载中....",
		nowrap : false,
		fitColumns : false,
		pagination : true,
		rownumbers : true,
		striped : true,
		idField:'id',
		pageSize : 20,
		pageList : [ 20, 50, 100 ],
		columns : [[
		      /**{title : '删除' ,field : 'id',width : 50,checkbox:true,align : "center",formatter:''},**/
	       
	       
	          {title : '关键字',field : 'word',width : 150,align : "center"},
	          {title : '创建时间',field : 'createDate',width : 70,align : "center",
	        	  formatter:function(value,rowData,rowIndex){
	        		  if(value !=null){
	      				  return new Date(value.time).format('yyyy-MM-dd');
	      			  }else{
	      				  return "";
	      			  }
	    		  }
	          },
	          {title : '修改时间',field : 'updateDate',width : 70,align : "center",
	        	  formatter:function(value,rowData,rowIndex){
	        		  if(value !=null){
	      				  return new Date(value.time).format('yyyy-MM-dd');
	      			  }else{
	      				  return "";
	      			  }
	    		  }
	          }
	         
		]],
		onLoadSuccess:function(data){
			var pg = $('#keywordsGrid').datagrid('getPager');
			$(pg).pagination({
				pageSize : 20,// 每页显示的记录条数，默认为10
				pageList : [ 20, 50, 100 ],// 可以设置每页记录条数的列表
				beforePageText : '第',// 页数文本框前显示的汉字
				afterPageText : '页    共 {'+data.pageCount+'} 页',
				displayMsg : '当前显示 {'+((data.beginPageIndex-1)*data.pageSize+1)+'} - {'+((data.beginPageIndex-1)*data.pageSize+data.rows.length)+'} 条记录   共 {'+(data.rows.length)+'}条记录'
			});
		}
	   });
	  
	
		
		})
	</script>
<#include "../bottom.ftl"/>
      