<#include "../left.ftl"/> 
                <div class="col-sm-12">
                <div class="col-sm-12">
                    <form id="keyword">
                        <div class="col-sm-12 h_1">
	                        <div class="w3 left">序号:　　　<input type="text" name="id"/></div>
	                        <div class="w3 left">关键字:　　<input type="text" name="keywords"/></div>
                        </div>
                        <div class="col-sm-12 h_1">
	                        <div class="w3 left">创建时间:　<input type="text" name="createDate"/></div>
	                        <div class="w3 left">修改时间:　<input type="text" name="updateDate"/></div>
                        </div>
                        <div class="col-sm-12 h_1">
                             <div  class="col-sm-12 center">
                               <span style="margin-right:40px">
		                       <button type="submit" value="Submit" class="submit_btn">提交</button>
		                       </span>
		                        <span style="margin-left:40px">
		                       <button type="reset" value="Reset" class="reset_btn">重置</button>
		                       </span>
		                     </div>
		                    
                        </div>
                    </form>
                </div>
                <div class="col-sm-12 top_dash pad_btm_1">
                    <div id="casesGrid" style="width:400px"></div>
               
                </div>
                </div>
                <div class="col-sm-12" id="case_show">
                  
                </div>
                
         

            </div>
	<script type="text/javascript">
     var viewCase = function(id){
       showCase(id);
       $("#case_list").hide();
       $("#case_show").show();
     };
     var showCase = function(id){
	     $.ajax({
	        type: "get",
	        dataType: "html",
	        url: '/case/'+id,
	        success: function (data) {
	        	if(data != ""){
	        	   $("#case_show").html(""); 
	        	   $("#case_show").append(data);
	        	}
	        }
	       });	
     };
	$(function(){
		$('#casesGrid').datagrid({
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
	  
	
		
		})
	</script>
<#include "../bottom.ftl"/>
      