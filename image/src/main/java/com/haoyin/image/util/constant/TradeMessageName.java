package com.haoyin.image.util.constant;

public interface TradeMessageName {
	/** 表示交易已经成功结束，为高级即时到帐的交易状态成功标识 */
	public static final String TRADE_SUCCESS = "TRADE_SUCCESS";

	/** 表示交易已经成功结束，为普通即时到帐的交易状态成功标识 */
	public static final String TRADE_FINISHED = "TRADE_FINISHED";
	
	/** 支付成功 */
	String PAYMENT_SUCCESS = "success";
	
	String TRADE_FAIL = "trade-fail";
	
	String VALID_SUCCESS = "valid-success";
	
	String VALID_FAIL = "fail";
}
