<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/main.jsp"%>

<script>

var xmlHttp;
function cerateXMLHttpRequest(){

	  alert("11111111111");
  if(window.ActiveXObject){
	  alert("222222222");
     xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
  else if(window.XMLHttpRequest){
     
     xmlHttp = new XMLHttpReqest();
  }

}
function validate(){
	
	  cerateXMLHttpRequest();
	  alert("333333333333");
	  var phoneNo = document.getElementById("payerPhone").value;
	  var orderid = document.getElementById("orderid").value;
	  alert(phoneNo);
	  if(document.getElementById("payerPhone").value==''){
	     var mess = "";
	     var flag = "true";
	     setMessage(mess,flag);
       return false; 
    }else{
   // alert("date = "+date);
	  var url = "PhoneServlet?tblTxPayMentOrderid="+ orderid +"&phoneNo="+phoneNo;
	 // alert("url = "+url);
	  xmlHttp.open("GET",url,true);
	  xmlHttp.onreadystatechange = callback;
	  xmlHttp.send(null);
	  validateCodeButtonWait()
    }
	}
	
	//校验码每隔60秒点击一次
function validateCodeButtonWait()
{
	var secs=60;
    document.getElementById("validMobileId").value = "获取验证码 [" + secs + "]";
    	document.getElementById("validMobileId").disabled = true;
    for( I = 1; I <= secs; I++)
    {
      window.setTimeout("changeSeconds(" + I + ")", I*1000);
	}
    window.setTimeout("changeToClick()", secs*1000);
}

function changeSeconds(num)
{
     var print=60-num;
     document.getElementById("validMobileId").value = "获取验证码 [" + print + "]";
}

function changeToClick()
{
	 document.getElementById("validMobileId").disabled = false;
     document.getElementById("validMobileId").value = " 获取验证码 ";
}
	function callback(){
	  
	  if(xmlHttp.readyState == 4){
	     
	     if(xmlHttp.status == 200){
	       var mes = xmlHttp.responseXML.getElementsByTagName("message")[0].firstChild.data;
	       //alert("mes="+mes);
	       var val = xmlHttp.responseXML.getElementsByTagName("passed")[0].firstChild.data;
	       //alert("val="+val);
	       // alert("check="+document.commandBB100102.checkFlag.value);
	       if(val=="true"){
	         document.commandBB100102.checkFlag.value = "2";
	       }
	       if(val=="false"){
	         //alert("=====");
	         document.commanBB100102.checkFlag.value = "1";
	       }
	       //alert("checkflag="+document.commandBB100102.checkFlag.value);
	       setMessage(mes,val);
	     }
	  }
	}
	function setMessage(message,isValid){
	  
	  var messageArea = message;
	  //alert("messageArea="+messageArea);
	  var fontColor = "green";
	  if(isValid == "true"){
	    fontColor = "red";
	  }
	  document.getElementById("dateMessage").innerHTML = "<font color=" + fontColor+">"+ message +"</font>";
	 
	 // alert("messageArea="+messageArea);
	 // alert("setMessage star2");
	}
	
	function process1(json){
		
		var notifyUrl1 =  document.getElementById("notifyUrl").value;		
		
		if(json.statusCode == DWZ.statusCode.ok){
			if(notifyUrl1 != null && notifyUrl1 != ''){
			 window.open("<%=request.getContextPath()%>/redirect.jsp");
		}
		}
		
		navTabAjaxDone(json);
		
		
		
	}
	
</script>
<h2 class="contentTitle"><hi:text key="编辑页面"
	parameterLanguageKeys="订单查询" /></h2>
<form
	action="prepaidTxPayMentOrderFinish.action?navTabId=tblTxPayMentOrderList&callbackType=closeCurrent&ajax=1"
	method="post" class="pageForm required-validate"
	onsubmit="return validateCallback(this, process1)">
<div class="pageContent"><input type="hidden" name="notifyUrl"
	id="notifyUrl" value="${tblTxPayMentOrder.notifyUrl}" /> <input
	type="hidden" name="functionCode" id="orderid"
	value="${tblTxPayMentOrder.id}" /> <input type="hidden" name="orderId"
	id="orderid" value="${tblTxPayMentOrder.id}" /> <input type="hidden"
	name="TxStatus" id="TxStatus" value="${tblTxPayMentOrder.txStatus}" />
<div align="center">
<ul>

	<li>
	<div align="center">
	<table cellspacing="0" cellpadding="0" border="0" width="80%"
		align="center">
		<tbody>
			<br>
			<!-- 
													<tr>
														<td>
																<dl>
																	<dt><hi:text key="商品描述" entity="TblTxPayMentOrder"/>：</dt><dd> <a href=${tblTxPayMentOrder.showUrl} target="_blank" >${tblTxPayMentOrder.txBody}</a></dd>
																</dl>
														</td>
												
														<td>
															<dl>
			<dt><hi:text key="交易金额" entity="TblTxPayMentOrder"/>：</dt><dd>${tblTxPayMentOrder.orderAmount/100}</dd>
		</dl>
														</td>
													
													</tr>
													 -->
			<tr height="50px;">
				<td align="left"
					style="font-size: 120%; font-weight: bold; padding-left: 20px; width: 250px; text-align: left"
					bgcolor="#ffffff" colspan="20">商品描述：</td>
				<td><a style="font-size: 120%;"
					href=${tblTxPayMentOrder.showUrl } target="_blank">${tblTxPayMentOrder.txBody}</a></td>
			</tr>

			<c:choose>
				<c:when test="${tblTxPayMentOrder.txStatus==200800}">
					<tr height="50px;">
						<td align="left"
							style="font-size: 120%; font-weight: bold; padding-left: 20px; width: 250px; text-align: left"
							bgcolor="#ffffff" colspan="20">手机号码：</td>
						<td style="font-size: 120%;"><input id="payerPhone"
							type="text" name="tblTxPayMentOrder.payerPhone" class="textInput"
							value="" maxlength="13" /><INPUT type="button"
							style="width: 100px" name="validMobileId" id="validMobileId"
							onClick="validate(); " value="获取验证码" length="20"></td>
					</tr>

					<tr height="50px;">
						<td align="left"
							style="font-size: 120%; font-weight: bold; padding-left: 20px; width: 250px; text-align: left"
							bgcolor="#ffffff" colspan="20">手机验证码：</td>
						<td style="font-size: 120%;"><input id="verifyCode"
							type="text" name="tblTxPayMentOrder.verifyCode" class="textInput"
							value="" maxlength="13" /></td>
					</tr>

					<tr height="50px;">
						<td align="left"
							style="font-size: 120%; font-weight: bold; padding-left: 20px; width: 250px; text-align: left"
							bgcolor="#ffffff" colspan="20">交易金额：</td>
						<td style="font-size: 120%;">
						${tblTxPayMentOrder.orderAmount/100}元</td>
					</tr>


					<tr height="50px;">
						<td align="left"
							style="font-size: 120%; font-weight: bold; padding-left: 20px; width: 250px; text-align: left"
							bgcolor="#ffffff" colspan="20">应付总额：</td>
						<td style="font-size: 120%;">
						${tblTxPayMentOrder.orderAmount/100} 元</td>
					</tr>

				</c:when>

				<c:when test="${tblTxPayMentOrder.txStatus==200801}">
					<tr height="50px;">
						<td align="left"
							style="font-size: 120%; font-weight: bold; padding-left: 20px; width: 250px; text-align: left"
							bgcolor="#ffffff" colspan="20">交易金额：</td>
						<td style="font-size: 120%;">
						${tblTxPayMentOrder.orderAmount/100}元</td>
					</tr>


					<tr height="50px;">
						<td align="left"
							style="font-size: 120%; font-weight: bold; padding-left: 20px; width: 250px; text-align: left"
							bgcolor="#ffffff" colspan="20">已付总额：</td>
						<td style="font-size: 120%;">
						${tblTxPayMentOrder.orderAmount/100} 元</td>
					</tr>
				</c:when>
			</c:choose>
			<!-- 未付款 -->


			<tr height="50px;">
				<td align="left"
					style="font-size: 120%; font-weight: bold; padding-left: 20px; width: 250px;"
					bgcolor="#ffffff" colspan="20">付款状态： <br>
				</td>
				<td style="font-size: 120%;"><hi:select emu="orderTxStatus"
					name="tblTxPayMentOrder.txStatus" isLabel="true" /></td>

				<!--  
															<td align="left"
																style="font-size: 120%;font-weight: bold; padding-left: 20px; width: 250px;text-align: left;"
																bgcolor="#ffffff" colspan="20">
																<dl>
			<dd style="font-size: 120%;"><hi:select emu="orderTxStatus" name="tblTxPayMentOrder.txStatus" isLabel="true"/></dd>
		</dl>
															</td>
															-->
			</tr>

			<!-- 
														<dl>
																	<dt><hi:text key="手机号码" entity="TblTxPayMentOrder"/>：</dt><dd><input id="payerPhone"   type="text" name="tblTxPayMentOrder.payerPhone" class="textInput" value="" maxlength="13"/>
														
														
															<INPUT type="button"  style="width:100px" name="validMobileId" id="validMobileId" onClick="validate(); " value="获取验证码" length="20"><span class="red" id="registerMobile"></span></dd>
														</dl>
														<dl>
																	<dt><hi:text key="手机验证码" entity="TblTxPayMentOrder"/>：</dt><dd><input id="verifyCode"   type="text" name="tblTxPayMentOrder.verifyCode" class="textInput" value="" maxlength="13"/>
														
														
														</dl>
														 -->





		</tbody>
	</table>
	</div>
	</li>
</ul>
</div>
<c:choose>
	<c:when test="${tblTxPayMentOrder.txStatus==200800}">
		<div class="formBar">
		<ul>
			<li>
			<div class="buttonActive">
			<div class="buttonContent">
			<button type="submit"><hi:text key="支付" /></button>
			</div>
			</div>
			</li>
			<li>
			<div class="button">
			<div class="buttonContent">
			<button class="close" type="button"><hi:text key="关闭" /></button>
			</div>
			</div>
			</li>
		</ul>
		</div>
	</c:when>
</c:choose></div>
</form>
