<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<#if isSecure>
<div class="d-flex flex-row flex-wrap">
<#list documents as document>
<#if document.isWaited()>
<div class= "mr-5">
<h5>Sum: ${document.sum}
<h5>Percent: ${document.percent}
<h5>Duration: ${document.duration}
<h5>Status: ${document.status}
<h5>Duran Coefficient: ${document.coef}
<p>
<form method="post" action="/bid">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit" name="decision" value="${document.id} ACCEPTED">Accept</button> <button class="btn btn-primary" type="submit" name="decision" value="${document.id} DECLINED">Decline</button>
</form>
</div>
<#else>
</#if>
<#else>
Nothing to accepted
</#list>
</div>
</#if>

<#if isAdmin>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Number</th>
      <th scope="col">ID Customer</th>
      <th scope="col">Sum</th>
      <th scope="col">Percent</th>
      <th scope="col">Duration</th>
      <th scope="col">Status</th>
      <th scope="col">Duran coefficient</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
<#list documents as document>
    <tr>
      <th scope="row">${document.id}</th>
      <td>$${document.idCustomer}</td>
      <td>${document.sum}</td>
      <td>${document.percent}</td>
      <td>${document.duration}</td>
      <td>${document.status}</td>
      <td>${document.coef}</td>
       <td><form action="/bid-a" method="get">
       <input type="hidden" value="${document.id}" name="id">
       <input type="hidden" value="${_csrf.token}" name="_csrf">
       <button type="submit" class="close" aria-label="Close">
           <span aria-hidden="true">&times;</span>
       </button></form></td>

    </tr>
    </#list>

  </tbody>
</table>

</#if>
</@c.page>