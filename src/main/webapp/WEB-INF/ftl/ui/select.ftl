<#macro select list defaultOptions optionName optionValue value extendCss class id name>
<select class="${class}" style="${extendCss}" id="${id}" name="${name}">
<#list defaultOptions?keys as key>
<#if key==value>
<option value="${key}" selected="selected" style="color:#999">${defaultOptions[key]}</option>
<#else>
<option value="${key}">${defaultOptions[key]}</option>
</#if>
</#list>
 
<#if list?is_enumerable>
    <#list list as item>
        <#if item?is_hash>
        <#local option_Value = item[optionValue]!item/> 
        <#local option_Name = item[optionName]!item/>
        <#else>
        <#local option_Value = item/>
        <#local option_Name = item/>
        </#if>
         
        <#if (option_Value?string)==value>
        <option value="${option_Value}" selected="selected">${option_Name}</option>
        <#else>
        <option value="${option_Value}">${option_Name}</option>
        </#if>
    </#list> 
<#elseif list?is_hash_ex>
    <#list list?values as item>
        <#local option_Name = item/>
        <#local option_Value = list?keys[item_index]/>
        <#if (option_Value?string)==value>
        <option value="${option_Value}" selected="selected">${option_Name}</option>
        <#else>
        <option value="${option_Value}">${option_Name}</option>
        </#if>
    </#list> 
</#if>
<#nested>
</select>
</#macro>