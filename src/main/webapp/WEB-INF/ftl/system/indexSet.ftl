<#include "../left.ftl"/> 
   <link rel="stylesheet" type="text/css" href="${basePath}/css/plugins/processerBar/processBar.css">
   <div class="row  border-bottom dashboard-header">
                <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>查询</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-user">
                                        <li><a href="form_basic.html#">选项1</a>
                                        </li>
                                        <li><a href="form_basic.html#">选项2</a>
                                        </li>
                                    </ul>
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="col-lg-6 form-horizontal">
                                    <div class="form-group">  
                                           <label class="col-sm-3 control-label">手机号:　　</label>
                                                <div class="col-sm-8"> <input id="cname" name="name" minlength="2" type="text" class="form-control"  aria-required="true"></div>
                                    </div>
                                    <div class="form-group">  
                                           <label class="col-sm-3 control-label">用户名称:　　</label>
                                                <div class="col-sm-8"> <input id="cname" name="name" minlength="2" type="text" class="form-control"  aria-required="true"></div>
                                    </div>
                                </div>
                            <div style="clear:both; "></div>
                            <div class="col-sm-12  center" >
                                   <span style="margin-right:40px">
                                   <button type="submit" value="Submit" id="submit" class="submit_btn">提交</button>
                                   </span>
                                   <span style="margin-right:40px">
	                                  <button id="rebulidIndex" class="btn btn-primary pull-right">重建索引</button>
	                               </span>
                                    <span style="margin-left:40px">
                                   <button type="reset" value="Reset" class="reset_btn">重置</button>
                                   </span>
                                
                            </div>
                        </div>
                       
                  </div>
                </div>
                <div class="col-sm-12 top_dash pad_btm_1">
                    <div id="caseIndexGrid"></div>
                    <div class="wrapper wrapper-content animated fadeInRight">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>待建索引列表<small></small></h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                            <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                                                <i class="fa fa-wrench"></i>
                                            </a>
                                            <ul class="dropdown-menu dropdown-user">
                                                <li><a href="table_data_tables.html#">选项1</a>
                                                </li>
                                                <li><a href="table_data_tables.html#">选项2</a>
                                                </li>
                                            </ul>
                                            <a class="close-link">
                                                <i class="fa fa-times"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="ibox-content">
        
                                        <table id="unfinishCaseIndexlist" class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>案例id</th>
                                                    <th>标题</th>
                                                    <th>操作</th>
                                                    <th>创建时间</th>
                                                    <th>修改时间</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>
        
                                    </div>
                                </div>
                            </div>
                        </div>
                  </div>
             
   </div>

            <!-- 父级元素 -->
	         <div id="mask" style="position:absolute;left:10px;padding:10px;width:100%;height:100%;background:#EEE;z-index:-1;opacity:0.5">  <!-- 进度条 -->
             </div>
               <div class="barline" id="probar" style="position:absolute;left:30%;top:30%;z-index:-1;">
                   <div id="percent"></div>
                   <div id="line" w="100" style="width:0px;"></div>    
                   <div id="msg" style=""></div>           
               </div>  
</div>

    <!-- Data Tables -->
    <script src="js/plugins/dataTables/jquery.dataTables.js"></script>
    <script type="text/javascript">
$(function(){     
	function processerbar(time){
	     document.getElementById('probar').style.display="block";
	    $("#line").each(function(i,item){
	        var a=parseInt($(item).attr("w"));
	        $(item).animate({
	            width: a+"%"
	        },time);
	    });
	   var si = window.setInterval(
	    function(){
	        a=$("#line").width();
	        b=(a/200*100).toFixed(0);
	        document.getElementById('percent').innerHTML=b+"%";
	        document.getElementById('percent').style.left=a-12+"px";
	        document.getElementById('msg').innerHTML="重建索引中";
	        if(document.getElementById('percent').innerHTML=="100%") {
	           clearInterval(si);
	           document.getElementById('msg').innerHTML="&nbsp;&nbsp;成功";
	        }
	    },700);
	};
	
    $('#unfinishCaseIndexlist').dataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "caseIndexs",
            "type": "POST"
          },
          "columns": [
                      { "data": "caseId" },
                      { "data": "title" },
                      { "data": "operate" },
                      { "data": "createdDate" },
                      { "data": "updatedDate" }
                  ]
    });
    $("#rebulidIndex").on("click",function(){
    	$("#mask").css("z-index",100);
    	$("#probar").css("z-index",101);
    	processerbar(3000);
    }); 
});

    </script>
<#include "../bottom.ftl"/>
      