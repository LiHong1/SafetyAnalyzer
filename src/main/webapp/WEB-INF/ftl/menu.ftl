 
 <#list menuItemDtos as menuItemDto>
       <li> 
           <#if menuItemDto.pId ??>
              <#assign pid= menuItemDto.pId/> 
           <#else>
               <#assign pid=""/>  
           </#if>
	       <a href="${menuItemDto.url}" id="${menuItemDto.id}" pId="${pid}" ><i class="fa fa-th-large"></i> <span class="nav-label">${menuItemDto.name}</span> <span class="fa arrow"></span></a>
	   </li>
 </#list> 
