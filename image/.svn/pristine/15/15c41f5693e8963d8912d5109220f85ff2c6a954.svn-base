/**
 * 
 */
package com.haoyin.image.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.haoyin.image.util.Result;
import com.haoyin.image.util.alipay.PayResult;
import com.haoyin.image.util.alipay.PayResultSupport;



/**
 * @date 2011-12-12
 * @version V1.0
 */
@Service
public class BaseService extends ApplicationObjectSupport {
	protected final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	protected TransactionTemplate transactionTemplate;

	/**
	 * @return the transactionTemplate
	 */
	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	/**
	 * @param transactionTemplate
	 *            the transactionTemplate to set
	 */
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	/**
	 * 执行事务
	 * 
	 * @param action
	 * @return
	 */
	protected Boolean executeTransaction(TransactionCallback<Boolean> action) {
		try {
			return (Boolean) transactionTemplate.execute(action);
		} catch (Throwable e) {
			log.error("Execute transaction failed, and transaction rollback ", e);
		}

		return Boolean.FALSE;
	}

	/**
	 * 执行事务
	 * 
	 * @param action
	 * @return
	 */
	protected Result executeTransactionToResult(TransactionCallback<Result> action) {
		try {
			return (Result) transactionTemplate.execute(action);
		} catch (Throwable e) {
			log.error("Execute transaction failed, and transaction rollback ", e);
		}

		return new Result();
	}
	
	/**
	 * 执行事务
	 * 
	 * @param action
	 * @return
	 */
	protected PayResult executeTransactionToPayResult(TransactionCallback<PayResult> action) {
		try {
			return (PayResult) transactionTemplate.execute(action);
		} catch (Throwable e) {
			log.error("Execute transaction failed, and transaction rollback ", e);
		}

		return new PayResultSupport();
	}
	

}


