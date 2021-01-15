<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">


<@c.page>
<#if isEnabled>
<div class="container">
<h5>Hello, ${user.username}!
<#else>
<h5>Hello, guest!</h5>
</#if>
<div>
<p>Welcome to Zwei Bank Servise!
</div>
<div>
</@c.page>