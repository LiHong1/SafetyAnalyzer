
    <div class="white-bg border-bottom  dashboard-header center">
       <#if casesId ??><input  id="casesId" type="hidden" value="${casesId}" /> </#if>
       <#if cases ??> 
            <div style="width:800px;margin:auto">
               <#list cases as case>
                 <div id="case_title">
                     <h2 class="center">${case.title}</h2>
                  </div>
                  <div id="case_type">
                     <h5 class="center">${case.type}</h5>
                  </div>
                  <div class="pad_btm_1 center" style="font-size:14px"> ${case.content}</div>      
               </#list>
            </div> 
          
      </#if>
      <button type="submit" id="submit" class="btn btn-primary" style="margin-right:50px">提交</button>
      <button type="submit" id="cancel" class="btn btn-primary" style="margin-left:50px">取消</button>
    </div>
    
  <script>
        $(document).ready(function () {
               $("#submit").on("click",function(){
                   $.ajax({
                        type: "post",
                        dataType: "json",
                        url:window.location.href+"/"+$("#casesId").val(),
               
                        success: function (data) {
                            if (data != ''){
                                alert(data.message);
                                if(data.status==0){
                                   window.location.href = $("#basePath").html()+"/cases";
                                }
                            }
                        }
                       });  
               });
               $("#cancel").on("click",function(){
                $("#file").show();
                $("#cases").hide().empty();
               });
        });
    </script>
      