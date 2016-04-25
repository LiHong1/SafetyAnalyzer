<#include "../left.ftl"/> 
    <link href="${basePath}/css/plugins/dropzone/basic.css" rel="stylesheet">
    <link href="${basePath}/css/plugins/dropzone/dropzone.css" rel="stylesheet">
    <link href="${basePath}/css/style.css?v=2.2.0" rel="stylesheet">
    <div class="row  border-bottom  dashboard-header ">
              
                      <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>案例导入:</h5> <span style="margin-left:30px"><a href="">案例模板下载</a></span>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="form_file_upload.html#">
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-user">
                                        <li><a href="form_file_upload.html#">选项1</a>
                                        </li>
                                        <li><a href="form_file_upload.html#">选项2</a>
                                        </li>
                                    </ul>
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            
                             <div id="file" class="ibox-content">
                                <form id="my-awesome-dropzone" class="dropzone" action="/">
                                    <div class="dropzone-previews"></div>
                                    <button type="submit" class="btn btn-primary pull-right">提交</button>
                                </form>
                                <div>
                                    <div class="m"></div>
                                </div>
                            </div>
                            
                            <div id="cases"  style="display:none">
                                
                            </div>
                            
                       </div>
             
               
             

    </div>
    <!-- DROPZONE -->
    <script src="${basePath}/js/plugins/dropzone/dropzone.js"></script>
    
    <script>
        $(document).ready(function () {
            var url = document.location.href;
            $("#my-awesome-dropzone").attr("action",url);
            Dropzone.options.myAwesomeDropzone = {

                autoProcessQueue: false,
                uploadMultiple: false,
                parallelUploads: 100,
                maxFiles: 1,
                fileTypes:['.xls'],
                afterSuccess:function(responseText){
                $("#file").hide();
                $("#cases").show().append(responseText);
                    
                },

                // Dropzone settings
                init: function () {
                    var myDropzone = this;

                    this.element.querySelector("button[type=submit]").addEventListener("click", function (e) {
                        e.preventDefault();
                        e.stopPropagation();
                        myDropzone.processQueue();
                         
                    });
                    this.on("sendingmultiple", function () {});
                    this.on("successmultiple", function (files, response) {});
                    this.on("errormultiple", function (files, response) {});
                }

            }
            
           

        });
    </script>
    
<#include "../bottom.ftl"/>
      