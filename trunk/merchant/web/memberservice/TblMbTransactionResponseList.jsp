<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<form id="pagerForm" action="tblMbTransactionResponseList.action">
	<input type="hidden" name="pageInfo.currentPage" value="${pageInfo.currentPage}" />
	<input type="hidden" name="pageInfo.sorterName" value="${pageInfo.sorterName}" />
	<input type="hidden" name="pageInfo.sorterDirection" value="${pageInfo.sorterDirection}" />
	<input type="hidden" name="lookup" value="${lookup}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="tblMbTransactionResponseList.action?lookup=${lookup}" onsubmit="return dwzSearch(this, '${targetType}');">
	<input type="hidden" name="pageInfo.pageSize" value="${pageInfo.pageSize}" />
	<div class="searchBar">
		<ul class="searchContent">	
			<li>
				<label><hi:text key="对应的系统订单号" entity="TblMbTransactionResponse"/>:</label>
				<input type="text" name="pageInfo.f_ordedId" value="${pageInfo.f_ordedId}"/>
			</li>	  
			<li>
				<label><hi:text key="交易系统的机构号" entity="TblMbTransactionResponse"/>:</label>
				<input type="text" name="pageInfo.f_orgId" value="${pageInfo.f_orgId}"/>
			</li>	  
			<li>
				<label><hi:text key="交易系统的交易流水号" entity="TblMbTransactionResponse"/>:</label>
				<input type="text" name="pageInfo.f_orgOrdedId" value="${pageInfo.f_orgOrdedId}"/>
			</li>	  
			<li class="dateRange">
				<label><hi:text key="创建时间" entity="TblMbTransactionResponse"/>:</label>
				<input type="text" name="pageInfo.f_createdDatetime" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime_op" value="&gt;="><span class="limit">-</span>
				<input type="text" name="pageInfo.f_createdDatetime01" class="date" readonly="readonly" value="<fmt:formatDate value='${pageInfo.f_createdDatetime01}' pattern='yyyy-MM-dd'/>"/>
				<input type="hidden" name="pageInfo.f_createdDatetime01_op" value="&lt;=">
			</li>	  
		</ul>
		<div class="subBar">
			<div class="buttonActive"><div class="buttonContent"><button type="submit"><hi:text key="查询"/></button></div></div>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		<c:choose>
			<c:when test="${empty lookup}">
				<authz:authorize ifAnyGranted="TBLMBTRANSACTIONRESPONSE_SAVE"><li><a class="add" href="<hi:url>tblMbTransactionResponseEdit.action?tblMbTransactionResponse.id=-1</hi:url>" target="navTab" rel="tblMbTransactionResponse"><span><hi:text key="新建" parameterLanguageKeys="网关交易结果"/></span></a></li></authz:authorize>
				<authz:authorize ifAnyGranted="TBLMBTRANSACTIONRESPONSE_DEL"><li><a class="delete" href="<hi:url>tblMbTransactionResponseRemoveAll.action?ajax=1</hi:url>" target="removeSelected" title="<hi:text key="确实要删除这些记录吗?"/>"><span><hi:text key="批量删除"/></span></a></li></authz:authorize>
			</c:when>
			<c:otherwise>
				<li><a class="icon" href="javascript:$.bringBack({id:'-1', ordedId:'',orgId:'',orgOrdedId:'',amount:'',sourceIp:'',createdDatetime:''})"><span><hi:text key="重置"/></span></a></li>
			</c:otherwise>
		</c:choose>			
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138" targetType="${targetType}">
		<thead>
			<tr>
				<c:if test="${empty lookup}">
				<th width="28"><input type="checkbox" group="orderIndexs" class="checkboxCtrl"></th>
				</c:if>
				<th orderField="ordedId" class="${pageInfo.sorterName eq 'ordedId' ? pageInfo.sorterDirection : ''}"><hi:text key="对应的系统订单号" entity="TblMbTransactionResponse"/></th>
				<th orderField="orgId" class="${pageInfo.sorterName eq 'orgId' ? pageInfo.sorterDirection : ''}"><hi:text key="交易系统的机构号" entity="TblMbTransactionResponse"/></th>
				<th orderField="orgOrdedId" class="${pageInfo.sorterName eq 'orgOrdedId' ? pageInfo.sorterDirection : ''}"><hi:text key="交易系统的交易流水号" entity="TblMbTransactionResponse"/></th>
				<th orderField="amount" class="${pageInfo.sorterName eq 'amount' ? pageInfo.sorterDirection : ''}"><hi:text key="交易金额" entity="TblMbTransactionResponse"/></th>
				<th orderField="sourceIp" class="${pageInfo.sorterName eq 'sourceIp' ? pageInfo.sorterDirection : ''}"><hi:text key="发送报文的IP地址" entity="TblMbTransactionResponse"/></th>
				<th orderField="createdDatetime" class="${pageInfo.sorterName eq 'createdDatetime' ? pageInfo.sorterDirection : ''}"><hi:text key="创建时间" entity="TblMbTransactionResponse"/></th>
				<th width="90">
					<c:choose>
						<c:when test="${empty lookup}"><hi:text key="操作"/></c:when>
						<c:otherwise><hi:text key="查找带回"/></c:otherwise>
					</c:choose>
				</th>
			</tr>
		</thead>				
		<tbody>
			<c:forEach var="item" items="${tblMbTransactionResponses}" varStatus="s">
			<tr>
				<c:if test="${empty lookup}">
				<td><input name="orderIndexs" value="${item.id}" type="checkbox"></td>
				</c:if>			
				    <td>${item.ordedId}</td>
				    <td>${item.orgId}</td>
				    <td>${item.orgOrdedId}</td>
				    <td>${item.amount}</td>
				    <td>${item.sourceIp}</td>
				    <td><fmt:formatDate value="${item.createdDatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
				<c:choose>
					<c:when test="${empty lookup}">
				    <authz:authorize ifAnyGranted="TBLMBTRANSACTIONRESPONSE_DEL">
				      <a class="btnDel" href="<hi:url>tblMbTransactionResponseRemove.action?ajax=1&tblMbTransactionResponse.id=${item.id}</hi:url>" target="navTabTodo" title="<hi:text key="删除" parameterLanguageKeys="网关交易结果"/>"><hi:text key="删除"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBTRANSACTIONRESPONSE_VIEW">
				      <a class="btnView" href="<hi:url>tblMbTransactionResponseView.action?tblMbTransactionResponse.id=${item.id}</hi:url>" target="navTab" rel="tblMbTransactionResponse" title="<hi:text key="查看" parameterLanguageKeys="网关交易结果"/>"><hi:text key="查看"/></a>
				    </authz:authorize>
				    <authz:authorize ifAnyGranted="TBLMBTRANSACTIONRESPONSE_SAVE">
				      <a class="btnEdit" href="<hi:url>tblMbTransactionResponseEdit.action?tblMbTransactionResponse.id=${item.id}</hi:url>" target="navTab" rel="tblMbTransactionResponse" title="<hi:text key="编辑" parameterLanguageKeys="网关交易结果"/>"><hi:text key="编辑"/></a>
				    </authz:authorize>
					</c:when>
					<c:otherwise>
						<a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', ordedId:'${item.ordedId}',orgId:'${item.orgId}',orgOrdedId:'${item.orgOrdedId}',amount:'${item.amount}',sourceIp:'${item.sourceIp}',createdDatetime:'${item.createdDatetime}'})" title="<hi:text key="查找带回"/>"><hi:text key="选择"/></a>
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>	
	<div class="panelBar">
		<div class="pages">
			<span><hi:text key="每页"/></span>
			<c:set var="pageSizeList" value="${fn:split('10|20|50|100', '|')}"/>  
			<select name="pageInfo.pageSize" onchange="dwzPageBreak({targetType:'${targetType}', numPerPage:this.value})">
				<c:forEach var="item" items="${pageSizeList}">
				<option value="${item}" ${item eq pageInfo.pageSize ? 'selected="selected"' : ''}>${item}</option>
				</c:forEach>
			</select>
			<span><hi:text key="条"/>，<hi:text key="共"/>${pageInfo.totalRecords}<hi:text key="条"/></span>
		</div>
		<div class="pagination" targetType="${targetType}" totalCount="${pageInfo.totalRecords}" numPerPage="${pageInfo.pageSize}" pageNumShown="${pageInfo.middlePageNum*2}" currentPage="${pageInfo.currentPage}"></div>
	</div>
</div>