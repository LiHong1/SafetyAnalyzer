<#include "../left.ftl"/> 
  <script src="${basePath}/js/Calendar5.js" type="text/javascript"></script>

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
	                            <div class="col-lg-6 form-horizontal">
		                            <div class="form-group">  
		                                   <label class="col-sm-3 control-label">注册时间:　 </label>
		                                        <div class="col-sm-8"> <input id="createdDateBegin" name="createdDateBegin" minlength="2" type="text" class="form-control"  onfocus="c.showMoreDay = false;c.show(this);" aria-required="true"></div>
		                            </div>
		                            <div class="form-group">  
		                                   <label class="col-sm-3 control-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;　 </label>
		                                        <div class="col-sm-8"> <input id="createdDateEnd" name="createdDateBegin" minlength="2" type="text" class="form-control"  onfocus="c.showMoreDay = false;c.show(this);" aria-required="true"></div>
		                            </div>
	                           </div>
                            <div style="clear:both; "></div>
	                        <div class="col-sm-12  center" >
	                               <span style="margin-right:40px">
	                               <button type="submit" value="Submit" id="submit" class="submit_btn">提交</button>
	                               </span>
	                                <span style="margin-left:40px">
	                               <button type="reset" value="Reset" class="reset_btn">重置</button>
	                               </span>
	                            
	                        </div>
                        </div>
                       
                  </div>
                </div>
                <div class="col-sm-12 top_dash pad_btm_1">
                    <div id="usersGrid"></div>
                    <div class="wrapper wrapper-content animated fadeInRight">
		                <div class="row">
		                    <div class="col-lg-12">
		                        <div class="ibox float-e-margins">
		                            <div class="ibox-title">
		                                <h5>用户<small>分类，查找</small></h5>
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
		
		                                <table id="userlist" class="table table-striped table-bordered table-hover">
		                                    <thead>
		                                        <tr>
		                                            <th>id</th>
		                                            <th>手机号</th>
		                                            <th>用户名</th>
		                                            <th>注册时间</th>
		                                            <th>用户类型</th>
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

            
    <!-- Data Tables -->
    <script src="js/plugins/dataTables/jquery.dataTables.js"></script>
<!--     <script src="js/plugins/dataTables/dataTables.bootstrap.js"></script> -->
	<script type="text/javascript">
/* 	 var load= function(){
	 $('#usersGrid').datagrid({
        url : 'users',
        title:'用户列表',
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
        queryParams:{
                    id:$("#id").val(),
                    title:$("#title").val(),
                    keywords:$("#keywords").val(),
                    createdDate:$("#createdDate").val(),
                    updatedDate:$("#updatedDate").val()
                    },
        columns : [[
                   {title : '手机号',field : 'phone',width : 250,sortable:true,align : "center",
                       formatter:function(value,rowData,rowIndex){
                           return '<a href="Javascript:void(0);"  onclick="viewCase(\''+rowData.id+'\')">'+value+'</a>';     
                       }
                   },
	              {title : '用户名称',field : 'username',width : 250,sortable:true,align : "center",
	                  formatter:function(value,rowData,rowIndex){
	                      return '<a href="Javascript:void(0);"  onclick="viewCase(\''+rowData.id+'\')">'+value+'</a>';     
	                  }
	              },
	              {title : '注册时间',field : 'createdDate',width : 100,align : "center",
	                  formatter:function(value,rowData,rowIndex){
	                      if(value !=null){
	                          return new Date(value).format('yyyy-MM-dd');
	                      }else{
	                          return "";
	                      }
	                  }
	              },
	               {title : '操作',field : 'id',width : 50,sortable:true,align : "center",
	                  formatter:function(value,rowData,rowIndex){
	                       return '<a href="Javascript:void(0);"  onclick="deleteCase(\''+rowData.id+'\')">'+"删除"+'</a>';            
	                  }
	              },
             
	              ]],
        onLoadSuccess:function(data){
            var pg = $('#usersGrid').datagrid('getPager');
            $(pg).pagination({
                pageSize : 20,// 每页显示的记录条数，默认为10
                pageList : [ 20, 50, 100 ],// 可以设置每页记录条数的列表
                beforePageText : '第',// 页数文本框前显示的汉字
                afterPageText : '页    共 {'+data.pageCount+'} 页',
                displayMsg : '当前显示 {'+((data.beginPageIndex-1)*data.pageSize+1)+'} - {'+((data.beginPageIndex-1)*data.pageSize+data.rows.length)+'} 条记录   共 {'+(data.rows.length)+'}条记录'
            });
        }
       }); 
    
	 }
	 $("#submit").on("click",function(){
    	 load();
	 });
	  $("#add").on("click",function(){
         window.location.href = "case/add";
     });
     var viewCase = function(id){
       showCase(id);
       $("#case_list").hide();
       $("#case_show").show();
     };
     var deleteCase = function(id){
       if(confirm("确定要删除??")){
           $.ajax({
            type: "get",
            dataType: "json",
            url: 'user/delete/'+id,
            success: function (data) {
                if(data != ""){
                   alert(data.message);
                   if(data.status == 0){
                       load();
                   }
                }
            }
           });  
         }
     };
  
     */   
     Date.prototype.format = function(fmt)   
        { //author: meizz   
          var o = {   
            "M+" : this.getMonth()+1,                 //月份   
            "d+" : this.getDate(),                    //日   
            "h+" : this.getHours(),                   //小时   
            "m+" : this.getMinutes(),                 //分   
            "s+" : this.getSeconds(),                 //秒   
            "q+" : Math.floor((this.getMonth()+3)/3), //季度   
            "S"  : this.getMilliseconds()             //毫秒   
          };   
          if(/(y+)/.test(fmt))   
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
          for(var k in o)   
            if(new RegExp("("+ k +")").test(fmt))   
          fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
          return fmt;   
        }  
        
$(function(){		
	  //load();
	$('#userlist').dataTable({
		"processing": true,
	    "serverSide": true,
		"ajax": {
		    "url": "",
		    "type": "POST"
		  },
		  "columns": [
		              { "data": "id" },
		              { "data": "phone" },
		              { "data": "username" },
		              { "data": "createdDate" },
		              { "data": "type" }
		          ]
    });
});

	</script>
<#include "../bottom.ftl"/>
      