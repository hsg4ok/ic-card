<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">

<beans>
<#list service.entity as entity><#if entity.entityType != 2>
<#include "appContext-dao.ftl">
<#include "appContext-business.ftl">
</#if>
</#list>
</beans>