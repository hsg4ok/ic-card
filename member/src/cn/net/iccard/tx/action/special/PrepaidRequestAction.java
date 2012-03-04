package cn.net.iccard.tx.action.special;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hi.SpringContextHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.security.context.UserContextHelper;
import org.hi.framework.web.PageInfoUtil;
import org.hi.framework.web.struts.BaseAction;

import cn.net.iccard.tx.action.TblTxPayMentOrderPageInfo;
import cn.net.iccard.tx.action.TblTxPayMentRequestPageInfo;
import cn.net.iccard.tx.model.TblTxPayMentOrder;
import cn.net.iccard.tx.model.TblTxPayMentRequest;
import cn.net.iccard.tx.service.TblTxPayMentOrderManager;
import cn.net.iccard.tx.service.TblTxPayMentRequestManager;
import cn.net.iccard.tx.service.impl.TblTxPayMentOrderManagerImpl;
import cn.net.iccard.tx.service.impl.TblTxPayMentRequestManagerImpl;
import cn.net.iccard.util.PLTraceNoGererator;
import cn.net.iccard.util.StringUtil;

//预支付交易处理

public class PrepaidRequestAction extends BaseAction{

	
	
	
	//接收商户请求处理
	public void getMchtRequest() throws Exception {
		

	   
		//1.取得商户请求
		HttpServletRequest request = getRequest();
		
		HttpServletResponse response = getResponse();
		
		 try {
		      request.setCharacterEncoding("GBK");
		      String contentType = new StringBuffer("text/html; charset=").append("GBK").toString();
		      response.setContentType(contentType);
		    } catch (Exception e) {
		      //logger.error("", e);
		    }
			
		String msg = request.getParameter("TxInfo");			//报文域
		String Signature = request.getParameter("Signature");	//报文签名
		String TxType = request.getParameter("TxType");			//交易类型
		
		// 解析银行回应交易结果字段
        String[] tPlainStr = StringUtil.split(msg, "|");
        Properties tBankPlain = new Properties();
        String[] tStrTemp = null;
        for (int i = 0; i < tPlainStr.length; i++) {
            tStrTemp = StringUtil.split(tPlainStr[i], "=");
            tBankPlain.setProperty(tStrTemp[0], tStrTemp[1]);
        }
		
		
		if(TxType.equals("TX11")){
			
			//解析txinfo
			String MchtTxTraceNo = tBankPlain.getProperty("MchtTxTraceNo");   //商户交易流水号
			String TxAmount = tBankPlain.getProperty("TxAmount");				//交易金额
			String MerchantNo = tBankPlain.getProperty("MerchantNo");			//商户代码
			String TxDate = tBankPlain.getProperty("TxDate");					//交易日期
			String TxTime = tBankPlain.getProperty("TxTime");					///交易时间
			String TxBody = tBankPlain.getProperty("TxBody");					//商品描述
			String ShowUrl = tBankPlain.getProperty("ShowUrl");					//商品展示URL 
			String UseCoupon = tBankPlain.getProperty("UseCoupon");				//	是否使用优惠券					
			String CouponMsg = tBankPlain.getProperty("CouponMsg");					//	优惠券信息
			String NotifyURL = tBankPlain.getProperty("NotifyURL");				//交易结果通知地址
			String BGNotifyURL = tBankPlain.getProperty("BGNotifyURL");				//交易结果后台通知地址
			String ExtendInfo = tBankPlain.getProperty("ExtendInfo");				//扩展域
			String certID = tBankPlain.getProperty("CertID");						//商户证书ID
			//String cert = thnCertID.getProperty(certID);
			
			//1.验证商户请求报文
			
			//2.记录请求表
			TblTxPayMentRequestManager tblTxPayMentRequestMgr = (TblTxPayMentRequestManager)SpringContextHolder.getBean(TblTxPayMentRequest.class);

			TblTxPayMentRequest tblTxPayMentRequest = new TblTxPayMentRequest();
			tblTxPayMentRequest.setMchtTxTraceNo(MchtTxTraceNo);	//商户交易流水号
			tblTxPayMentRequest.setMchtNo(MerchantNo);				//商户号	
			tblTxPayMentRequest.setAmount(TxAmount);				//交易金额
			tblTxPayMentRequest.setMchtTxTime(TxTime);				//商户交易日期
			tblTxPayMentRequest.setTxTypeId(TxType);				//交易类型
			tblTxPayMentRequest.setMsgext(msg);						//原始交易报文
			tblTxPayMentRequest.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
			//tblTxPayMentRequest.setLastUpdatedBy();     	//最后修改人
			tblTxPayMentRequest.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
			
			tblTxPayMentRequestMgr.saveTblTxPayMentRequest(tblTxPayMentRequest);
			
			
			//3.记录订单表
			TblTxPayMentOrderManager TblTxPayMentOrderMan = (TblTxPayMentOrderManager)SpringContextHolder.getBean(TblTxPayMentOrder.class);
			
			TblTxPayMentOrder TblTxPayMentOrder= new TblTxPayMentOrder();
			
			String plTxTraceNo = PLTraceNoGererator.generatePLTraceNo("00");
			TblTxPayMentOrder.setPlTxTraceNo(plTxTraceNo);
			TblTxPayMentOrder.setTxTypeId("TX11");
			TblTxPayMentOrder.setMchtNo(MerchantNo);
			
			TblTxPayMentOrder.setMchtTxTraceNo(MchtTxTraceNo);
			TblTxPayMentOrder.setTxAmount(new BigDecimal(TxAmount).movePointRight(2).intValue());		//精确到分
			TblTxPayMentOrder.setNotifyUrl(NotifyURL);
			TblTxPayMentOrder.setShowUrl(ShowUrl);
			TblTxPayMentOrder.setTxBody(TxBody);
			TblTxPayMentOrder.setTxStatus(1);
			TblTxPayMentOrder.setCreatedDatetime(new Timestamp(System.currentTimeMillis())); //创建时间
			TblTxPayMentOrder.setLastUpdatedDatetime(new Timestamp(System.currentTimeMillis()));//最后修改时间
			
			TblTxPayMentOrderMan.saveTblTxPayMentOrder(TblTxPayMentOrder);
			
			//4.保存session
			request.getSession(true).setAttribute("plTxTraceNo", plTxTraceNo);
		}
		
	}
	
	//预支付 确认
	public void upfrontCostAffirm() throws Exception {
		

	   
		//1.取得请求信息
		HttpServletRequest request = getRequest();
		
		HttpServletResponse response = getResponse();
		
		 try {
		      request.setCharacterEncoding("GBK");
		      String contentType = new StringBuffer("text/html; charset=").append("GBK").toString();
		      response.setContentType(contentType);
		    } catch (Exception e) {
		      //logger.error("", e);
		    }
			
		//取得请求信息，调用账户系统进行扣款，扣款成功后
		String msg = request.getParameter("TxInfo");			//报文域
		String Signature = request.getParameter("Signature");	//报文签名
		String TxType = request.getParameter("TxType");			//交易类型
		
		//修改对应交易记录状态    
		//先查询支付订单表
		
//		TblTxPayMentOrderPageInfo tblTxPayMentOrderPageInfo= new TblTxPayMentOrderPageInfo();
//		
//		tblTxPayMentOrderPageInfo.setF_mchtTxTraceNo(request.getParameter("plTxTraceNo"));
		
		
		
		Filter filter = FilterFactory.getSimpleFilter("mchtTxTraceNo",request.getParameter("plTxTraceNo"), Filter.OPERATOR_EQ);
		
		//Filter Filter = PageInfoUtil.populateFilter(tblTxPayMentOrderPageInfo);
		System.out.println(filter);
		TblTxPayMentOrderManagerImpl TblTxPayMentOrderManagerImpl = new TblTxPayMentOrderManagerImpl();
		List list  = TblTxPayMentOrderManagerImpl.getObjects(TblTxPayMentOrder.class,filter);
		
		//更新支付订单表
		TblTxPayMentOrder TblTxPayMentOrder = (TblTxPayMentOrder)list.get(0);
		TblTxPayMentOrder.setTxStatus(2);
		TblTxPayMentOrder.setLastUpdatedBy(Integer.valueOf(request.getParameter("username")));
		
		//记录支付结果通知表并通知商户
		
		
		
		}
		
	
	
}
