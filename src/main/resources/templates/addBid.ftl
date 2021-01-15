<#import "parts/common.ftl" as c>

<@c.page>
<form action="/add" method="post">
    <p><input type="number" name="sum" placeholder="Enter sum" />
    <p><input type="number" name="percent" placeholder="Enter percent" />
    <p><input type="number" name="duration" placeholder="Enter duration" />
        <input type="hidden" value="${_csrf.token}" name="_csrf">
    <p><button class="btn btn-primary" type="submit">Submit</button>

</form>

</@c.page>