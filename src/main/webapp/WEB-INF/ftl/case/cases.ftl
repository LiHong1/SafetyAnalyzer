<#include "../left.ftl"/> 
  <script src="${basePath}/js/Calendar5.js" type="text/javascript"></script>
<script>
    var c = new Calendar("c");
        document.write(c);
</script>
   <div class="row  border-bottom white-bg dashboard-header">
                <div class="col-sm-12" id="case_list">
                <div class="col-sm-12">
                  
                        <div class="col-sm-12 h_1">
	                        <div class="w3 left">序号:　　　<input type="text" id="id" name="id" /></div>
	                        <div class="w3 left">案例名称:　<input type="text" id="title" name="title" /></div>
	                        <div class="w3 left">关键字:　　<input type="text" id="keywords" name="keywords"/></div>
                        </div>
                        <div class="col-sm-12 h_1">
	                        <div class="w3 left">创建时间:　<input type="text" id="createdDate" name="createdDate" onfocus="c.showMoreDay = false;c.show(this);"/></div>
	                        <div class="w3 left">修改时间:　<input type="text" id="updatedDate" name="updatedDate" onfocus="c.showMoreDay = false;c.show(this);"/></div>
                        </div>
                        <div class="col-sm-12 h_1">
                             <div  class="col-sm-12 center">
                               <span style="margin-right:40px">
		                       <button type="submit" value="Submit" id="submit" class="submit_btn">提交</button>
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
                    <div id="casesGrid"></div>
               
                </div>
                </div>
                <div class="col-sm-12" id="case_show">
                  
                </div>
                
         

            </div>
	<script type="text/javascript">
	 var load= function(){
	 $('#casesGrid').datagrid({
        url : 'casess',
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
        queryParams:{
                    id:$("#id").val(),
                    title:$("#title").val(),
                    keywords:$("#keywords").val(),
                    createdDate:$("#createdDate").val(),
                    updatedDate:$("#updatedDate").val()
                    },
        columns : [[
           
              {title : '案例名称',field : 'title',width : 250,sortable:true,align : "center",
                  formatter:function(value,rowData,rowIndex){
                      return '<a href="Javascript:void(0);"  onclick="viewCase(\''+rowData.id+'\')">'+value+'</a>';     
                  }
              },
              {title : '关键字',field : 'keyWords',width : 350,align : "center"},
              {title : '创建时间',field : 'createdDate',width : 100,align : "center",
                  formatter:function(value,rowData,rowIndex){
                      if(value !=null){
                          return new Date(value).format('yyyy-MM-dd');
                      }else{
                          return "";
                      }
                  }
              },
              {title : '修改时间',field : 'updatedDate',width : 70,align : "center",
                  formatter:function(value,rowData,rowIndex){
                      if(value !=null){
                          return new Date().format('yyyy-MM-dd');
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
            var pg = $('#casesGrid').datagrid('getPager');
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
            url: 'case/delete/'+id,
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
     var showCase = function(id){
     var basePath = $("#basePath").html();
	     $.ajax({
	        type: "get",
	        dataType: "html",
	        url: basePath+'/case/'+id,
	        success: function (data) {
	        	if(data != ""){
	        	   $("#case_show").html(""); 
	        	   $("#case_show").append(data);
	        	}
	        }
	       });	
     };
     
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
	  load();
})
	</script>
<#include "../bottom.ftl"/>
      