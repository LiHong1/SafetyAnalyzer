(function($){
		
		$.ajax({
	        type: "get",
	        dataType: "html",
	        url: '/menus',
	        success: function (data) {
	        	  $.fn.getSiblingMenu(window.location.pathname);
	            if (data != "") {
	                $("#side-menu").append(data);
	                $("#side-menu").children().on("click",function(event){
	                	//如果已经打开
	                	if($(this).hasClass("active")){
	                	   $(this).removeClass("active");
	                	}else {
	                		 $("#side-menu").children().removeClass("active");
	                		 var uls = $(this).addClass("active").find("ul");
	 	        			 var id = $(this).find("a").attr("id");
	 		        			if(uls.length == 0){
	 		        				$.fn.getChildren(id,$(this));
	 		        			}
	 		        			
	 		        			    
	 	                }
	 	                	   
	                		
	        		});
	             
	            }
	          
	        }
	       });	
		
	    //获取子菜单
		$.fn.getChildren = function(parentId, obj){
			$.ajax({
		        type: "get",
		        dataType: "json",
		        url: '/menus/'+parentId,
		        success: function (data) {
		        	var menuChild = "<ul class='nav nav-second-level collapse in'>";
			        	for(var i = 0 ;i<data.length;i++){
			        		menuChild += "<li><a href="+data[i].url+">"+data[i].name+"</a></li>";
			        	}
			        	menuChild += "</ul>";
			        	obj.append(menuChild);
		        	}
		       });	
		};
		
		//获取地址为url的，同级菜单
		$.fn.getSiblingMenu = function(url){
			$.ajax({
		        type: "post",
		        dataType: "json",
		        url: '/siblingMenus',
		        data:{'url':url},
		        success: function (data) {
		        	if (data != ''){
		        		var menuChild = "<ul class='nav nav-second-level collapse in'>";
			        	for(var i = 0 ;i<data.length;i++){
			        		menuChild += "<li><a href="+data[i].url+">"+data[i].name+"</a></li>";
			        	}
			            var lis = $("#side-menu").children();
			            for(var i = 1 ; i < lis.length ; i++){
			            	var id = $(lis[i]).find("a").attr("id");
			        		if(id == data[0].pid){
			        			$(lis[i]).append(menuChild).addClass("active");
			        		};
			            };
		        	}
		        }
		       });	
		}
		
	
			
		
})(jQuery);