<#import "parts/common.ftl" as c>

<@c.page>
<div class="d-flex flex-row flex-wrap">
<#list documents as document>
<#if document.isChecked()>

<#elseif document.isAccepted()>

<div class= "mr-5">
<p><h5>ID Customers: ${document.idCustomer}
<p><h5>ID Workers: ${document.idWorker}
<p><h5>Sum: ${document.sum}
<p><h5>Percent: ${document.percent}
<p><h5>Duration: ${document.duration}
<p>

<form method="post" action="/credits ">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit" name="decision" value="${document.id} APPROVED">Approve</button> <button class="btn btn-primary" type="submit" name="decision" value="${document.id} DECLINED">Decline</button>
</form>
</div>
</#if>

<#else>
Nothing to approved
</#list>
</div>
</@c.page>