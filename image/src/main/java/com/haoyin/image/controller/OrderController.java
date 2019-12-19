package com.haoyin.image.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.haoyin.image.cookie.ShoppingCartCookieManager;
import com.haoyin.image.entity.Delivery;
import com.haoyin.image.entity.DeliveryQuery;
import com.haoyin.image.entity.JSONResult;
import com.haoyin.image.entity.Order;
import com.haoyin.image.entity.OrderInvoice;
import com.haoyin.image.entity.OrderItem;
import com.haoyin.image.entity.OrderItemInfo;
import com.haoyin.image.entity.OrderQuery;
import com.haoyin.image.entity.ShoppingCartItem;
import com.haoyin.image.entity.Traces;
import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.service.InvoiceService;
import com.haoyin.image.service.LogisticService;
import com.haoyin.image.service.OrderProcessService;
import com.haoyin.image.service.OrderService;
import com.haoyin.image.util.KdniaoTrackQueryAPI;
import com.haoyin.image.util.RowNumUtil;


@Controller
public class OrderController {
	
	@Resource
	OrderService  orderService; 
	
	@Resource
	LogisticService logisticService;
	
	@Resource    
	InvoiceService  invoiceService;
	
	@Autowired
	private OrderProcessService orderProcessService; 
	
	@RequestMapping("/order/ongoing-order.html")
	public String order(OrderQuery query,Model model){
		query.setPageSize(5);
		if(getuser().getPosition().equalsIgnoreCase("OEM")){
			query.setUserId(getuser().getId());
		}
		List<Integer> scoutStatusList = new ArrayList<>();
		if(query.getScoutStatus()!=null&&query.getScoutStatus().equals(3)){//如果选择查询待支付
			query.setScoutStatus(0);
			query.setPayStatus(0);
			scoutStatusList.add(0);
		}else if(query.getScoutStatus()!=null&&query.getScoutStatus().equals(0)){//如果选择查询待接单
			query.setScoutStatus(0);
			query.setPayStatus(1);
			scoutStatusList.add(0);
		}else if(query.getScoutStatus()!=null&&query.getScoutStatus().equals(1)){//如果选择查询生产中
			scoutStatusList.add(1);
		}else if(query.getScoutStatus()!=null&&query.getScoutStatus().equals(-1)){//如果选择查询待退款
			scoutStatusList.add(-1);
		}else {//如果都没选
			scoutStatusList.add(0);//待接单
			scoutStatusList.add(1);//生产中
			scoutStatusList.add(-1);//待退款
		}
		
		query.setScoutStatusS(scoutStatusList);

		PageInfo<Order> page=orderService.queryOrderForList1(query);//订单状态为1 
		query.setPageSize(Integer.MAX_VALUE);
		PageInfo<Order> page1=orderService.queryOrderForList1(query);
		List<String>  orderIdList=page1.getList().stream().map(s->s.getId().toString()).distinct().collect(Collectors.toList());
		List<String>  CompanyList=page1.getList().stream().map(s->s.getCompanyName()).distinct().collect(Collectors.toList());
		List<Integer>  statusNameList=page1.getList().stream().map(s->s.getScoutStatus()).distinct().collect(Collectors.toList());
		model.addAttribute("orderIdList", orderIdList);
		model.addAttribute("CompanyList", CompanyList);
		model.addAttribute("statusNameList", statusNameList);
		model.addAttribute("orderList", page.getList());
		model.addAttribute("query", query);
		model.addAttribute("page", page);
		model.addAttribute("userId", getuser().getId());
		return "screen/order/order-list";
	}
	@RequestMapping("/order/finished-order.html")
	public String orderFinished(OrderQuery query,Model model){
		query.setPageSize(5);
		query.setScoutStatus(2);
		List<Integer> scoutStatusList = new ArrayList<>();
		scoutStatusList.add(2);//已完成
		scoutStatusList.add(-3);//已退款
		scoutStatusList.add(-2);//已取消（申请取消但是不用退钱）
		query.setScoutStatusS(scoutStatusList);
		if(getuser().getPosition().equalsIgnoreCase("OEM")){
			query.setUserId(getuser().getId());
		}
		PageInfo<Order> page=orderService.queryOrderForList1(query);
		query.setPageSize(Integer.MAX_VALUE);
		PageInfo<Order> page1=orderService.queryOrderForList1(query);
		List<String>  orderIdList=page1.getList().stream().map(s->s.getId().toString()).distinct().collect(Collectors.toList());
		List<String>  CompanyList=page1.getList().stream().map(s->s.getCompanyName()).distinct().collect(Collectors.toList());
		List<Integer>  statusNameList=page1.getList().stream().map(s->s.getScoutStatus()).distinct().collect(Collectors.toList());
		model.addAttribute("orderIdList", orderIdList);
		model.addAttribute("CompanyList", CompanyList);
		model.addAttribute("statusNameList", statusNameList);
		model.addAttribute("orderList", page.getList());
		model.addAttribute("query", query);
		model.addAttribute("page", page);
		return "screen/order/order-list-finished";
	}
	@RequestMapping("order/order-{orderId}.html")
	public String orderDetail(@PathVariable("orderId")String id,Model model){
		Order  order=orderService.queryOrderById(Long.parseLong(id));
		OrderQuery query=new OrderQuery();
		query.setOrderNo(order.getOrderNo());
		
		UserProfile userProfile = getuser();
		
		List<OrderItemInfo> itemInfoList = orderService.selectItemInfoByOrderId(Long.parseLong(id));
		// 根据条目ID去重
        Set<OrderItemInfo> itemSet = new TreeSet<>((o1, o2) -> o1.getItemId().compareTo(o2.getItemId()) );
        itemSet.addAll(itemInfoList);
        List<OrderItemInfo> a =  new ArrayList<>(itemSet);
        
        List<OrderItemInfo> infoList = new ArrayList<OrderItemInfo>();
        for(int i=0;i<a.size();i++) {
        	OrderItemInfo info = new OrderItemInfo();
    		List<OrderItemInfo> infoList1 = new ArrayList<OrderItemInfo>();
        	for(int j=0;j<itemInfoList.size();j++) {
        		if(a.get(i).getItemId().equals(itemInfoList.get(j).getItemId())) {
        			infoList1.add(itemInfoList.get(j));
        		}
        	}
        	info.setInfoList(infoList1);
        	info.setItemId(a.get(i).getItemId());
        	infoList.add(info);
        }
		
		//List<OrderInvoice> orderInvoice=invoiceService.queryInvoiceInfo(query);
		model.addAttribute("order", order);
		model.addAttribute("infoList", infoList);
		model.addAttribute("userProfile", userProfile);
		//model.addAttribute("position", getuser().getPosition());
		//model.addAttribute("orderInvoiceList", orderInvoice);
		return "screen/order/order-detail";
	}
	@RequestMapping("/order/advance-order.html")
	public String advance(){
		ShoppingCartCookieManager.writeShoppingNumber(15);
		return "screen/order/order-setting-agent";
	}
	
	//购物车前往提交订单
	@RequestMapping("/order/settingDirect.html")
	public String direct(Model model,String[] idList){
		DeliveryQuery query=new DeliveryQuery();
		query.setUserId(getuser().getId());	
		ShoppingCartItem param = new ShoppingCartItem();
		List<String> cartIdList = new ArrayList<>();
		if(idList != null) {
			Collections.addAll(cartIdList,idList);//把数组转变为List
		}else {
			String a = "";
			cartIdList.add(a);
		}
		param.setCartList(cartIdList);
		List<ShoppingCartItem> cartList =  orderProcessService.selectShoppingCartList(param);
		
		List<OrderItemInfo> infoListList = new ArrayList<OrderItemInfo>();
		
		BigDecimal totalPrice = new BigDecimal(0.000);//订单总金额
		
		try {
			for(int i=0;i<cartList.size();i++) {
				
				if(cartList.get(i).getType().equals("1") || cartList.get(i).getType().equals("2") || cartList.get(i).getType().equals("4") || cartList.get(i).getType().equals("5")) {
					File cartFile = new File(cartList.get(i).getFileUrl());
					String suffix = cartList.get(i).getFileUrl().substring(cartList.get(i).getFileUrl().lastIndexOf(".") + 1);
					InputStream is = new FileInputStream(cartFile);
					Workbook wb0 ;
					if("xls".equals(suffix)){
						wb0 = new HSSFWorkbook(is);//2003
		            }else if("xlsx".equals(suffix)){
		            	wb0 = new XSSFWorkbook(is);//2007
		            }else{
		            	wb0 = null;
		            	JSONResult.error("不支持的文件类型: " + suffix);
						throw new RuntimeException("the file is too small, transfer failed.");       
		            }
					
					 // 获取选项卡对象 第0个选项卡  
					Sheet sht0 = wb0.getSheetAt(0);  
					int rowNum = sht0.getLastRowNum();//总行数
					rowNum = RowNumUtil.getRowNum(sht0);
					List<OrderItemInfo> infoList = new ArrayList<>();
					for(int j=1;j<=rowNum;j++) {
						for(int k=0;k<=44;k++) {
							if(sht0.getRow(j).getCell(k) != null) {
								sht0.getRow(j).getCell(k).setCellType(Cell.CELL_TYPE_STRING);
							}
						}
						if(sht0.getRow(j) != null) {
							OrderItemInfo info = new OrderItemInfo();
							info.setCommodityName(cartList.get(i).getCommodityName());//商品名称
							info.setBatch(cartList.get(i).getFileName());//批次号(文件名)
							if(cartList.get(i).getType().equals("1")) {//如果是吊牌1文件（含set price）
								info.setCommodityCode(sht0.getRow(j).getCell(1)==null?null:sht0.getRow(j).getCell(1)+"");//商品编号
								info.setSize(sht0.getRow(j).getCell(4)==null?null:sht0.getRow(j).getCell(4)+"");//size
								if(sht0.getRow(j).getCell(5) != null) {
									sht0.getRow(j).getCell(5).setCellType(Cell.CELL_TYPE_STRING);
								}
								if(sht0.getRow(j).getCell(8) != null) {
									sht0.getRow(j).getCell(8).setCellType(Cell.CELL_TYPE_STRING);
								}
								info.setCurrency(sht0.getRow(j).getCell(5)==null?null:sht0.getRow(j).getCell(5)+"");//币种
								info.setNumber(sht0.getRow(j).getCell(8)==null?null:sht0.getRow(j).getCell(8)+"");//数量
								info.setColor(sht0.getRow(j).getCell(3)==null?null:sht0.getRow(j).getCell(3)+"");//颜色
							}else if(cartList.get(i).getType().equals("2")) {//如果是Summer 2019合格证文件
								info.setCommodityCode(sht0.getRow(j).getCell(2)==null?null:sht0.getRow(j).getCell(2)+"");//商品编号
								info.setSpec(sht0.getRow(j).getCell(5)==null?null:sht0.getRow(j).getCell(5)+"");//号型
								if(sht0.getRow(j).getCell(3) != null) {
									sht0.getRow(j).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								}
								if(sht0.getRow(j).getCell(6) != null) {
									sht0.getRow(j).getCell(6).setCellType(Cell.CELL_TYPE_STRING);
								}
								info.setSize(sht0.getRow(j).getCell(6)==null?null:(sht0.getRow(j).getCell(6)+""));//size(内部码)
								info.setNumber(sht0.getRow(j).getCell(3)==null?null:sht0.getRow(j).getCell(3)+"");//数量
								info.setColor(sht0.getRow(j).getCell(11)==null?null:sht0.getRow(j).getCell(11)+"");//颜色
							}else if(cartList.get(i).getType().equals("4")) {//如果是吊牌2文件（不含set price）
								info.setCommodityCode(sht0.getRow(j).getCell(1)==null?null:sht0.getRow(j).getCell(1)+"");//商品编号
								info.setSize(sht0.getRow(j).getCell(4)==null?null:sht0.getRow(j).getCell(4)+"");//size
								if(sht0.getRow(j).getCell(5) != null) {
									sht0.getRow(j).getCell(5).setCellType(Cell.CELL_TYPE_STRING);
								}
								if(sht0.getRow(j).getCell(7) != null) {
									sht0.getRow(j).getCell(7).setCellType(Cell.CELL_TYPE_STRING);
								}
								info.setCurrency(sht0.getRow(j).getCell(5)==null?null:sht0.getRow(j).getCell(5)+"");//币种
								info.setNumber(sht0.getRow(j).getCell(7)==null?null:sht0.getRow(j).getCell(7)+"");//数量
								info.setColor(sht0.getRow(j).getCell(3)==null?null:sht0.getRow(j).getCell(3)+"");//颜色
							}else if(cartList.get(i).getType().equals("5")) {//如果是fall 2019合格证文件
								if(sht0.getRow(j).getCell(2) != null) {
									sht0.getRow(j).getCell(2).setCellType(Cell.CELL_TYPE_STRING);
								}
								info.setCommodityCode(sht0.getRow(j).getCell(2)==null?null:sht0.getRow(j).getCell(2)+"");//商品编号
								info.setSpec(sht0.getRow(j).getCell(5)==null?null:sht0.getRow(j).getCell(5)+"");//号型
								if(sht0.getRow(j).getCell(3) != null) {
									sht0.getRow(j).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								}
								if(sht0.getRow(j).getCell(6) != null) {
									sht0.getRow(j).getCell(6).setCellType(Cell.CELL_TYPE_STRING);
								}
								info.setSize(sht0.getRow(j).getCell(6)==null?null:(sht0.getRow(j).getCell(6)+""));//size(内部码)
								info.setNumber(sht0.getRow(j).getCell(3)==null?null:sht0.getRow(j).getCell(3)+"");//数量
								info.setColor(sht0.getRow(j).getCell(11)==null?null:sht0.getRow(j).getCell(11)+"");//颜色
							}
							if(info.getNumber()==null || info.getNumber().equals("")) {
								continue;
							}
							info.setRePrice(cartList.get(i).getRePrice());//单价
							
							if(info.getTotalPrice() != null && !info.getTotalPrice().equals("")) {
								BigDecimal price = new BigDecimal(info.getTotalPrice());//订单总金额
								totalPrice = totalPrice.add(price).setScale(3, BigDecimal.ROUND_HALF_UP);
							}
							
							infoList.add(info);
						}
					}
					OrderItemInfo infoWai = new OrderItemInfo();
					infoWai.setInfoList(infoList);
					infoListList.add(infoWai);
				}else if(cartList.get(i).getType().equals("3")) {
					List<OrderItemInfo> infoList = new ArrayList<>();
					OrderItemInfo info = new OrderItemInfo();
					info.setCommodityName(cartList.get(i).getCommodityName());//商品名称
					info.setSize(cartList.get(i).getSize());//size
					info.setNumber(cartList.get(i).getNumber());//数量
					info.setRePrice(cartList.get(i).getRePrice());//单价
					infoList.add(info);
					if(info.getTotalPrice() != null && !info.getTotalPrice().equals("")) {
						BigDecimal price = new BigDecimal(info.getTotalPrice());//订单总金额
						totalPrice = totalPrice.add(price).setScale(3, BigDecimal.ROUND_HALF_UP);
					}
					
					OrderItemInfo infoWai = new OrderItemInfo();
					infoWai.setInfoList(infoList);
					infoListList.add(infoWai);
				}	
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		List<Delivery> deliveryList=logisticService.queryDeliveryList(query);	
		model.addAttribute("deliveryList", deliveryList);
		model.addAttribute("infoListList", infoListList);
		model.addAttribute("totalPrice", totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP));
		model.addAttribute("cartList", cartList);
		return "screen/order/order-setting";
	}
	
	@PostMapping(value="/order/orderInvoiced.html")
	public @ResponseBody String invoiceInfo(@RequestBody List<OrderInvoice> _list){
		_list.stream().peek(s->s.setUserId(getuser().getId())).collect(Collectors.toList());
		return "success";
	}
	
	
	@PostMapping("/order/status-order.html")
	@ResponseBody
	public Boolean updateOrderStatus(Long id,Integer status){
		OrderQuery orderQuery=new OrderQuery();
		orderQuery.setOrderId(id);
		orderQuery.setScoutStatus(status);
	     boolean result=orderService.updateOrderStatus(orderQuery);
	     return result;
	}
	
	private UserProfile getuser() {
		return (UserProfile)SecurityUtils.getSubject().getSession(false).getAttribute("uus");
	}
	
	
	/**
	 * 文件下载
	 */
	
	@RequestMapping("/down-load-file-excel.html")
	public void downLoadFileExcel(Model model,String FileUrl,String itemId,HttpServletResponse response,HttpServletRequest request)throws Exception {
		File file = new File(FileUrl);
		
		if(!file.exists()){
	           
	     }
        FileInputStream fis = new FileInputStream(FileUrl);
        OutputStream fos = response.getOutputStream();
        
        String name = "";
        OrderItem orderItem = orderService.selectOrderItemByItemId(itemId);
        if(orderItem == null || orderItem.getFileName() == null || orderItem.getFileName().equals("")) {
        	name = file.getName();
        }else {
        	name = orderItem.getFileName();
        }
        
        String userAgent = request.getHeader("User-Agent");
        // 针对IE或者以IE为内核的浏览器：
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
        	name = java.net.URLEncoder.encode(name, "UTF-8");
        } else {
            // 非IE浏览器的处理：
        	name = new String(name.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("Content-disposition",String.format("attachment; filename=\"%s\"", name));
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        
        
        // 设置response参数，可以打开下载页面
        //response.reset();
        //response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //response.setHeader("Content-Disposition", "attachment;filename=" + new String(("haha.xls").getBytes(), "iso-8859-1"));

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
              bis = new BufferedInputStream(fis);
              bos = new BufferedOutputStream(fos);
              byte[] buff = new byte[2048];
              int bytesRead;
              // Simple read/write loop.
              while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
              }
        } catch (final IOException e) {
              throw e;
        } finally {
              if (bis != null)
                    bis.close();
              if (bos != null)
                    bos.close();
        }  
		
		
	}
	
	/*@RequestMapping("/trackingInfo/{trackingNum}.html")
	public String trackingInfo(@PathVariable("trackingNum") String trackingNum,Model model){
		KdniaoTrackQueryAPI api = new KdniaoTrackQueryAPI();
		List<Traces>  trackingInfoList=new ArrayList<>();
		try {
			String result = api.getOrderTracesByJson("SF", trackingNum);
			trackingInfoList = JSON.parseArray(JSON.parseObject(result).getString("Traces"), Traces.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("trackingInfoList", trackingInfoList);
		return "screen/order/trackingNum";
	}*/
	
	@RequestMapping("/trackingInfo/{trackingNum}.html")
	@ResponseBody
	public JSON trackingInfo(@PathVariable("trackingNum")Long trackingNum ,Model model,HttpServletResponse response){
		KdniaoTrackQueryAPI api = new KdniaoTrackQueryAPI();
		response.setCharacterEncoding("utf-8");
		List<Traces>  trackingInfoList=new ArrayList<>();
		try {
			String result = api.getOrderTracesByJson("SF", trackingNum.toString());
			trackingInfoList = JSON.parseArray(JSON.parseObject(result).getString("Traces"), Traces.class);
			response.setContentType("application/json; charset=utf-8");  
			response.getWriter().print(JSONObject.toJSON(trackingInfoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
