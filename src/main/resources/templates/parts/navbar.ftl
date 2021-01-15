<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <img src="https://github.com/sonixal/img/blob/main/Logo.png?raw=true" height=3%, width=3%>
    <a class="navbar-brand" href="/">Zwei Bank</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/bid-a">All bid</a>
            </li>
             <li class="nav-item">
                 <a class="nav-link" href="/credits">Approve credits</a>
             </li>
             <li class="nav-item">
                 <a class="nav-link" href="/show-credits">Show credits</a>
             </li>
            </#if>
            <#if isUser>
            <li class="nav-item">
                <a class="nav-link" href="/add">Add bid</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/${user.id}-bid">Your bid</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/${user.id}-credits">Your credits</a>
            </li>
            </#if>
            <#if isSecure>
            <li class="nav-item">
                <a class="nav-link" href="/bid">All bid</a>
            </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">
        <#if isEnabled>
        <#if isAdmin>
            <a href="/${user.id}-${user.username}-a">${name}</a>
        <#elseif isSecure>
            <a href="/${user.id}-${user.username}-a">${name}</a>
         <#else>
            <a href="/${user.id}-${user.username}">${name}</a>
         </#if>
         <#else>
         ${name}
         </#if>
        </div>
        <@l.logout />
    </div>
</nav>