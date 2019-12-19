package com.haoyin.image.util.alipay;



public interface UnionpayConfig {
	//商户编号
		String P1_MERID = UnionpayConfigHelper.getInstance().getString("p1_MerId");
		//商户密钥
		String KEYVALUE = UnionpayConfigHelper.getInstance().getString("keyValue");
		//下单请求地址
		String REQUESTURL = UnionpayConfigHelper.getInstance().getString("requestURL");
		//订单查询请求地址
		String QUERYURL = UnionpayConfigHelper.getInstance().getString("queryURL");
		//退款请求地址
		String REFUNDURL = UnionpayConfigHelper.getInstance().getString("refundURL");
		//退款查询请求地址
		String REFUNDQUERYURL = UnionpayConfigHelper.getInstance().getString("refundQueryURL");
		//订单取消请求地址
		String CANCELORDERURL = UnionpayConfigHelper.getInstance().getString("cancelOrderURL");
		//订单回调地址
		String CALLBACKURL = UnionpayConfigHelper.getInstance().getString("callBackUrl");
}
