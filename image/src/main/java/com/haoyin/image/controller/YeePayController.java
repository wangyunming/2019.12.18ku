package com.haoyin.image.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.haoyin.image.entity.Order;
import com.haoyin.image.entity.OrderQuery;
import com.haoyin.image.service.DirectPayService;
import com.haoyin.image.service.OrderService;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.g3.sdk.yop.client.YopRsaClient;
import com.yeepay.g3.sdk.yop.encrypt.CertTypeEnum;
import com.yeepay.g3.sdk.yop.encrypt.DigestAlgEnum;
import com.yeepay.g3.sdk.yop.encrypt.DigitalEnvelopeDTO;
import com.yeepay.g3.sdk.yop.encrypt.DigitalSignatureDTO;
import com.yeepay.g3.sdk.yop.utils.DigitalEnvelopeUtils;



/**
 * 易宝支付 网银接口
 * @author sunny
 * @date 2019年8月22日
 */
@Controller
public class YeePayController {
	// 设置dns解析成功的域名缓存180秒，解析失败重新解析间隔10秒，可以及时响应双机房容灾
	static {
		System.setProperty("sun.net.inetaddr.ttl", "180");
		System.setProperty("sun.net.inetaddr.negative.ttl", "10");
	}

	private static final Logger log = LoggerFactory.getLogger(YeePayController.class);

	@Resource
	OrderService orderService;

	@Resource
	DirectPayService directPayService;

	@Value("${yeepay.appKey}")
	private  String appKey;
	@Value("${yeepay.merchantPrivateKey}")
	private  String merchantPrivateKey;
	@Value("${yeepay.merchantNo}")
	private  String merchantNo;
	@Value("${yeepay.CASHIER}")
	private  String CASHIER;
	@Value("${yeepay.merchantPublicKey}")
	private  String merchantPublicKey;
	@Value("${yeepay.redirectUrl}")
	private  String redirectUrl;
	@Value("${yeepay.notifyUrl}")
	private  String notifyUrl;

	@RequestMapping("/pay/yee-pay-new.html")
	@ResponseBody
	public String YeePay(OrderQuery query,HttpServletResponse rep) throws Exception {
		Order order=orderService.queryOrderById(query.getOrderId());
		if(null==order){
			return null;
		}
		// appKey应用
		YopRequest request = new YopRequest(appKey, merchantPrivateKey);
		// g构造请求参数
		request.addParam("parentMerchantNo", merchantNo);
		request.addParam("merchantNo", merchantNo);
		request.addParam("orderId", order.getId().toString());
		request.addParam("orderAmount", new BigDecimal(order.getPayAmount()).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		request.addParam("redirectUrl",redirectUrl+"?merchantNo="+merchantNo+"&parentMerchantNo="+merchantNo+"&orderId="+order.getId().toString());
		request.addParam("notifyUrl",notifyUrl);
		request.addParam("goodsParamExt", "{\"goodsName\":\"" + "initial" + "\",\"goodsDesc\":\"" + "initial专用商品" + "\"}");
		YopResponse response = YopRsaClient.post("/rest/v1.0/std/trade/order", request);// 发送请求
//		System.out.println(response.toString());// 输出返回
		// 解析返回
		if ("FAILURE".equals(response.getState())) {
			if (response.getError() != null)
				response.getError().getCode();
			response.getError().getMessage();
		}
		if (response.getStringResult() != null) {
			String url=getUrlByToken(parseResponse(response.getStringResult()).get("token"));
//			System.out.println("支付跳转链接："+url);
			rep.sendRedirect(url);
		}
		return null;
	}

	/**
	 * yeePay 支付成功异步通知
	 * 
	 * @param req
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/yeePay/notify.html")
	public void syncNotify(HttpServletRequest req, Model model,HttpServletResponse rep) throws Exception {
		//获取回调数据 
		String responseMsg =req.getParameter("response");
		DigitalEnvelopeDTO dto = new DigitalEnvelopeDTO();
		dto.setCipherText(responseMsg);
	    //设置商户私钥
	    PrivateKey privateKey = getPrivateKey(merchantPrivateKey);
	    //设置易宝公钥
	    PublicKey publicKey = getPublicKey(merchantPublicKey);
	    //解密验签
	    dto = DigitalEnvelopeUtils.decrypt(dto, privateKey, publicKey);
	    //打印回调数据
//	    System.out.println(dto.getPlainText());
	    Map<String,String> jsonMap  = new HashMap<>();
	    jsonMap = parseResponse(dto.getPlainText());
	    Boolean result = directPayService.unionDirectPay(jsonMap);
	    if(result) {
			PrintWriter out = rep.getWriter();
			out.println("SUCCESS");
		    out.flush();  
		    out.close();
	    }
	}
	/**
	 * yeePay 支付成功页面跳转
	 * 
	 * @param req
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/yeePay/sync.html")
	public String paySync(HttpServletRequest req, Model model) throws Exception {
		//获取回调数据 
		String orderId =req.getParameter("orderId");
		Order order=orderService.queryOrderById(Long.parseLong(orderId));
		model.addAttribute("order", order);
		if(order!=null&&order.getPayStatus()==1) {
			return "screen/order/pay-success";
		}
		return "screen/order/pay-wait";
	}
	// 将获取到的response转换成json格式
	public static Map<String, String> parseResponse(String response) {
		Map<String, String> jsonMap = new HashMap<>();
		jsonMap = JSON.parseObject(response, new TypeReference<TreeMap<String, String>>() {
		});
		return jsonMap;
	}

	// 根据token拼接支付链接
	public  String getUrlByToken(String token) throws IOException {
		String url = CASHIER;
		Map<String, String> params = new HashMap<>();
		// 系统商商编
		params.put("merchantNo", merchantNo);
		// token 调创建订单接口获取
		params.put("token", token);
		// 时间戳
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		// 直联编码
		params.put("directPayType", "");
		// 卡类型只适用于银行卡快捷支付
		params.put("cardType", "");
		// 用户标识银行卡快捷支付用于记录绑卡
		params.put("userNo", "2372373273278238");
		// 用户标识类型
		params.put("userType", "USER_ID");

		// 构建请求收银台签名串，注意如果传参ext，也需参与签名

		// 需要生成sign签名的参数
		String[] CASHIER = { "merchantNo", "token", "timestamp", "directPayType", "cardType", "userNo", "userType" };
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < CASHIER.length; i++) {
			String name = CASHIER[i];
			String value = params.get(name);
			if (i != 0) {
				stringBuilder.append("&");
			}
			stringBuilder.append(name + "=").append(value);
		}
//		System.out.println(stringBuilder);
		String sign = getSign(stringBuilder.toString());
//		System.out.println(sign);
		url = url + ("?sign=" + sign + "&" + stringBuilder);

		return url;
	}

	// 获取请求收银台的sign
	private  String getSign(String stringBuilder) {
		PrivateKey isvPrivateKey = getPrivateKey(merchantPrivateKey);
		DigitalSignatureDTO digitalSignatureDTO = new DigitalSignatureDTO();
		digitalSignatureDTO.setAppKey(appKey);
		digitalSignatureDTO.setCertType(CertTypeEnum.RSA2048);
		digitalSignatureDTO.setDigestAlg(DigestAlgEnum.SHA256);
		digitalSignatureDTO.setPlainText(stringBuilder);
		String sign = DigitalEnvelopeUtils.sign0(digitalSignatureDTO, isvPrivateKey);
		return sign;
	}

	/**
	 * String 转换为PrivateKey
	 * <p>Title: getPrivateKey</p>
	 * <p>Description: </p>
	 * @author sunny
	 * @param priKey
	 * @return
	 */
	private static PrivateKey getPrivateKey(String priKey) {
		PrivateKey privateKey = null;
		PKCS8EncodedKeySpec priPKCS8;
		try {
			Decoder decoder = Base64.getDecoder();
			priPKCS8 = new PKCS8EncodedKeySpec(decoder.decode(priKey));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			privateKey = keyf.generatePrivate(priPKCS8);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return privateKey;
	}

	
	/**
	 * String 转换为publickey
	 * <p>Title: getPublicKey</p>
	 * <p>Description: </p>
	 * @author sunny
	 * @param key
	 * @return
	 * @throws Exception
	 */
	 public static PublicKey getPublicKey(String key) throws Exception {
         byte[] keyBytes;
         keyBytes = (Base64.getDecoder().decode(key));
         X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
         KeyFactory keyFactory = KeyFactory.getInstance("RSA");
         PublicKey publicKey = keyFactory.generatePublic(keySpec);
         return publicKey;
   }

}
