<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>

<#if isAdmin>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/show-credits" class="form-inline">
            <input type="number" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by ID Document">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>

</#if>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Number</th>
      <th scope="col">ID Customer</th>
      <th scope="col">ID Document</th>
      <th scope="col">ID Worker</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
<#list credits as credit>
    <tr>
      <th scope="row">${credit.id}</th>
      <td>${credit.idCustomers}</td>
      <td>${credit.idDocument}</td>
      <td>${credit.idWorkers}</td>
      <#if isAdmin>
       <td><form action="/show-credits" method="get">
       <input type="hidden" value="${credit.id}" name="id">
       <input type="hidden" value="${_csrf.token}" name="_csrf">
       <button type="submit" class="close" aria-label="Close">
           <span aria-hidden="true">&times;</span>
       </button></form></td>
       </#if>
    </tr>
    <#else>

    </#list>

  </tbody>
</table>



</@c.page>