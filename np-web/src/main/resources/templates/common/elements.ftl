<#macro pageNav total = "1" current = "1" urlpattern="#">
    <#assign totalInt = total?number?int />
    <#assign currentInt = current?number?int />
    <#if totalInt lte 1>
        <#return />
    </#if>
    <div class="col-sm-6">
        <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
            <ul class="pagination">
                <#if currentInt gt 1>
                 <li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous">
                     <a href="${urlpattern?replace("%d", "" + (currentInt - 1))}">Previous</a>
                 </li>
                </#if>
                <li class="paginate_button  <#if currentInt == 1>active</#if>" aria-controls="dataTables-example" tabindex="0">
                    <a href="${urlpattern?replace("%d", "1")}">1</a>
                </li>
                <#assign p1 = 2 />
                <#if currentInt gte 6>
                    <#assign p1 = (currentInt - 4) />
                </#if>
                <#assign p2 = 10 />
                <#if currentInt gte 6>
                    <#assign p2 = (currentInt + 5) />
                </#if>
                <#if currentInt gt (totalInt - 5)>
                    <#assign p1 = (totalInt - 9) />
                </#if>
                <#if p1 gt 2>
                <li class="paginate_button" aria-controls="dataTables-example" tabindex="0">
                    <a href="${urlpattern?replace("%d", "" + (currentInt - 5))}">${currentInt - 5}</a>
                </li>
                </#if>
                <#list p1 .. p2 as i>
                    <#if i gte 2>
                        <#if i gte totalInt>
                            <#break />
                        </#if>
                        <li class="paginate_button <#if currentInt == i>active</#if>" aria-controls="dataTables-example" tabindex="0">
                            <a href="${urlpattern?replace("%d", "" + i)}">${i}</a>
                        </li>
                    </#if>
                </#list>
                <#if p2 lt totalInt>
                <li class="paginate_button" aria-controls="dataTables-example" tabindex="0">
                    <a href="${urlpattern?replace("%d", "" + (p2 + 1))}">${p2 + 1}</a>
                </li>
                </#if>
                <#if currentInt lt totalInt>
                    <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next">
                        <a href="${urlpattern?replace("%d", "" + (currentInt + 1))}">Next</a>
                    </li>
                </#if>
            </ul>
        </div>
    </div>
</#macro>