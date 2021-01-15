<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>

<#if isUser>
<h5>Name: ${customers.name}
<h5>Surname: ${customers.surname}
<h5>INN: ${customers.inn}
<h5>Age: ${coef.age}
<h5>Sex: ${coef.sex}
<h5>Bank Account: <#if coef.bankAccount>Exist<#else>Doesn't exist</#if>
<h5>Property: <#if coef.property>Exist<#else>Doesn't exist</#if>
<h5>Profession Name: ${profession.nameProfession}
<h5>Profession District: ${profession.professionDistrict}
<h5>Profession Risk: ${profession.professionRisk}
<h5>Experience: ${profession.experience} years
<p>
<p><a href="/${user.id}-${user.username}-edit">Edit</a>
</#if>

<#if isAdmin>
<h5>Name: ${workers.name}
<h5>District: ${workers.district}
</#if>

<#if isSecure>
<h5>Name: ${workers.name}
<h5>District: ${workers.district}
</#if>



</@c.page>