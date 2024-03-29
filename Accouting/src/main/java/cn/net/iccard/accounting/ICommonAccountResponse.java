package cn.net.iccard.accounting;

import java.io.Serializable;

/**
 * 账务操作通用响应
 * 
 * @author Angi
 * 
 */
public interface ICommonAccountResponse extends Serializable {

	/**
	 * 响应码
	 * 
	 * @return
	 */
	String getRespCode();

	/**
	 * 响应描述
	 * 
	 * @return
	 */
	String getRespMsg();
}
