<#include "../left.ftl"/> 
<#include "../ui/select.ftl"/>
    <link href="${basePath}/css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="${basePath}/css/plugins/summernote/summernote-bs3.css" rel="stylesheet"> 
    <link href="${basePath}/css/style.css?v=2.2.0" rel="stylesheet">
    <div class="row  border-bottom  dashboard-header ">
                        <div class="col-sm-12">
                           <div class="col-sm-12  white-bg pad_top_1" style="padding-left:0px;padding-right:0px">
                                             <div class="col-sm-12">
                                                  <label class="col-sm-1 control-label m-b f-s-2">类型:</label>
                                                  <div class="col-sm-4">
                                                        <@select list=caseType value='0' optionName="value" optionValue="id" defaultOptions= {"":"--请选择类型--"}  class="form-control m-b" extendCss="color:#999" id="caseType" name="type"/> 
                                                    </div>
                                             </div>
                                            <div class="col-sm-12"> 
                                                 <label class="col-sm-1 control-label m-b f-s-2">标题:</label>
                                                 <div class="col-sm-4">
                                                     <input type="text" id="title" name="title" placeholder="请输入案例标题" class="form-control" required="required"/>
                                                </div>
                                            </div>
                                 
                                                         
                                	       <div class="col-sm-12  center pad_top_1">
                                                	  <div class="ibox float-e-margins">
                                                            <div class="ibox-title">
                                                                <h5>内容编辑</h5>
                                                                <div class="ibox-tools">
                                                                    <a class="collapse-link">
                                                                        <i class="fa fa-chevron-up"></i>
                                                                    </a>
                                                                    <a class="dropdown-toggle" data-toggle="dropdown" href="form_editors.html#">
                                                                        <i class="fa fa-wrench"></i>
                                                                    </a>
                                                                  
                                                                    <a class="close-link">
                                                                        <i class="fa fa-times"></i>
                                                                    </a>
                                                                 </div>
                                                              </div>
                                                              <div class="ibox-content no-padding">
                                                                    <div class="summernote">
                                                                    </div>                  
                                                              </div>
                                                      </div>
                                             </div>
                                         
                                             <div class="col-sm-12 h_1">
                                                     <div  class="col-sm-12 center">
                                                       <span style="margin-right:40px">
                                                       <button type="submit" value="Submit" class="submit_btn" id="submit_btn">提交</button>
                                                       </span>
                                                        <span style="margin-left:40px">
                                                       <button type="reset" value="Reset" class="reset_btn">重置</button>
                                                       </span>
                                                     </div>
                                            
                                             </div>
                       </div>            
                 </div>              

     </div>
   <!-- SUMMERNOTE -->
    <script src="${basePath}/js/plugins/summernote/summernote.min.js"></script>
    <script src="${basePath}/js/plugins/summernote/summernote-zh-CN.js"></script>

    <script>
    
       var edit = function () {
            $("#eg").addClass("no-padding");
            $('.click2edit').summernote({
                lang: 'zh-CN',
                focus: true
            });
        };
        var save = function () {
            $("#eg").removeClass("no-padding");
            var aHTML = $('.click2edit').code(); //save HTML If you need(aHTML: array).
            $('.click2edit').destroy();
        };
        $(document).ready(function () {
            $('.summernote').summernote({ 
                lang: 'zh-CN'
            });
            
             $("#submit_btn").bind("click", function(){
             
               $.ajax({
                type: "post",
                dataType: "json",
                url:'',
                data:{'content':$(".note-editable").html(),'title':$("#title").val(),'type':$("#caseType").val()},
                success: function (data) {
                    if (data != ''){
                         alert(data.message);
                        if( data.status == 0 ){
                         window.location.href = $("#basePath").html()+"/cases";
                        }else{
                          
                        }
                    }
                }
               });  
             });

        });
       
    </script>
<#include "../bottom.ftl"/>
      