package com.haoyin.image.util.alipay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;

import com.haoyin.image.util.alipay.core.AlipayCore;
import com.haoyin.image.util.alipay.core.AlipayMd5Encrypt;
import com.haoyin.image.util.alipay.http.HttpProtocolHandler;
import com.haoyin.image.util.alipay.http.HttpRequest;
import com.haoyin.image.util.alipay.http.HttpResponse;
import com.haoyin.image.util.alipay.http.HttpResultType;




/**
 * 类名：AlipaySubmit<br>
 * 功能：支付宝各接口请求提交类<br>
 * 详细：构造支付宝各接口表单HTML文本，获取远程HTTP数据<br>
 * 版本：3.2<br>
 * 日期：2011-03-17<br>
 */
public class AlipaySubmit {

	/**
	 * 生成要请求给支付宝的参数数组
	 * 
	 * @param sParaTemp
	 *            请求前的参数数组
	 * @return 要请求的参数数组
	 */
	public static Map<String, String> buildRequestPara(Map<String, String> sParaTemp) {
		// 除去数组中的空值和签名参数
		Map<String, String> sPara = AlipayCore.paraFilter(sParaTemp);
		// 生成签名结果
		String mysign = AlipayCore.buildMysign(sPara);

		// 签名结果与签名方式加入请求提交参数组中
		sPara.put("sign", mysign);
		sPara.put("sign_type", AlipayConfig.SIGN_TYPE);

		return sPara;
	}

	/**
	 * 构造提交表单HTML数据
	 * 
	 * @param sParaTemp
	 *            请求参数数组
	 * @param gateway
	 *            网关地址
	 * @param strMethod
	 *            提交方式。两个值可选：post、get
	 * @param strButtonName
	 *            确认按钮显示文字
	 * @return 提交表单HTML文本
	 */
	public static String buildForm(Map<String, String> sParaTemp, String gateway, String strMethod, String strButtonName) {
		// 待请求参数数组
		Map<String, String> sPara = buildRequestPara(sParaTemp);
		List<String> keys = new ArrayList<String>(sPara.keySet());
		StringBuffer sbHtml = new StringBuffer();
		sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + gateway + "_input_charset="
				+ AlipayConfig.INPUT_CHARSET + "\" method=\"" + strMethod + "\">");

		for (int i = 0; i < keys.size(); i++) {
			String name = (String) keys.get(i);
			String value = (String) sPara.get(name);

			sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
		}

		// submit按钮控件请不要含有name属性
		sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
		sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

		return sbHtml.toString();
	}

	/**
	 * 构造提交表单HTML数据
	 * 
	 * @param sParaTemp
	 *            请求参数数组
	 * @param gateway
	 *            网关地址
	 * @param strMethod
	 *            提交方式。两个值可选：post、get
	 * @param strButtonName
	 *            确认按钮显示文字
	 * @return 提交表单HTML文本
	 */
	public static String buildForm(Map<String, String> sParaTemp, String gateway, String strMethod) {
		// 待请求参数数组
		Map<String, String> sPara = buildRequestPara(sParaTemp);
		List<String> keys = new ArrayList<String>(sPara.keySet());
		StringBuffer sbHtml = new StringBuffer();
		sbHtml.append("<div style='text-align: center; margin: 80px auto 200px; display: block;border: 1px solid #ccc; width: 250px; clear: both;background-color:#fff;' class='ovh'>");
		sbHtml.append("<img src='/default/images/login_loadding.gif' style='padding: 12px 5px; margin-left: 25px; float: left;'/>");
		sbHtml.append("<label style='padding: 10px; 20px; float: left;'>请稍后,正在前往支付页面.....</label></div>");
		sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + gateway + "_input_charset="
				+ AlipayConfig.INPUT_CHARSET + "\" method=\"" + strMethod + "\">");

		for (int i = 0; i < keys.size(); i++) {
			String name = (String) keys.get(i);
			String value = (String) sPara.get(name);

			sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
		}

		// submit按钮控件请不要含有name属性
		// sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\">");
		sbHtml.append("</form><script>document.forms['alipaysubmit'].submit();</script>");

		return sbHtml.toString();
	}

	/**
	 * MAP类型数组转换成NameValuePair类型
	 * 
	 * @param properties
	 *            MAP类型数组
	 * @return NameValuePair类型数组
	 */
	private static NameValuePair[] generatNameValuePair(Map<String, String> properties) {
		NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
		int i = 0;
		for (Map.Entry<String, String> entry : properties.entrySet()) {
			nameValuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());
		}
		return nameValuePair;
	}

	/**
	 * 构造模拟远程HTTP的POST请求，获取支付宝的返回XML处理结果
	 * 
	 * @param sParaTemp
	 *            请求参数数组
	 * @param gateway
	 *            网关地址
	 * @return 支付宝返回XML处理结果
	 * @throws Exception
	 */
	public static String sendPostInfo(Map<String, String> sParaTemp, String gateway) throws Exception {
		// 待请求参数数组
		Map<String, String> sPara = buildRequestPara(sParaTemp);
		HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();
		HttpRequest request = new HttpRequest(HttpResultType.BYTES);

		// 设置编码集
		request.setCharset(AlipayConfig.INPUT_CHARSET);
		request.setParameters(generatNameValuePair(sPara));
		request.setUrl(gateway + "_input_charset=" + AlipayConfig.INPUT_CHARSET);

		HttpResponse response = httpProtocolHandler.execute(request);
		if (response == null) {
			return null;
		}
		String strResult = response.getStringResult();
		return strResult;
	}

	/**
	 * 生成签名结果
	 * 
	 * @param sPara
	 *            要签名的数组
	 * @return 签名结果字符串
	 */
	public static String buildRequestMysign(Map<String, String> sPara) {
		String prestr = AlipayCore.createLinkString(sPara);
		String mysign = "";
		if (AlipayConfig.SIGN_TYPE.equals("MD5")) {
			mysign = AlipayMd5Encrypt.sign(prestr, AlipayConfig.KEY, AlipayConfig.INPUT_CHARSET);
		}
		return mysign;
	}

	/**
	 * 建立请求，以表单HTML形式构造（默认）
	 * 
	 * @param sParaTemp
	 *            请求参数数组
	 * @param strMethod
	 *            提交方式。两个值可选：post、get
	 * @param strButtonName
	 *            确认按钮显示文字
	 * @return 提交表单HTML文本
	 */
	public static String buildRequest(Map<String, String> sParaTemp, String strMethod, String strButtonName) {
		// 待请求参数数组
		Map<String, String> sPara = buildRequestPara(sParaTemp);
		List<String> keys = new ArrayList<String>(sPara.keySet());

		StringBuffer sbHtml = new StringBuffer();

		sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + AlipayConfig.ALIPAY_GATEWAY
				+ "_input_charset=" + AlipayConfig.INPUT_CHARSET + "\" method=\"" + strMethod + "\">");

		for (int i = 0; i < keys.size(); i++) {
			String name = (String) keys.get(i);
			String value = (String) sPara.get(name);

			sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
		}

		// submit按钮控件请不要含有name属性
		sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
		sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

		return sbHtml.toString();
	}
	
	/**
	 * 建立请求，以表单HTML形式构造，带文件上传功能
	 * 
	 * @param sParaTemp
	 *            请求参数数组
	 * @param strMethod
	 *            提交方式。两个值可选：post、get
	 * @param strButtonName
	 *            确认按钮显示文字
	 * @param strParaFileName
	 *            文件上传的参数名
	 * @return 提交表单HTML文本
	 */
	public static String buildRequest(Map<String, String> sParaTemp, String strMethod, String strButtonName,
			String strParaFileName) {
		// 待请求参数数组
		Map<String, String> sPara = buildRequestPara(sParaTemp);
		List<String> keys = new ArrayList<String>(sPara.keySet());

		StringBuffer sbHtml = new StringBuffer();

		sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\"  enctype=\"multipart/form-data\" action=\""
				+ AlipayConfig.ALIPAY_GATEWAY + "_input_charset=" + AlipayConfig.INPUT_CHARSET + "\" method=\"" + strMethod
				+ "\">");

		for (int i = 0; i < keys.size(); i++) {
			String name = (String) keys.get(i);
			String value = (String) sPara.get(name);

			sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
		}

		sbHtml.append("<input type=\"file\" name=\"" + strParaFileName + "\" />");

		// submit按钮控件请不要含有name属性
		sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");

		return sbHtml.toString();
	}

	/**
	 * 建立请求，以模拟远程HTTP的POST请求方式构造并获取支付宝的处理结果 如果接口中没有上传文件参数，那么strParaFileName与strFilePath设置为空值 如：buildRequest("",
	 * "",sParaTemp)
	 * 
	 * @param strParaFileName
	 *            文件类型的参数名
	 * @param strFilePath
	 *            文件路径
	 * @param sParaTemp
	 *            请求参数数组
	 * @return 支付宝处理结果
	 * @throws Exception
	 */
	public static String buildRequest(String strParaFileName, String strFilePath, Map<String, String> sParaTemp)
			throws Exception {
		// 待请求参数数组
		Map<String, String> sPara = buildRequestPara(sParaTemp);

		HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();

		HttpRequest request = new HttpRequest(HttpResultType.BYTES);
		// 设置编码集
		request.setCharset(AlipayConfig.INPUT_CHARSET);

		request.setParameters(generatNameValuePair(sPara));
		request.setUrl(AlipayConfig.ALIPAY_GATEWAY + "_input_charset=" + AlipayConfig.INPUT_CHARSET);

		HttpResponse response = httpProtocolHandler.execute(request, strParaFileName, strFilePath);
		if (response == null) {
			return null;
		}

		String strResult = response.getStringResult();

		return strResult;
	}

}
