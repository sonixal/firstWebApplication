<#assign
    know = Session.SPRING_SECURITY_CONTEXT??
>

<#if know>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isAdmin = user.isAdmin()
        isUser = user.isUser()
        isSecure = user.isSecure()
        isEnabled = user.isEnabled()

    >
<#else>
       <#assign
            name = "unknown"
            isAdmin = false
            isUser = false
            isSecure = false
            isEnabled = false
       >
</#if>