 <#include "../left.ftl"/> 
 <div class="row">
                <div class="col-lg-12">
                    <div class="wrapper wrapper-content">
                        <div class="row animated fadeInRight">
                            <div class="col-lg-12">
                                <div class="ibox float-e-margins">
                                    <div class="text-center float-e-margins p-md">
                                        <span>预览：</span>
                                        <a href="timeline_v2.html#" class="btn btn-xs btn-primary" id="lightVersion">浅色</a>
                                        <a href="timeline_v2.html#" class="btn btn-xs btn-primary" id="darkVersion">深色</a>
                                        <a href="timeline_v2.html#" class="btn btn-xs btn-primary" id="leftVersion">布局切换</a>
                                    </div>
                                    <div class="" id="ibox-content">

                                        <div id="vertical-timeline" class="vertical-container light-timeline">
                                            
                                          
                                        </div>
                                        <div class="col-lg-12">
                                             <div id="loading" class="scrollLoading" data-url="loaded.html">加载中...</div> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
<script src="${basePath}/js/plugins/jquery.scrollLoading-master/jquery.scrollLoading.src.js"></script>    
<script src="${basePath}/js/jquery-load-message.js"></script>     
<script>
$(window).scrollLoading({  
	appendTo:$("#vertical-timeline"),
	ajaxData:{
		dataType:"json",
		type:"get",
		url:$("#userId").val() + "/messages",
		data:{}
		},
		size:5
	
});


</script>              
<#include "../bottom.ftl"/>