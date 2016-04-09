 <div style="width:800px;margin:auto">
           <#if cases[0] ??>
             <div id="case_title">
                 <h2 class="center">${cases[0].title}</h2>
             </div>
             <p class="center">创建时间：${cases[0].createDate?if_exists } </br></p>
             <span style="margin-bttom:20px">检索关键字：${cases[0].keywords?if_exists }</span>
             <div class="top_dash pad_btm_1 center margin_top_" style="font-size:14px"> ${cases[0].content}</div>
            
		           <#if (cases?size==2)>
		               <#if (cases[0].id>cases[1].id)>
		               	上一篇:<a href="Javascript:void(0);" onclick="viewCase(${cases[1].id?if_exists})">${cases[1].title?if_exists}</a>
		               <#else>
		               	下一篇:<a href="Javascript:void(0);" onclick="viewCase(${cases[1].id?if_exists})">${cases[1].title?if_exists}</a>
		               	</#if>
		           </#if>
		           <#if (cases?size==3)>
		          <div class="col-sm-12">上一篇:<a href="Javascript:void(0);" onclick="viewCase(${cases[1].id?if_exists})">${cases[1].title?if_exists}</a></br>
		                               	   下一篇:<a href="Javascript:void(0);" onclick="viewCase(${cases[2].id?if_exists})">${cases[2].title?if_exists}</a></div>
		          </#if>
		           
           </#if>
</div>

