<#import "parts/common.ftl" as c>

<@c.page>


<table class="table">
  <thead>
    <tr>
      <th scope="col">Number</th>
      <th scope="col">Sum</th>
      <th scope="col">Percent</th>
      <th scope="col">Duration</th>
      <th scope="col">Status</th>
    </tr>
  </thead>
  <tbody>
  <#list documents as document>
    <tr>
      <th scope="row">${document.id}</th>
      <td>${document.sum}</td>
      <td>${document.percent}</td>
      <td>${document.duration}</td>
      <td>${document.status}</td>
    </tr>
    </#list>

  </tbody>
</table>


</@c.page>