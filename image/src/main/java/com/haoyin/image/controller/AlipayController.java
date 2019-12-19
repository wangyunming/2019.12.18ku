package com.haoyin.image.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.haoyin.image.entity.JSONResult;
import com.haoyin.image.entity.Order;
import com.haoyin.image.entity.OrderQuery;
import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.service.DirectPayService;
import com.haoyin.image.service.OrderService;
import com.haoyin.image.util.DigestUtil;
import com.haoyin.image.util.TradeConstant;
import com.haoyin.image.util.alipay.AlipayConfig;
import com.haoyin.image.util.alipay.AlipaySubmit;
import com.haoyin.image.util.alipay.PayResult;
import com.haoyin.image.util.alipay.UnionpayConfig;
import com.haoyin.image.util.alipay.core.AlipayCore;
import com.haoyin.image.util.alipay.core.AlipayNotify;
import com.haoyin.image.util.constant.TradeMessageName;


@Controller
public class AlipayController {
	
	private static final Logger log=LoggerFactory.getLogger(AlipayController.class);
	
	@Resource
	OrderService orderService;
	
	@Resource
	DirectPayService directPayService;
	
	@RequestMapping("/pay/direct-pay-new.html")
	@ResponseBody
	public JSONResult Alipay(OrderQuery query,HttpServletResponse response) throws Exception{
		Order order=orderService.queryOrderById(query.getOrderId());
		JSONResult jsonResult=new JSONResult();
		if(null==order){
		jsonResult.setMessage("operate.submit.parameter.error");
		return jsonResult;
		}
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("service", AlipayConfig.SERVICE);
		paramsMap.put("partner", AlipayConfig.PARTNER);
		paramsMap.put("return_url", AlipayConfig.RETURN_URL);
		paramsMap.put("notify_url", AlipayConfig.NOTIFY_URL);
		paramsMap.put("seller_email", AlipayConfig.SELLER_EMAIL);
		paramsMap.put("_input_charset", AlipayConfig.INPUT_CHARSET);
		paramsMap.put("buyer_email", getUser().getEmail());
		paramsMap.put("payment_type", TradeConstant.BUY_ITEM_OF_TRATE_TYPE);
		paramsMap.put("out_trade_no", order.getOrderNo());
		paramsMap.put("subject", TradeConstant.ALIPAY_SUBJECT);
		paramsMap.put("total_fee", new BigDecimal(order.getPayAmount()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		paramsMap.put("body", order.getRemark());
		paramsMap.put("extra_common_param", order.getId().toString());

		paramsMap = AlipayCore.paraFilter(paramsMap);
		String mysign = AlipayCore.buildMysign(paramsMap);
		paramsMap.put("sign", mysign);
		 
		paramsMap.put("merchant_private_key", AlipayConfig.PUBLIC_KEY);
		paramsMap.put("alipay_public_key", AlipayConfig.PUBLIC_KEY);
		paramsMap.put("sign_type", AlipayConfig.SIGN_TYPE);
		try {
			response.setCharacterEncoding(AlipayConfig.INPUT_CHARSET);
			response.setContentType("text/html;charset=UTF-8");
			String form = AlipaySubmit.buildForm(paramsMap, AlipayConfig.ALIPAY_GATEWAY, AlipayConfig.SUBMIT_METHOD);
			response.getOutputStream().write(form.toString().getBytes("UTF-8"));
		} catch (IOException e) {
			throw new Exception("IOException occurs in output stream of form.");
		}
		return null;
	}
	private UserProfile getUser(){
		return  (UserProfile) SecurityUtils.getSubject().getSession(false).getAttribute("uus");
	}
	
	/**
	 * 沙箱支付成功页面
	 * @param req
	 * @param model
	 * @return
	 */
/*	@RequestMapping("/pay/notify.html")
	public String syncNotify(HttpServletRequest req,Model model){
		Map<String, String> params=new HashMap<>();
		initRequestParams(params,req);
		boolean verify_result=false;
		try {
			verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.PUBLIC_KEY, AlipayConfig.INPUT_CHARSET, AlipayConfig.SIGN_TYPE);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		String orderNo = req.getParameter("out_trade_no");
		Order order = orderService.queryOrderByOrderNo(orderNo);
		if(order.getPayStatus()==1){
			model.addAttribute("order", order);
			return "screen/order/pay-success";
		}
		if (verify_result) {
			PayResult result=null;
			result = directPayService.alipayDirectPay(req,"haoyin");
			order = result.getModel(Order.class);
				if (result.isSuccess()) {
					//sendPaySuccessMail(order);
				}
			
			model.addAttribute("order", order);
			model.addAttribute("result", result);
			return "screen/order/pay-success";
		} else {
			model.addAttribute("order", order);
			log.error("Parameters can not be authenticated");
			return "screen/order/pay-success";
		}

	}*/
	
	/**
	 * 好印支付成功
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/pay/notify.html")
	public String syncNotify(HttpServletRequest req,Model model){
		Map<String, String> params=new HashMap<>();
		initRequestParams(params,req);
		boolean verify_result=false;
		verify_result = AlipayNotify.verify(params);
		String orderNo = req.getParameter("out_trade_no");
		Order order = orderService.queryOrderByOrderNo(orderNo);
		if(order.getPayStatus()==1){
			model.addAttribute("order", order);
			return "screen/order/pay-success";
		}
		if (verify_result) {
			PayResult result=null;
			result = directPayService.alipayDirectPay(req,"haoyin");
			order = result.getModel(Order.class);
				if (result.isSuccess()) {
					//sendPaySuccessMail(order);
				}
			
			model.addAttribute("order", order);
			model.addAttribute("result", result);
			return "screen/order/pay-success";
		} else {
			model.addAttribute("order", order);
			log.error("Parameters can not be authenticated");
			return "screen/order/pay-success";
		}

	}
	private void initRequestParams(Map<String, String> params,HttpServletRequest request) {
		if (!params.isEmpty()) {
			params.clear();
		}
		Map<?, ?> requestParams = request.getParameterMap();

		for (Iterator<?> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			StringBuilder valBuilder = new StringBuilder();

			for (int i = 0; i < values.length; i++) {
				if (i == (values.length - 1)) {
					valBuilder.append(values[i]);
				} else {
					valBuilder.append(values[i]).append(",");
				}
			}
			params.put(name, valBuilder.toString());
		}
	}
	/**
	 * 异歩消息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/async-notify/alipay-notify.html")
	public String asyncNotify() {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
	    HttpServletRequest request = servletRequestAttributes.getRequest();
	    HttpServletResponse response = servletRequestAttributes.getResponse();
		Map<String, String> params=new HashMap<>();
		log.debug("received async notify from alipay. time: {}", Calendar.getInstance().getTime());
		initRequestParams(params,request);

		if (AlipayNotify.verify(params)) {
			String trade_status = request.getParameter("trade_status");

			if (trade_status.equals(TradeMessageName.TRADE_FINISHED) || trade_status.equals(TradeMessageName.TRADE_SUCCESS)) {
				PayResult result = directPayService.alipayDirectPay(request,"haoyin");
				Order order = result.getModel(Order.class);

				if (result.isSuccess()) {
					// getResponse().getOutputStream().print(PAYMENT_SUCCESS);
					//sendPaySuccessMail(order);
				} else {
					// getResponse().getOutputStream().println(TRADE_FAIL);
					log.error("Alipay pay success, but system operate failed.");
				}
			}

			try {
				println(TradeMessageName.PAYMENT_SUCCESS,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			log.error("Back to data validation fails from alipay interface.");
			try {
				response.getOutputStream().print(TradeMessageName.VALID_FAIL);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}
	protected void println(String str,HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getOutputStream().println(str);
	}
	/*@ResponseBody
	@RequestMapping("/pay/direct-pay-new.html")
	public void  trade(OrderQuery orderQuery,HttpServletRequest request,HttpServletResponse response) throws IOException{
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.ALIPAY_GATEWAY, AlipayConfig.PARTNER, AlipayConfig.PRIVATE_KEY, "json", AlipayConfig.INPUT_CHARSET, AlipayConfig.PUBLIC_KEY, AlipayConfig.SIGN_TYPE);
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.RETURN_URL);
		alipayRequest.setNotifyUrl(AlipayConfig.NOTIFY_URL);
		Order order=orderService.queryOrderById(orderQuery.getOrderId());
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = order.getOrderNo();
		//付款金额，必填
		String total_amount = new BigDecimal(order.getPayAmount()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		//订单名称，必填
		String subject = TradeConstant.ALIPAY_SUBJECT;
		//商品描述，可空
		String body = order.getRemark();
		
		String extra_common_param=order.getId().toString();
		extra_common_param=URLEncoder.encode(extra_common_param, "utf-8");
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
		//若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
		//alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
		//		+ "\"total_amount\":\""+ total_amount +"\"," 
		//		+ "\"subject\":\""+ subject +"\"," 
		//		+ "\"body\":\""+ body +"\"," 
		//		+ "\"timeout_express\":\"10m\"," 
		//		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		//请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
		
		//请求
		String result=null;
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e1) {
			e1.printStackTrace();
		}
		response.setContentType("text/html;charset=" + "utf-8");
		response.getWriter().write(result);//直接将完整的表单html输出到页面
		response.getWriter().flush();
		response.getWriter().close();
	}*/
	
	@RequestMapping("/pay/pay-success-good.html")
	public String paySuccessGood(HttpServletRequest req,Model model){
		return "screen/order/pay-success-good";
	}
	
}
