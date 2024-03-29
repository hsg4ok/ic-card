package cn.net.iccard.tx.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;
import org.hi.base.organization.action.HiUserPageInfo;

public class TblTxTransferPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_plTxTraceNo;
 	protected  String  f_plTxTraceNo_op;
	protected  String  f_userName;
 	protected  String  f_userName_op;
	protected  String  f_txTypeId;
 	protected  String  f_txTypeId_op;
	protected  String  f_mchtNo;
 	protected  String  f_mchtNo_op;
	protected  String  f_mchtTxTime;
 	protected  String  f_mchtTxTime_op;
	protected  String  f_mchtTxTraceNo;
 	protected  String  f_mchtTxTraceNo_op;
	protected  Integer  f_txAmount;
 	protected  String  f_txAmount_op;
	protected  String  f_notifyUrl;
 	protected  String  f_notifyUrl_op;
	protected  String  f_txIp;
 	protected  String  f_txIp_op;
	protected  String  f_plTxTime;
 	protected  String  f_plTxTime_op;
	protected  Integer  f_txStatus;
 	protected  String  f_txStatus_op;
	protected  String  f_voucherNo;
 	protected  String  f_voucherNo_op;
	protected  String  f_errorCode;
 	protected  String  f_errorCode_op;
	protected  String  f_errorMsg;
 	protected  String  f_errorMsg_op;
	protected  String  f_settleBatchNo;
 	protected  String  f_settleBatchNo_op;
	protected  Integer  f_settleStatus;
 	protected  String  f_settleStatus_op;
	protected  String  f_settleDate;
 	protected  String  f_settleDate_op;
	protected  Integer  f_feeAmount;
 	protected  String  f_feeAmount_op;
	protected  Integer  f_hasCountFee;
 	protected  String  f_hasCountFee_op;
	protected  Timestamp  f_createdDatetime;
 	protected  String  f_createdDatetime_op;
	protected  Timestamp  f_createdDatetime01;
	protected  String  f_createdDatetime01_op;
	protected  Timestamp  f_lastUpdatedDatetime;
 	protected  String  f_lastUpdatedDatetime_op;
	protected  Timestamp  f_lastUpdatedDatetime01;
	protected  String  f_lastUpdatedDatetime01_op;
	protected  Integer  f_lastUpdatedBy;
 	protected  String  f_lastUpdatedBy_op;
	protected  Integer  f_deleted;
 	protected  String  f_deleted_op;

 	protected  HiUserPageInfo creator;

    public Integer getF_id() {
        return this.f_id;
    }
    
    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }
    
    public String getF_id_op() {
        return this.f_id_op;
    }
    
    public void setF_id_op(String f_id_op) {
        this.f_id_op = f_id_op;
    }
   
    public String getF_plTxTraceNo() {
        return this.f_plTxTraceNo;
    }
    
    public void setF_plTxTraceNo(String f_plTxTraceNo) {
        this.f_plTxTraceNo = f_plTxTraceNo;
    }
    
    public String getF_plTxTraceNo_op() {
        return this.f_plTxTraceNo_op;
    }
    
    public void setF_plTxTraceNo_op(String f_plTxTraceNo_op) {
        this.f_plTxTraceNo_op = f_plTxTraceNo_op;
    }
   
    public String getF_userName() {
        return this.f_userName;
    }
    
    public void setF_userName(String f_userName) {
        this.f_userName = f_userName;
    }
    
    public String getF_userName_op() {
        return this.f_userName_op;
    }
    
    public void setF_userName_op(String f_userName_op) {
        this.f_userName_op = f_userName_op;
    }
   
    public String getF_txTypeId() {
        return this.f_txTypeId;
    }
    
    public void setF_txTypeId(String f_txTypeId) {
        this.f_txTypeId = f_txTypeId;
    }
    
    public String getF_txTypeId_op() {
        return this.f_txTypeId_op;
    }
    
    public void setF_txTypeId_op(String f_txTypeId_op) {
        this.f_txTypeId_op = f_txTypeId_op;
    }
   
    public String getF_mchtNo() {
        return this.f_mchtNo;
    }
    
    public void setF_mchtNo(String f_mchtNo) {
        this.f_mchtNo = f_mchtNo;
    }
    
    public String getF_mchtNo_op() {
        return this.f_mchtNo_op;
    }
    
    public void setF_mchtNo_op(String f_mchtNo_op) {
        this.f_mchtNo_op = f_mchtNo_op;
    }
   
    public String getF_mchtTxTime() {
        return this.f_mchtTxTime;
    }
    
    public void setF_mchtTxTime(String f_mchtTxTime) {
        this.f_mchtTxTime = f_mchtTxTime;
    }
    
    public String getF_mchtTxTime_op() {
        return this.f_mchtTxTime_op;
    }
    
    public void setF_mchtTxTime_op(String f_mchtTxTime_op) {
        this.f_mchtTxTime_op = f_mchtTxTime_op;
    }
   
    public String getF_mchtTxTraceNo() {
        return this.f_mchtTxTraceNo;
    }
    
    public void setF_mchtTxTraceNo(String f_mchtTxTraceNo) {
        this.f_mchtTxTraceNo = f_mchtTxTraceNo;
    }
    
    public String getF_mchtTxTraceNo_op() {
        return this.f_mchtTxTraceNo_op;
    }
    
    public void setF_mchtTxTraceNo_op(String f_mchtTxTraceNo_op) {
        this.f_mchtTxTraceNo_op = f_mchtTxTraceNo_op;
    }
   
    public Integer getF_txAmount() {
        return this.f_txAmount;
    }
    
    public void setF_txAmount(Integer f_txAmount) {
        this.f_txAmount = f_txAmount;
    }
    
    public String getF_txAmount_op() {
        return this.f_txAmount_op;
    }
    
    public void setF_txAmount_op(String f_txAmount_op) {
        this.f_txAmount_op = f_txAmount_op;
    }
   
    public String getF_notifyUrl() {
        return this.f_notifyUrl;
    }
    
    public void setF_notifyUrl(String f_notifyUrl) {
        this.f_notifyUrl = f_notifyUrl;
    }
    
    public String getF_notifyUrl_op() {
        return this.f_notifyUrl_op;
    }
    
    public void setF_notifyUrl_op(String f_notifyUrl_op) {
        this.f_notifyUrl_op = f_notifyUrl_op;
    }
   
    public String getF_txIp() {
        return this.f_txIp;
    }
    
    public void setF_txIp(String f_txIp) {
        this.f_txIp = f_txIp;
    }
    
    public String getF_txIp_op() {
        return this.f_txIp_op;
    }
    
    public void setF_txIp_op(String f_txIp_op) {
        this.f_txIp_op = f_txIp_op;
    }
   
    public String getF_plTxTime() {
        return this.f_plTxTime;
    }
    
    public void setF_plTxTime(String f_plTxTime) {
        this.f_plTxTime = f_plTxTime;
    }
    
    public String getF_plTxTime_op() {
        return this.f_plTxTime_op;
    }
    
    public void setF_plTxTime_op(String f_plTxTime_op) {
        this.f_plTxTime_op = f_plTxTime_op;
    }
   
    public Integer getF_txStatus() {
        return this.f_txStatus;
    }
    
    public void setF_txStatus(Integer f_txStatus) {
        this.f_txStatus = f_txStatus;
    }
    
    public String getF_txStatus_op() {
        return this.f_txStatus_op;
    }
    
    public void setF_txStatus_op(String f_txStatus_op) {
        this.f_txStatus_op = f_txStatus_op;
    }
   
    public String getF_voucherNo() {
        return this.f_voucherNo;
    }
    
    public void setF_voucherNo(String f_voucherNo) {
        this.f_voucherNo = f_voucherNo;
    }
    
    public String getF_voucherNo_op() {
        return this.f_voucherNo_op;
    }
    
    public void setF_voucherNo_op(String f_voucherNo_op) {
        this.f_voucherNo_op = f_voucherNo_op;
    }
   
    public String getF_errorCode() {
        return this.f_errorCode;
    }
    
    public void setF_errorCode(String f_errorCode) {
        this.f_errorCode = f_errorCode;
    }
    
    public String getF_errorCode_op() {
        return this.f_errorCode_op;
    }
    
    public void setF_errorCode_op(String f_errorCode_op) {
        this.f_errorCode_op = f_errorCode_op;
    }
   
    public String getF_errorMsg() {
        return this.f_errorMsg;
    }
    
    public void setF_errorMsg(String f_errorMsg) {
        this.f_errorMsg = f_errorMsg;
    }
    
    public String getF_errorMsg_op() {
        return this.f_errorMsg_op;
    }
    
    public void setF_errorMsg_op(String f_errorMsg_op) {
        this.f_errorMsg_op = f_errorMsg_op;
    }
   
    public String getF_settleBatchNo() {
        return this.f_settleBatchNo;
    }
    
    public void setF_settleBatchNo(String f_settleBatchNo) {
        this.f_settleBatchNo = f_settleBatchNo;
    }
    
    public String getF_settleBatchNo_op() {
        return this.f_settleBatchNo_op;
    }
    
    public void setF_settleBatchNo_op(String f_settleBatchNo_op) {
        this.f_settleBatchNo_op = f_settleBatchNo_op;
    }
   
    public Integer getF_settleStatus() {
        return this.f_settleStatus;
    }
    
    public void setF_settleStatus(Integer f_settleStatus) {
        this.f_settleStatus = f_settleStatus;
    }
    
    public String getF_settleStatus_op() {
        return this.f_settleStatus_op;
    }
    
    public void setF_settleStatus_op(String f_settleStatus_op) {
        this.f_settleStatus_op = f_settleStatus_op;
    }
   
    public String getF_settleDate() {
        return this.f_settleDate;
    }
    
    public void setF_settleDate(String f_settleDate) {
        this.f_settleDate = f_settleDate;
    }
    
    public String getF_settleDate_op() {
        return this.f_settleDate_op;
    }
    
    public void setF_settleDate_op(String f_settleDate_op) {
        this.f_settleDate_op = f_settleDate_op;
    }
   
    public Integer getF_feeAmount() {
        return this.f_feeAmount;
    }
    
    public void setF_feeAmount(Integer f_feeAmount) {
        this.f_feeAmount = f_feeAmount;
    }
    
    public String getF_feeAmount_op() {
        return this.f_feeAmount_op;
    }
    
    public void setF_feeAmount_op(String f_feeAmount_op) {
        this.f_feeAmount_op = f_feeAmount_op;
    }
   
    public Integer getF_hasCountFee() {
        return this.f_hasCountFee;
    }
    
    public void setF_hasCountFee(Integer f_hasCountFee) {
        this.f_hasCountFee = f_hasCountFee;
    }
    
    public String getF_hasCountFee_op() {
        return this.f_hasCountFee_op;
    }
    
    public void setF_hasCountFee_op(String f_hasCountFee_op) {
        this.f_hasCountFee_op = f_hasCountFee_op;
    }
   
    public Timestamp getF_createdDatetime() {
        return this.f_createdDatetime;
    }
    
    public void setF_createdDatetime(Timestamp f_createdDatetime) {
        this.f_createdDatetime = f_createdDatetime;
    }
    
    public String getF_createdDatetime_op() {
        return this.f_createdDatetime_op;
    }
    
    public void setF_createdDatetime_op(String f_createdDatetime_op) {
        this.f_createdDatetime_op = f_createdDatetime_op;
    }
    public Timestamp getF_createdDatetime01() {
        return this.f_createdDatetime01;
    }
    
    public void setF_createdDatetime01(Timestamp f_createdDatetime01) {
        this.f_createdDatetime01 = f_createdDatetime01;
    }
    
    public String getF_createdDatetime01_op() {
        return this.f_createdDatetime01_op;
    }
    
    public void setF_createdDatetime01_op(String f_createdDatetime01_op) {
        this.f_createdDatetime01_op = f_createdDatetime01_op;
    }
   
    public Timestamp getF_lastUpdatedDatetime() {
        return this.f_lastUpdatedDatetime;
    }
    
    public void setF_lastUpdatedDatetime(Timestamp f_lastUpdatedDatetime) {
        this.f_lastUpdatedDatetime = f_lastUpdatedDatetime;
    }
    
    public String getF_lastUpdatedDatetime_op() {
        return this.f_lastUpdatedDatetime_op;
    }
    
    public void setF_lastUpdatedDatetime_op(String f_lastUpdatedDatetime_op) {
        this.f_lastUpdatedDatetime_op = f_lastUpdatedDatetime_op;
    }
    public Timestamp getF_lastUpdatedDatetime01() {
        return this.f_lastUpdatedDatetime01;
    }
    
    public void setF_lastUpdatedDatetime01(Timestamp f_lastUpdatedDatetime01) {
        this.f_lastUpdatedDatetime01 = f_lastUpdatedDatetime01;
    }
    
    public String getF_lastUpdatedDatetime01_op() {
        return this.f_lastUpdatedDatetime01_op;
    }
    
    public void setF_lastUpdatedDatetime01_op(String f_lastUpdatedDatetime01_op) {
        this.f_lastUpdatedDatetime01_op = f_lastUpdatedDatetime01_op;
    }
   
    public Integer getF_lastUpdatedBy() {
        return this.f_lastUpdatedBy;
    }
    
    public void setF_lastUpdatedBy(Integer f_lastUpdatedBy) {
        this.f_lastUpdatedBy = f_lastUpdatedBy;
    }
    
    public String getF_lastUpdatedBy_op() {
        return this.f_lastUpdatedBy_op;
    }
    
    public void setF_lastUpdatedBy_op(String f_lastUpdatedBy_op) {
        this.f_lastUpdatedBy_op = f_lastUpdatedBy_op;
    }
   
    public Integer getF_deleted() {
        return this.f_deleted;
    }
    
    public void setF_deleted(Integer f_deleted) {
        this.f_deleted = f_deleted;
    }
    
    public String getF_deleted_op() {
        return this.f_deleted_op;
    }
    
    public void setF_deleted_op(String f_deleted_op) {
        this.f_deleted_op = f_deleted_op;
    }
   
	public HiUserPageInfo getCreator() {
		return creator;
	}

	public void setCreator(HiUserPageInfo creator) {
		this.creator = creator;
	}

}
