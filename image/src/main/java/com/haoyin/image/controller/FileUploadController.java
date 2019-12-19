package com.haoyin.image.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFDataValidationHelper;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.at.json.JSONObject;
import com.haoyin.image.entity.Certificate;
import com.haoyin.image.entity.ExcelInfo;
import com.haoyin.image.entity.Fabric;
import com.haoyin.image.entity.InitialExcelInfo;
import com.haoyin.image.entity.JSONResult;
import com.haoyin.image.entity.PropertyConfigurer;
import com.haoyin.image.entity.PropertyName;
import com.haoyin.image.entity.TagInfo;
import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.service.FileUploadService;
import com.haoyin.image.util.GUIDUtil;
import com.haoyin.image.util.RowNumUtil;


@Controller
public class FileUploadController implements PropertyName {
	
	static Logger log = LoggerFactory.getLogger(FileUploadController.class);

	static final String SEPARATOR = "/";
	static final String THUMMB = "thumb";

	static final String[] FILE_TYPES = new String[] { "xlsx", "xls"};

	@Value("${localConfig.fileUploadPath}")
	private String fileUploadPath;
	@Autowired
	@Lazy
	private PropertyConfigurer propertyConfigurer;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	public UserProfile getUser() {
		return (UserProfile) SecurityUtils.getSubject().getSession().getAttribute("uus");
	}

	
	
	@RequestMapping("/file-generation.html")
	public String fileGeneration(Model model) {
		return "file-generation";
	}
	
	
	@RequestMapping("/file-upload.html")
	public String fileUpload(Model model,String id) {
		model.addAttribute("id", id);
		return "file-upload";
	}

	
	/**
	 * 下载模板
	 * @param model
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/down-load-template.html")
	public void downLoadTemplate(Model model,String id,HttpServletResponse response)throws Exception {
		 // 创建新的Excel 工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
     // 在Excel工作簿中建一工作表
        HSSFSheet sheet = wb.createSheet("模板");
        String fileName = "模板";//Excel名称
        
     
 
        if(id.equals("1")) {//价格牌大
        	for(int i=0;i<=9;i++) {
        		sheet.setColumnWidth(i,25*256);//设置列宽
        		CellStyle css = wb.createCellStyle();
        		DataFormat  format = wb.createDataFormat();
        		css.setDataFormat(format.getFormat("@"));
        		sheet.setDefaultColumnStyle(i,css);
        	}
        	String[] textList = new String[]{"¥.","HKD."};

        	CellRangeAddressList regions = new CellRangeAddressList(1, 128, 5, 5);

        	 // 创建下拉列表数据
            DVConstraint constraint = DVConstraint.createExplicitListConstraint(textList);
            // 绑定
            HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
            sheet.addValidationData(dataValidation);
        	
        	//在工作表中创建行
            HSSFRow row = sheet.createRow(0);
            row.setHeightInPoints(20);//设置高度
        	row.createCell(0).setCellValue("公司名称");
        	row.createCell(1).setCellValue("Item No.");
        	row.createCell(2).setCellValue("SMLPC#");
        	row.createCell(3).setCellValue("Colour");
        	row.createCell(4).setCellValue("Size");
        	row.createCell(5).setCellValue("币种");
        	row.createCell(6).setCellValue("Unit Price");
        	row.createCell(7).setCellValue("SET PRICE");
        	row.createCell(8).setCellValue("order qty");
        	row.createCell(9).setCellValue("Barcode#");
        	row.createCell(10).setCellValue("Description");
            
            row = sheet.createRow(1);
            row.setHeightInPoints(20);
            row.createCell(0).setCellValue("");
        	row.createCell(1).setCellValue("18WDWFMCXX261");
        	row.createCell(2).setCellValue("INHT006");
        	row.createCell(3).setCellValue("WHT");
        	row.createCell(4).setCellValue("35");
        	row.createCell(5).setCellValue("¥.");
        	row.createCell(6).setCellValue("1590");
        	row.createCell(7).setCellValue("SET PRICE");
        	row.createCell(8).setCellValue("28");
        	row.createCell(9).setCellValue("6971633530797");
        	row.createCell(10).setCellValue("Ladies Shoes");
        	fileName = "价格牌模板（大）";
        }
        
        if(id.equals("2")) {//价格牌小
        	for(int i=0;i<=9;i++) {
        		sheet.setColumnWidth(i,25*256);//设置列宽
        		CellStyle css = wb.createCellStyle();
        		DataFormat  format = wb.createDataFormat();
        		css.setDataFormat(format.getFormat("@"));
        		sheet.setDefaultColumnStyle(i,css);
        	}
        	//在工作表中创建行
            HSSFRow row = sheet.createRow(0);
            row.setHeightInPoints(20);//设置高度
        	row.createCell(0).setCellValue("公司名称");
        	row.createCell(1).setCellValue("Item No.");
        	row.createCell(2).setCellValue("SMLPC#");
        	row.createCell(3).setCellValue("Colour");
        	row.createCell(4).setCellValue("Size");
        	row.createCell(5).setCellValue("币种");
        	row.createCell(6).setCellValue("Unit Price");
        	//row.createCell(7).setCellValue("SET PRICE");
        	row.createCell(7).setCellValue("order qty");
        	row.createCell(8).setCellValue("Barcode#");
        	row.createCell(9).setCellValue("Description");
            
            row = sheet.createRow(1);
            row.setHeightInPoints(20);
            row.createCell(0).setCellValue("");
        	row.createCell(1).setCellValue("18WDWFMCXX261");
        	row.createCell(2).setCellValue("INHT009");
        	row.createCell(3).setCellValue("WHT");
        	row.createCell(4).setCellValue("35");
        	row.createCell(5).setCellValue("RMB");
        	row.createCell(6).setCellValue("1590");
        	//row.createCell(7).setCellValue("是");
        	row.createCell(7).setCellValue("28");
        	row.createCell(8).setCellValue("6971633530797");
        	row.createCell(9).setCellValue("Ladies Shoes");
        	fileName = "价格牌模板（小）";
        }
        
        if(id.equals("3") || id.equals("4")) {//samll合格证大和小
        	for(int i=0;i<=42;i++) {
        		sheet.setColumnWidth(i,25*256);//设置列宽
        		CellStyle css = wb.createCellStyle();
        		DataFormat  format = wb.createDataFormat();
        		css.setDataFormat(format.getFormat("@"));
        		sheet.setDefaultColumnStyle(i,css);
        	}
            //在工作表中创建行
            HSSFRow row = sheet.createRow(0);
            row.setHeightInPoints(20);//设置高度
            row.createCell(0).setCellValue("公司名称 ");
            row.createCell(1).setCellValue("SMLPC# ");
            
        	row.createCell(2).setCellValue("货品编号");
        	
        	row.createCell(3).setCellValue("order qty");
        	
        	row.createCell(4).setCellValue("产品名称");
        	row.createCell(5).setCellValue("号型");
        	row.createCell(6).setCellValue("内部码");
        	row.createCell(7).setCellValue("等级");
        	row.createCell(8).setCellValue("产品标准");
        	row.createCell(9).setCellValue("安全类别");
        	row.createCell(10).setCellValue("类别");
        	row.createCell(11).setCellValue("颜色");
        	row.createCell(12).setCellValue("生产日期");
        	row.createCell(13).setCellValue("材料层1");
        	row.createCell(14).setCellValue("成分名称1");
        	row.createCell(15).setCellValue("备注1");
        	row.createCell(16).setCellValue("材料层2");
        	row.createCell(17).setCellValue("成分名称2");
        	row.createCell(18).setCellValue("备注2");
        	row.createCell(19).setCellValue("材料层3");
        	row.createCell(20).setCellValue("成分名称3");
        	row.createCell(21).setCellValue("备注3");
        	row.createCell(22).setCellValue("材料层4");
        	row.createCell(23).setCellValue("成分名称4");
        	row.createCell(24).setCellValue("备注4");
        	row.createCell(25).setCellValue("材料层5");
        	row.createCell(26).setCellValue("成分名称5");
        	row.createCell(27).setCellValue("备注5");
        	row.createCell(28).setCellValue("材料层6");
        	row.createCell(29).setCellValue("成分名称6");
        	row.createCell(30).setCellValue("备注6");
        	row.createCell(31).setCellValue("材料层7");
        	row.createCell(32).setCellValue("成分名称7");
        	row.createCell(33).setCellValue("备注7");
        	row.createCell(34).setCellValue("材料层8");
        	row.createCell(35).setCellValue("成分名称8");
        	row.createCell(36).setCellValue("备注8");
        	row.createCell(37).setCellValue("检测员");
        	row.createCell(38).setCellValue("产地");
        	row.createCell(39).setCellValue("经销商");
        	row.createCell(40).setCellValue("地址");
        	row.createCell(41).setCellValue("详细地址");
        	row.createCell(42).setCellValue("电话");
        	row.createCell(43).setCellValue("邮政编码");
        	row.createCell(44).setCellValue("洗涤说明");
            
            row = sheet.createRow(1);
            row.setHeightInPoints(20);//设置高度
            row.createCell(0).setCellValue("嘉澜");
            if(id.equals("3")) {//大
                row.createCell(1).setCellValue("INHT007");
            }else {//小
            	row.createCell(1).setCellValue("INHT014");
            }
                       
            row.createCell(2).setCellValue("18WDWFMCXX261");
            
            row.createCell(3).setCellValue("60");
            
        	row.createCell(4).setCellValue("女装羽绒外套");
        	row.createCell(5).setCellValue("155/76A");
        	row.createCell(6).setCellValue("1");
        	row.createCell(7).setCellValue("合格品");
        	row.createCell(8).setCellValue("GB/T 14272-2011");
        	row.createCell(9).setCellValue("GB 18401-2010");
        	row.createCell(10).setCellValue("C类(非直接接触皮肤的产品)");
        	row.createCell(11).setCellValue("BKS");
        	row.createCell(12).setCellValue("2018年11月30日");
        	row.createCell(13).setCellValue("面料1");
        	row.createCell(14).setCellValue("67%聚酯纤维/24.4%粘纤");
        	row.createCell(15).setCellValue("备注1");
        	row.createCell(16).setCellValue("面料2");
        	row.createCell(17).setCellValue("");
        	row.createCell(18).setCellValue("");
        	row.createCell(19).setCellValue("");
        	row.createCell(20).setCellValue("");
        	row.createCell(21).setCellValue("");
        	row.createCell(22).setCellValue("");
        	row.createCell(23).setCellValue("");
        	row.createCell(24).setCellValue("");
        	row.createCell(25).setCellValue("");
        	row.createCell(26).setCellValue("");
        	row.createCell(27).setCellValue("");
        	row.createCell(28).setCellValue("");
        	row.createCell(29).setCellValue("");
        	row.createCell(30).setCellValue("");
        	row.createCell(31).setCellValue("");
        	row.createCell(32).setCellValue("");
        	row.createCell(33).setCellValue("");
        	row.createCell(34).setCellValue("");
        	row.createCell(35).setCellValue("");
        	row.createCell(36).setCellValue("");
        	row.createCell(37).setCellValue("001");
        	row.createCell(38).setCellValue("中国江苏省南京市");
        	row.createCell(39).setCellValue("上海依迪索时装有限公司");
        	row.createCell(40).setCellValue("上海徐汇区");
        	row.createCell(41).setCellValue("柳州路928号百丽大厦8楼");
        	row.createCell(42).setCellValue("021-60872386");
        	row.createCell(43).setCellValue("200233");
        	row.createCell(44).setCellValue("7A");
        	fileName = "Summer 2019 版合格证模板";
        }

        //Fall 2019 版合格证模板  or  成衣-合格证
        if(id.equals("5") || id.equals("6") || id.equals("9") || id.equals("10")) {
        	for(int i=0;i<=42;i++) {
        		sheet.setColumnWidth(i,25*256);//设置列宽
        		CellStyle css = wb.createCellStyle();
        		DataFormat  format = wb.createDataFormat();
        		css.setDataFormat(format.getFormat("@"));
        		sheet.setDefaultColumnStyle(i,css);
        	}
            //在工作表中创建行
            HSSFRow row = sheet.createRow(0);
            row.setHeightInPoints(20);//设置高度
            row.createCell(0).setCellValue("公司名称 ");
            row.createCell(1).setCellValue("SMLPC# ");
            
        	row.createCell(2).setCellValue("货品编号");
        	
        	row.createCell(3).setCellValue("order qty");
        	
        	row.createCell(4).setCellValue("产品名称");
        	row.createCell(5).setCellValue("号型");
        	row.createCell(6).setCellValue("内部码");
        	row.createCell(7).setCellValue("等级");
        	row.createCell(8).setCellValue("执行标准");
        	row.createCell(9).setCellValue("安全类别");
        	row.createCell(10).setCellValue("类别");
        	row.createCell(11).setCellValue("颜色");
        	row.createCell(12).setCellValue("生产日期");
        	
        	row.createCell(13).setCellValue("成份");
        	row.createCell(14).setCellValue("检测员");
        	row.createCell(15).setCellValue("产地");
        	row.createCell(16).setCellValue("经销商");
        	row.createCell(17).setCellValue("地址");
        	row.createCell(18).setCellValue("详细地址");
        	row.createCell(19).setCellValue("电话");
        	row.createCell(20).setCellValue("邮政编码");
        	row.createCell(21).setCellValue("洗涤说明");
            
            row = sheet.createRow(1);
            row.setHeightInPoints(20);//设置高度
            row.createCell(0).setCellValue("嘉澜");
            if(id.equals("5")) {//大
                row.createCell(1).setCellValue("INHT007");
            }else {//小
            	row.createCell(1).setCellValue("INHT014");
            }          
            row.createCell(2).setCellValue("18WDWFMCXX261");
            
            row.createCell(3).setCellValue("60");
            
        	row.createCell(4).setCellValue("女装羽绒外套");
        	row.createCell(5).setCellValue("155/76A");
        	row.createCell(6).setCellValue("1");
        	row.createCell(7).setCellValue("合格品");
        	if(id.equals("10")) {//成衣-合格证（两件套）
            	row.createCell(8).setCellValue("外件：Q31/0109000069C001-2018"+ "\r\n" + "内件：Q31/0109000069C001-2018");
        	}else {
            	row.createCell(8).setCellValue("Q31/0109000069C001-2018");
        	}
        	row.createCell(9).setCellValue("GB 18401-2010");
        	row.createCell(10).setCellValue("C类(非直接接触皮肤的产品)");
        	row.createCell(11).setCellValue("BKS");
        	row.createCell(12).setCellValue("2018年11月30日");
        	row.createCell(13).setCellValue("详见内洗标");
     
        	row.createCell(14).setCellValue("001");
        	row.createCell(15).setCellValue("中国江苏省南京市");
        	row.createCell(16).setCellValue("上海依迪索时装有限公司");
        	row.createCell(17).setCellValue("上海徐汇区");
        	row.createCell(18).setCellValue("柳州路928号百丽大厦8楼");
        	row.createCell(19).setCellValue("021-60872386");
        	row.createCell(20).setCellValue("200233");
        	row.createCell(21).setCellValue("详见内洗标");
        	if(id.equals("5") || id.equals("6")) {
        		fileName = "Fall 2019 版合格证模板";
        	}else {
        		fileName = "合格证 成衣 模板";
        	}
        	
        }
        
        if(id.equals("7") || id.equals("8")) {
        	for(int i=0;i<=42;i++) {
        		sheet.setColumnWidth(i,25*256);//设置列宽
        		CellStyle css = wb.createCellStyle();
        		DataFormat  format = wb.createDataFormat();
        		css.setDataFormat(format.getFormat("@"));
        		sheet.setDefaultColumnStyle(i,css);
        	}
            //在工作表中创建行
            HSSFRow row = sheet.createRow(0);
            row.setHeightInPoints(20);//设置高度
            row.createCell(0).setCellValue("公司名称 ");
            row.createCell(1).setCellValue("SMLPC# ");
            
        	row.createCell(2).setCellValue("货品编号");
        	
        	row.createCell(3).setCellValue("order qty");
        	
        	row.createCell(4).setCellValue("产品名称");
        	row.createCell(5).setCellValue("号型");
        	row.createCell(6).setCellValue("内部码");
        	row.createCell(7).setCellValue("等级");
        	row.createCell(8).setCellValue("执行标准");
        	row.createCell(9).setCellValue("安全类别");
        	row.createCell(10).setCellValue("类别");
        	row.createCell(11).setCellValue("颜色");
        	row.createCell(12).setCellValue("生产日期");
        	row.createCell(13).setCellValue("材料层1");
        	row.createCell(14).setCellValue("成分名称1");
        	row.createCell(15).setCellValue("备注1");
        	row.createCell(16).setCellValue("材料层2");
        	row.createCell(17).setCellValue("成分名称2");
        	row.createCell(18).setCellValue("备注2");
        	row.createCell(19).setCellValue("材料层3");
        	row.createCell(20).setCellValue("成分名称3");
        	row.createCell(21).setCellValue("备注3");
        	row.createCell(22).setCellValue("材料层4");
        	row.createCell(23).setCellValue("成分名称4");
        	row.createCell(24).setCellValue("备注4");
        	row.createCell(25).setCellValue("材料层5");
        	row.createCell(26).setCellValue("成分名称5");
        	row.createCell(27).setCellValue("备注5");
        	row.createCell(28).setCellValue("材料层6");
        	row.createCell(29).setCellValue("成分名称6");
        	row.createCell(30).setCellValue("备注6");
        	row.createCell(31).setCellValue("材料层7");
        	row.createCell(32).setCellValue("成分名称7");
        	row.createCell(33).setCellValue("备注7");
        	row.createCell(34).setCellValue("材料层8");
        	row.createCell(35).setCellValue("成分名称8");
        	row.createCell(36).setCellValue("备注8");
        	row.createCell(37).setCellValue("检测员");
        	row.createCell(38).setCellValue("产地");
        	row.createCell(39).setCellValue("经销商");
        	row.createCell(40).setCellValue("地址");
        	row.createCell(41).setCellValue("详细地址");
        	row.createCell(42).setCellValue("电话");
        	row.createCell(43).setCellValue("邮政编码");
        	row.createCell(44).setCellValue("洗涤说明");
            
            row = sheet.createRow(1);
            row.setHeightInPoints(20);//设置高度
            row.createCell(0).setCellValue("嘉澜");
            if(id.equals("7")) {//大
                row.createCell(1).setCellValue("INHT007");
            }else {//小
            	row.createCell(1).setCellValue("INHT014");
            }             
            row.createCell(2).setCellValue("18WDWFMCXX261");
            
            row.createCell(3).setCellValue("60");
            
        	row.createCell(4).setCellValue("女装羽绒外套");
        	row.createCell(5).setCellValue("155/76A");
        	row.createCell(6).setCellValue("1");
        	row.createCell(7).setCellValue("合格品");
        	row.createCell(8).setCellValue("GB/T 14272-2011");
        	row.createCell(9).setCellValue("GB 18401-2010");
        	row.createCell(10).setCellValue("C类(非直接接触皮肤的产品)");
        	row.createCell(11).setCellValue("BKS");
        	row.createCell(12).setCellValue("2018年11月30日");
        	row.createCell(13).setCellValue("面料1");
        	row.createCell(14).setCellValue("67%聚酯纤维/24.4%粘纤");
        	row.createCell(15).setCellValue("备注1");
        	row.createCell(16).setCellValue("面料2");
        	row.createCell(17).setCellValue("");
        	row.createCell(18).setCellValue("");
        	row.createCell(19).setCellValue("");
        	row.createCell(20).setCellValue("");
        	row.createCell(21).setCellValue("");
        	row.createCell(22).setCellValue("");
        	row.createCell(23).setCellValue("");
        	row.createCell(24).setCellValue("");
        	row.createCell(25).setCellValue("");
        	row.createCell(26).setCellValue("");
        	row.createCell(27).setCellValue("");
        	row.createCell(28).setCellValue("");
        	row.createCell(29).setCellValue("");
        	row.createCell(30).setCellValue("");
        	row.createCell(31).setCellValue("");
        	row.createCell(32).setCellValue("");
        	row.createCell(33).setCellValue("");
        	row.createCell(34).setCellValue("");
        	row.createCell(35).setCellValue("");
        	row.createCell(36).setCellValue("");
        	row.createCell(37).setCellValue("001");
        	row.createCell(38).setCellValue("中国江苏省南京市");
        	row.createCell(39).setCellValue("上海依迪索时装有限公司");
        	row.createCell(40).setCellValue("上海徐汇区");
        	row.createCell(41).setCellValue("柳州路928号百丽大厦8楼");
        	row.createCell(42).setCellValue("021-60872386");
        	row.createCell(43).setCellValue("200233");
        	row.createCell(44).setCellValue("7A");
        	fileName = "ACC 大合格证";
        }
        
        
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        wb.write(os);
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
              bis = new BufferedInputStream(is);
              bos = new BufferedOutputStream(out);
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
	
	
	
	/**
	 * 提交文件
	 * @param response
	 * @param fileUrl
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/submit-excel-info.html")
	public JSONResult submitExcelInfo(HttpServletResponse response,String fileUrl,String fileName,String id) {
		try{
			String suffix = fileUrl.substring(fileUrl.lastIndexOf(".") + 1);
			File file = new File(fileUrl);
			InputStream is = new FileInputStream(file);
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
	        
	        List<InitialExcelInfo> infoList = new ArrayList<>();
	       
        	for (int i = 1; i <= rowNum; i++) {
	        	//创建实体类
        		InitialExcelInfo info=new InitialExcelInfo();
        		
        		//价格牌(大)
        		if(id.equals("1")) {
        			for(int j=0;j<=10;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
        			if(sht0.getRow(i)!=null) {
        				info.setCustomerName(String.valueOf(sht0.getRow(i).getCell(0)));
    					info.setItemNo(String.valueOf(sht0.getRow(i).getCell(1)));//款号
    					info.setSmlpc(String.valueOf(sht0.getRow(i).getCell(2)));
    					info.setColour(String.valueOf(sht0.getRow(i).getCell(3)));//颜色
    					info.setSize(sht0.getRow(i).getCell(4)+"");
    					info.setCurrency(String.valueOf(sht0.getRow(i).getCell(5)));//币种
    					info.setUnitPrice(sht0.getRow(i).getCell(6)+"");
    					info.setSetPrice(String.valueOf(sht0.getRow(i).getCell(7)));// SET PRICE
    					info.setOrderQty(String.valueOf(sht0.getRow(i).getCell(8)));
    					info.setBarCode(String.valueOf(sht0.getRow(i).getCell(9)));
    					info.setDescription(String.valueOf(sht0.getRow(i).getCell(10)));
    					
    					infoList.add(info);
        			}
					
        		}
        		
        		//价格牌(小)
        		if(id.equals("2")) {
        			for(int j=0;j<=9;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
        			if(sht0.getRow(i)!=null) {
        				info.setCustomerName(String.valueOf(sht0.getRow(i).getCell(0)));
    					info.setItemNo(String.valueOf(sht0.getRow(i).getCell(1)));//款号
    					info.setSmlpc(String.valueOf(sht0.getRow(i).getCell(2)));
    					info.setColour(String.valueOf(sht0.getRow(i).getCell(3)));//颜色
    					info.setSize(sht0.getRow(i).getCell(4)+"");
    					info.setCurrency(String.valueOf(sht0.getRow(i).getCell(5)));//币种
    					info.setUnitPrice(sht0.getRow(i).getCell(6)+"");
    					//info.setSetPrice(String.valueOf(sht0.getRow(i).getCell(7)));// SET PRICE
    					info.setOrderQty(String.valueOf(sht0.getRow(i).getCell(7)));
    					info.setBarCode(String.valueOf(sht0.getRow(i).getCell(8)));
    					info.setDescription(String.valueOf(sht0.getRow(i).getCell(9)));
    					
    					infoList.add(info);
        			}
					
        		}
        		
        		if(id.equals("3") || id.equals("4")) {
		        	for(int j=0;j<=11;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	for(int j=13;j<=44;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	if(sht0.getRow(i)!=null) {
		        		info.setCustomerName(sht0.getRow(i).getCell(0)+"");// 公司名称
			        	info.setSmlpc(sht0.getRow(i).getCell(1)+"");// SMLPC
			        	
			        	info.setItemNo(sht0.getRow(i).getCell(2)+"");// 货品编号 
			        	
			        	info.setOrderQty(String.valueOf(sht0.getRow(i).getCell(3)));// order qty 数量
			        	
			        	info.setProductName(sht0.getRow(i).getCell(4)+"");//产品名称
			        	info.setType(sht0.getRow(i).getCell(5)+"");//号型
			        	//info.setArtNo(sht0.getRow(i).getCell(6)+"");//货号
				        info.setInternalCode(sht0.getRow(i).getCell(6)+"");//内部码
			        	info.setGrade(sht0.getRow(i).getCell(7)+"");//等级
			        	info.setProductStandard(sht0.getRow(i).getCell(8)+"");//产品标准
			        	info.setSecurityCategory(sht0.getRow(i).getCell(9)+"");//安全级别
			        	info.setCategory(sht0.getRow(i).getCell(10)+"");//安全级别类别
			        	info.setColour(sht0.getRow(i).getCell(11)+"");//颜色
			        	
			        	Cell riQiCell = sht0.getRow(i).getCell(12);
			        	if(riQiCell != null) {
			        		String haha = parseExcel(riQiCell);
				        	info.setDateOfManufacture(haha);//生产日期
			        		
			        	}else {
			        		info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	}
			        	
			        	//info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	info.setFabricNameOne(sht0.getRow(i).getCell(13)+"");//面料材质1
			        	info.setFabricInfoOne(sht0.getRow(i).getCell(14)+"");//面料备注1		        	
			        	info.setFabricRemarksOne(sht0.getRow(i).getCell(15)+"");//面料备注1
			        	
			        	info.setFabricNameTwo(sht0.getRow(i).getCell(16)+"");//面料材质2
			        	info.setFabricInfoTwo(sht0.getRow(i).getCell(17)+"");//面料备注2		        	
			        	info.setFabricRemarksTwo(sht0.getRow(i).getCell(18)+"");//面料备注2
			        	
			        	info.setFabricNameThree(sht0.getRow(i).getCell(19)+"");//面料材质3
			        	info.setFabricInfoThree(sht0.getRow(i).getCell(20)+"");//面料备注3		        	
			        	info.setFabricRemarksThree(sht0.getRow(i).getCell(21)+"");//面料备注3
			        	
			        	info.setFabricNameFour(sht0.getRow(i).getCell(22)+"");//面料材质4
			        	info.setFabricInfoFour(sht0.getRow(i).getCell(23)+"");//面料备注4		        	
			        	info.setFabricRemarksFour(sht0.getRow(i).getCell(24)+"");//面料备注4
			        	
			        	info.setFabricNameFive(sht0.getRow(i).getCell(25)+"");//面料材质5
			        	info.setFabricInfoFive(sht0.getRow(i).getCell(26)+"");//面料备注5		        	
			        	info.setFabricRemarksFive(sht0.getRow(i).getCell(27)+"");//面料备注5
			        	
			        	info.setFabricNameSix(sht0.getRow(i).getCell(28)+"");//面料材质6
			        	info.setFabricInfoSix(sht0.getRow(i).getCell(29)+"");//面料备注6		        	
			        	info.setFabricRemarksSix(sht0.getRow(i).getCell(30)+"");//面料备注6
			        	
			        	info.setFabricNameSeven(sht0.getRow(i).getCell(31)+"");//面料材质7
			        	info.setFabricInfoSeven(sht0.getRow(i).getCell(32)+"");//面料备注7		        	
			        	info.setFabricRemarksSeven(sht0.getRow(i).getCell(33)+"");//面料备注7
			        	
			        	info.setFabricNameEight(sht0.getRow(i).getCell(34)+"");//面料材质8
			        	info.setFabricInfoEight(sht0.getRow(i).getCell(35)+"");//面料备注8		        	
			        	info.setFabricRemarksEight(sht0.getRow(i).getCell(36)+"");//面料备注8
			        	
			        	info.setInspector(sht0.getRow(i).getCell(37)+"");//检测员
			        	info.setPlaceOfOrigin(sht0.getRow(i).getCell(38)+"");//产地
			        	info.setDistributor(sht0.getRow(i).getCell(39)+"");//经销商
			        	info.setLocation(sht0.getRow(i).getCell(40)+"");//地址
			        	info.setLocationInfo(sht0.getRow(i).getCell(41)+"");//详情地址
			        	info.setPhone(sht0.getRow(i).getCell(42)+"");//电话
				        info.setPostalCode(sht0.getRow(i).getCell(43)+"");//邮政编码
			        	info.setWashingInstructions(sht0.getRow(i).getCell(44)+"");//洗涤说明
						infoList.add(info);
		        	}
		        	
        		}
        		
        		//Fall版合格证
        		if(id.equals("5") || id.equals("6")) {
		        	for(int j=0;j<=11;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	for(int j=13;j<=21;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	if(sht0.getRow(i)!=null) {
		        		info.setCustomerName(sht0.getRow(i).getCell(0)+"");// 公司名称
			        	info.setSmlpc(sht0.getRow(i).getCell(1)+"");// SMLPC
			        	
			        	info.setItemNo(sht0.getRow(i).getCell(2)+"");// 货品编号 
			        	
			        	info.setOrderQty(String.valueOf(sht0.getRow(i).getCell(3)));// order qty 数量
			        	
			        	info.setProductName(sht0.getRow(i).getCell(4)+"");//产品名称
			        	info.setType(sht0.getRow(i).getCell(5)+"");//号型
				        info.setInternalCode(sht0.getRow(i).getCell(6)+"");//内部码
			        	info.setGrade(sht0.getRow(i).getCell(7)+"");//等级
			        	info.setProductStandard(sht0.getRow(i).getCell(8)+"");//产品标准
			        	info.setSecurityCategory(sht0.getRow(i).getCell(9)+"");//安全级别
			        	info.setCategory(sht0.getRow(i).getCell(10)+"");//安全级别类别
			        	info.setColour(sht0.getRow(i).getCell(11)+"");//颜色
			        	
			        	Cell riQiCell = sht0.getRow(i).getCell(12);
			        	if(riQiCell != null) {
			        		String haha = parseExcel(riQiCell);
				        	info.setDateOfManufacture(haha);//生产日期
			        		
			        	}else {
			        		info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	}
			        	
			        	//info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	
			        	info.setFabricString(sht0.getRow(i).getCell(13)+"");//成份(面料)
			        	
			        	info.setInspector(sht0.getRow(i).getCell(14)+"");//检测员
			        	info.setPlaceOfOrigin(sht0.getRow(i).getCell(15)+"");//产地
			        	info.setDistributor(sht0.getRow(i).getCell(16)+"");//经销商
			        	info.setLocation(sht0.getRow(i).getCell(17)+"");//地址
			        	info.setLocationInfo(sht0.getRow(i).getCell(18)+"");//详情地址
			        	info.setPhone(sht0.getRow(i).getCell(19)+"");//电话
				        info.setPostalCode(sht0.getRow(i).getCell(20)+"");//邮政编码
			        	info.setWashingInstructions(sht0.getRow(i).getCell(21)+"");//洗涤说明
						infoList.add(info);
		        	}
		        	
        		}
        		
        		//2019新版合格证 4.11
        		if(id.equals("7") || id.equals("8")) {
		        	for(int j=0;j<=11;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	for(int j=13;j<=44;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	if(sht0.getRow(i)!=null) {
		        		info.setCustomerName(sht0.getRow(i).getCell(0)+"");// 公司名称
			        	info.setSmlpc(sht0.getRow(i).getCell(1)+"");// SMLPC
			        	
			        	info.setItemNo(sht0.getRow(i).getCell(2)+"");// 货品编号 
			        	
			        	info.setOrderQty(String.valueOf(sht0.getRow(i).getCell(3)));// order qty 数量
			        	
			        	info.setProductName(sht0.getRow(i).getCell(4)+"");//产品名称
			        	info.setType(sht0.getRow(i).getCell(5)+"");//号型
			        	//info.setArtNo(sht0.getRow(i).getCell(6)+"");//货号
				        info.setInternalCode(sht0.getRow(i).getCell(6)+"");//内部码
			        	info.setGrade(sht0.getRow(i).getCell(7)+"");//等级
			        	info.setProductStandard(sht0.getRow(i).getCell(8)+"");//产品标准
			        	info.setSecurityCategory(sht0.getRow(i).getCell(9)+"");//安全级别
			        	info.setCategory(sht0.getRow(i).getCell(10)+"");//安全级别类别
			        	info.setColour(sht0.getRow(i).getCell(11)+"");//颜色
			        	
			        	Cell riQiCell = sht0.getRow(i).getCell(12);
			        	if(riQiCell != null) {
			        		String haha = parseExcel(riQiCell);
				        	info.setDateOfManufacture(haha);//生产日期
			        		
			        	}else {
			        		info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	}
			        	
			        	//info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	info.setFabricNameOne(sht0.getRow(i).getCell(13)+"");//面料材质1
			        	info.setFabricInfoOne(sht0.getRow(i).getCell(14)+"");//面料备注1		        	
			        	info.setFabricRemarksOne(sht0.getRow(i).getCell(15)+"");//面料备注1
			        	
			        	info.setFabricNameTwo(sht0.getRow(i).getCell(16)+"");//面料材质2
			        	info.setFabricInfoTwo(sht0.getRow(i).getCell(17)+"");//面料备注2		        	
			        	info.setFabricRemarksTwo(sht0.getRow(i).getCell(18)+"");//面料备注2
			        	
			        	info.setFabricNameThree(sht0.getRow(i).getCell(19)+"");//面料材质3
			        	info.setFabricInfoThree(sht0.getRow(i).getCell(20)+"");//面料备注3		        	
			        	info.setFabricRemarksThree(sht0.getRow(i).getCell(21)+"");//面料备注3
			        	
			        	info.setFabricNameFour(sht0.getRow(i).getCell(22)+"");//面料材质4
			        	info.setFabricInfoFour(sht0.getRow(i).getCell(23)+"");//面料备注4		        	
			        	info.setFabricRemarksFour(sht0.getRow(i).getCell(24)+"");//面料备注4
			        	
			        	info.setFabricNameFive(sht0.getRow(i).getCell(25)+"");//面料材质5
			        	info.setFabricInfoFive(sht0.getRow(i).getCell(26)+"");//面料备注5		        	
			        	info.setFabricRemarksFive(sht0.getRow(i).getCell(27)+"");//面料备注5
			        	
			        	info.setFabricNameSix(sht0.getRow(i).getCell(28)+"");//面料材质6
			        	info.setFabricInfoSix(sht0.getRow(i).getCell(29)+"");//面料备注6		        	
			        	info.setFabricRemarksSix(sht0.getRow(i).getCell(30)+"");//面料备注6
			        	
			        	info.setFabricNameSeven(sht0.getRow(i).getCell(31)+"");//面料材质7
			        	info.setFabricInfoSeven(sht0.getRow(i).getCell(32)+"");//面料备注7		        	
			        	info.setFabricRemarksSeven(sht0.getRow(i).getCell(33)+"");//面料备注7
			        	
			        	info.setFabricNameEight(sht0.getRow(i).getCell(34)+"");//面料材质8
			        	info.setFabricInfoEight(sht0.getRow(i).getCell(35)+"");//面料备注8		        	
			        	info.setFabricRemarksEight(sht0.getRow(i).getCell(36)+"");//面料备注8
			        	
			        	info.setInspector(sht0.getRow(i).getCell(37)+"");//检测员
			        	info.setPlaceOfOrigin(sht0.getRow(i).getCell(38)+"");//产地
			        	info.setDistributor(sht0.getRow(i).getCell(39)+"");//经销商
			        	info.setLocation(sht0.getRow(i).getCell(40)+"");//地址
			        	info.setLocationInfo(sht0.getRow(i).getCell(41)+"");//详情地址
			        	info.setPhone(sht0.getRow(i).getCell(42)+"");//电话
				        info.setPostalCode(sht0.getRow(i).getCell(43)+"");//邮政编码
			        	info.setWashingInstructions(sht0.getRow(i).getCell(44)+"");//洗涤说明
						infoList.add(info);
		        	}
		        	
        		}
        		
        		
        		//合格证 成衣  2019-7-25添加
        		if(id.equals("9") || id.equals("10")) {
		        	for(int j=0;j<=11;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	for(int j=13;j<=21;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	if(sht0.getRow(i)!=null) {
		        		info.setCustomerName(sht0.getRow(i).getCell(0)+"");// 公司名称
			        	info.setSmlpc(sht0.getRow(i).getCell(1)+"");// SMLPC
			        	
			        	info.setItemNo(sht0.getRow(i).getCell(2)+"");// 货品编号 
			        	
			        	info.setOrderQty(String.valueOf(sht0.getRow(i).getCell(3)));// order qty 数量
			        	
			        	info.setProductName(sht0.getRow(i).getCell(4)+"");//产品名称
			        	info.setType(sht0.getRow(i).getCell(5)+"");//号型
				        info.setInternalCode(sht0.getRow(i).getCell(6)+"");//内部码
			        	info.setGrade(sht0.getRow(i).getCell(7)+"");//等级
			        	info.setProductStandard(sht0.getRow(i).getCell(8)+"");//产品标准
			        	info.setSecurityCategory(sht0.getRow(i).getCell(9)+"");//安全级别
			        	info.setCategory(sht0.getRow(i).getCell(10)+"");//安全级别类别
			        	info.setColour(sht0.getRow(i).getCell(11)+"");//颜色
			        	
			        	Cell riQiCell = sht0.getRow(i).getCell(12);
			        	if(riQiCell != null) {
			        		String haha = parseExcel(riQiCell);
				        	info.setDateOfManufacture(haha);//生产日期
			        		
			        	}else {
			        		info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	}
			        				        	
			        	info.setFabricString(sht0.getRow(i).getCell(13)+"");//成份(面料)
			        	
			        	info.setInspector(sht0.getRow(i).getCell(14)+"");//检测员
			        	info.setPlaceOfOrigin(sht0.getRow(i).getCell(15)+"");//产地
			        	info.setDistributor(sht0.getRow(i).getCell(16)+"");//经销商
			        	info.setLocation(sht0.getRow(i).getCell(17)+"");//地址
			        	info.setLocationInfo(sht0.getRow(i).getCell(18)+"");//详情地址
			        	info.setPhone(sht0.getRow(i).getCell(19)+"");//电话
				        info.setPostalCode(sht0.getRow(i).getCell(20)+"");//邮政编码
			        	info.setWashingInstructions(sht0.getRow(i).getCell(21)+"");//洗涤说明
						infoList.add(info);
		        	}
		        	
        		}
        		
	        }
        	
        	
        	
			
			
			ExcelInfo info = new ExcelInfo();
			info.setFileName(fileName);
			info.setAbsoluteUrl(fileUrl);
			info.setUploadUserId(getUser().getId());
			info.setFileType(Long.parseLong(id));
			JSONResult result = new JSONResult();
			boolean a = fileUploadService.addExcelInfo(info,infoList);
			result.setSuccess(a);
			response.getWriter().print(JSONObject.fromObject(result));
		}catch (Exception e) {
			JSONResult result = new JSONResult();
			result.setSuccess(false);
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * excel -- 吊牌1
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/excel-upload-diaopai1", method = RequestMethod.POST)
	public @ResponseBody JSONResult excelUpload1(@RequestParam(value = "file") MultipartFile file) {
		try {	
				String oriFilename = file.getOriginalFilename();
				String fileExt = FilenameUtils.getExtension(oriFilename).toLowerCase();
				String saveUrl = fileUploadPath  + new SimpleDateFormat("/yyyy/MM/dd/").format(new Date()) + DateUtils.formatDate(Calendar.getInstance().getTime(), "yyyyMMddHHmmSS/") + GUIDUtil.generateRandon(8)+"."+fileExt;;
				// 如果文件夹不存在则创建
	            File pathfile = new File(saveUrl);
	            File path = pathfile.getParentFile();
	            if (!path.exists()) {
	            	path.mkdirs();
	            }
				File srcFile = new File(saveUrl);
				FileUtils.copyInputStreamToFile(file.getInputStream(), srcFile);
				Workbook wb0; 
				if("xls".equals(fileExt)){
					POIFSFileSystem poifsFileSystem = new POIFSFileSystem(file.getInputStream());
					wb0 = new HSSFWorkbook(poifsFileSystem);//2003
	            }else if("xlsx".equals(fileExt)){
	            	wb0 = new XSSFWorkbook(file.getInputStream());//2007
	            }else{
	            	wb0 = null;
	            	JSONResult.error("不支持的文件类型: " + fileExt);
					throw new RuntimeException("the file is too small, transfer failed.");       
	            }

				
				 // 获取选项卡对象 第0个选项卡  
				Sheet sht0 = wb0.getSheetAt(0);  
				Row row0 = sht0.getRow(0);
				// 标题总列数
		        int colNum = row0.getPhysicalNumberOfCells();
		        for (int i = 0; i < colNum; i++) {
		            //修改单元格的数据格式，获取表头信息
		            row0.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
		        //    title[i] = row0.getCell(i).getStringCellValue();
		        }
		        DecimalFormat df = new DecimalFormat("0");
		        
		        int rowNum = sht0.getLastRowNum();//总行数
		        rowNum = RowNumUtil.getRowNum(sht0);
		        List<TagInfo> infoList = new ArrayList<>();
		        for (int i = 1; i <= rowNum; i++) {
		        	for(int j=0;j<=10;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	if(sht0.getRow(i)!=null) {
			        	//创建实体类
						TagInfo info=new TagInfo();
						info.setCustomerName(String.valueOf(sht0.getRow(i).getCell(0)));//公司名称
						info.setItemNo(String.valueOf(sht0.getRow(i).getCell(1)));//款号 Item No
						info.setSmlpc(String.valueOf(sht0.getRow(i).getCell(2)));// SMLPC
						info.setColour(String.valueOf(sht0.getRow(i).getCell(3)));//颜色
						info.setSize(sht0.getRow(i).getCell(4)+"");//Size
						info.setCurrency(String.valueOf(sht0.getRow(i).getCell(5)));//币种
						info.setUnitPrice(sht0.getRow(i).getCell(6)+"");//Unit Price
						info.setSetPrice(String.valueOf(sht0.getRow(i).getCell(7)));//SET PRICE
						info.setOrderQty(String.valueOf(sht0.getRow(i).getCell(8)));//order qty
						info.setBarCode(String.valueOf(sht0.getRow(i).getCell(9)));//Barcode#
						info.setDescription(String.valueOf(sht0.getRow(i).getCell(10)));//Description
						info.setItemColorCurrency(String.valueOf(sht0.getRow(i).getCell(1)) + String.valueOf(sht0.getRow(i).getCell(3)) + String.valueOf(sht0.getRow(i).getCell(5)));
						infoList.add(info);
		        	}
		        }
		        
		        List<List<TagInfo>> infoListList = new ArrayList<>();
		        
		        // 根据同款同色同币种去重
	            Set<TagInfo> personSet = new TreeSet<>((o1, o2) -> o1.getItemColorCurrency().compareTo(o2.getItemColorCurrency()) );
	            personSet.addAll(infoList);

	            List<TagInfo> a =  new ArrayList<>(personSet);
	            
	            for(int i=0;i<a.size();i++) {//把同款同色同币种的进行分类
	            	List<TagInfo> infoList1 = new ArrayList<>();
	            	for(int j=0;j<infoList.size();j++) {
	            		if(a.get(i).getItemColorCurrency().equals(infoList.get(j).getItemColorCurrency())) {//比较同款同色同币种 相同的放在一起
	            			infoList1.add(infoList.get(j));
	            		}
	            	}
	            	infoListList.add(infoList1);
	            }
	            
            	List<List<List<TagInfo>>> infoListList3 = new ArrayList<>();
	            
	            for(int i=0;i<infoListList.size();i++) {//第一层  不同的款色币种
	            	Integer row = Integer.parseInt(df.format(Math.ceil(infoListList.get(i).size()/3.00)));//判断它有几行
	            	List<List<TagInfo>> infoListListRow = new ArrayList<>();
	            		for(int j=0;j<row;j++) {//第二层  每个款色币种下面的数据有几行
	            			List<TagInfo> infoListK = new ArrayList<>();//每五个放在一起
	            			for(int k=0;k<3;k++) {//第三层  把数据放进去  每五个一换行
	            				if((j*3+k) == infoListList.get(i).size()) {
	    							break;
	    						}
	            				infoListK.add(infoListList.get(i).get(j*3+k));
		            		}
	            			infoListListRow.add(infoListK);
	            		}
	            	infoListList3.add(infoListListRow);
	            }
		        
		        JSONResult jsonResult = new JSONResult();
		        jsonResult.setObj(infoListList3);
		        HashMap<String, Object> fileObject = new HashMap<>();
		        fileObject.put("fileName", oriFilename);
		        fileObject.put("fileUrl", saveUrl);
		        jsonResult.setObjects(fileObject);
		        jsonResult.setSuccess(true);
		        return jsonResult;
		        
		} catch (Exception e) {
			log.error("Transfer file fail :", e);
		}

		return JSONResult.error("文件读取失败！请上传规定格式文件！");
	}

	
	/**
	 * excel -- 吊牌2
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/excel-upload-diaopai2", method = RequestMethod.POST)
	public @ResponseBody JSONResult excelUpload2(@RequestParam(value = "file") MultipartFile file) {
		try {
				String oriFilename = file.getOriginalFilename();
				String fileExt = FilenameUtils.getExtension(oriFilename).toLowerCase();
				String saveUrl = fileUploadPath  + new SimpleDateFormat("/yyyy/MM/dd/").format(new Date()) + DateUtils.formatDate(Calendar.getInstance().getTime(), "yyyyMMddHHmmSS/") + GUIDUtil.generateRandon(8)+"."+fileExt;;
				// 如果文件夹不存在则创建
	            File pathfile = new File(saveUrl);
	            File path = pathfile.getParentFile();
	            if (!path.exists()) {
	            	path.mkdirs();
	            }
				File srcFile = new File(saveUrl);
				FileUtils.copyInputStreamToFile(file.getInputStream(), srcFile);
				Workbook wb0; 
				if("xls".equals(fileExt)){
					POIFSFileSystem poifsFileSystem = new POIFSFileSystem(file.getInputStream());
					wb0 = new HSSFWorkbook(poifsFileSystem);//2003
	            }else if("xlsx".equals(fileExt)){
	            	wb0 = new XSSFWorkbook(file.getInputStream());//2007
	            }else{
	            	wb0 = null;
	            	JSONResult.error("不支持的文件类型: " + fileExt);
					throw new RuntimeException("the file is too small, transfer failed.");       
	            }

				
				 // 获取选项卡对象 第0个选项卡  
				Sheet sht0 = wb0.getSheetAt(0);  
				Row row0 = sht0.getRow(0);
				// 标题总列数
		        int colNum = row0.getPhysicalNumberOfCells();
		        for (int i = 0; i < colNum; i++) {
		            //修改单元格的数据格式，获取表头信息
		            row0.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
		        //    title[i] = row0.getCell(i).getStringCellValue();
		        }
		        DecimalFormat df = new DecimalFormat("0");
		        
		        int rowNum = sht0.getLastRowNum();//总行数
		        rowNum = RowNumUtil.getRowNum(sht0);
		        List<TagInfo> infoList = new ArrayList<>();
		        for (int i = 1; i <= rowNum; i++) {
		        	for(int j=0;j<=9;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
				        	sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
				        }  
		        	}
		        	if(sht0.getRow(i)!=null) {
		        		//创建实体类
						TagInfo info=new TagInfo();
						info.setCustomerName(String.valueOf(sht0.getRow(i).getCell(0)));//公司名称
						info.setItemNo(String.valueOf(sht0.getRow(i).getCell(1)));//款号 Item No
						info.setSmlpc(String.valueOf(sht0.getRow(i).getCell(2)));// SMLPC
						info.setColour(String.valueOf(sht0.getRow(i).getCell(3)));//颜色
						info.setSize(sht0.getRow(i).getCell(4)+"");//Size
						info.setCurrency(String.valueOf(sht0.getRow(i).getCell(5)));//币种
						info.setUnitPrice(sht0.getRow(i).getCell(6)+"");//Unit Price
						//info.setSetPrice(sht0.getRow(i).getCell(7)+"");//set Price
						info.setOrderQty(String.valueOf(sht0.getRow(i).getCell(7)));//order qty
						info.setBarCode(String.valueOf(sht0.getRow(i).getCell(8)));//Barcode#
						info.setDescription(String.valueOf(sht0.getRow(i).getCell(9)));//Description
						info.setItemColorCurrency(String.valueOf(sht0.getRow(i).getCell(1)) + String.valueOf(sht0.getRow(i).getCell(3)) + String.valueOf(sht0.getRow(i).getCell(5)));
						
						infoList.add(info);
		        	}
		        	
		        }
		        
		        List<List<TagInfo>> infoListList = new ArrayList<>();
		        
		        // 根据同款同色同币种去重
	            Set<TagInfo> personSet = new TreeSet<>((o1, o2) -> o1.getItemColorCurrency().compareTo(o2.getItemColorCurrency()) );
	            personSet.addAll(infoList);

	            List<TagInfo> a =  new ArrayList<>(personSet);
	            
	            for(int i=0;i<a.size();i++) {//把同款同色同币种的进行分类
	            	List<TagInfo> infoList1 = new ArrayList<>();
	            	for(int j=0;j<infoList.size();j++) {
	            		if(a.get(i).getItemColorCurrency().equals(infoList.get(j).getItemColorCurrency())) {//比较同款同色同币种 相同的放在一起
	            			infoList1.add(infoList.get(j));
	            		}
	            	}
	            	infoListList.add(infoList1);
	            }
	            
            	List<List<List<TagInfo>>> infoListList3 = new ArrayList<>();
	            
	            for(int i=0;i<infoListList.size();i++) {//第一层  不同的款色币种
	            	Integer row = Integer.parseInt(df.format(Math.ceil(infoListList.get(i).size()/3.00)));//判断它有几行
	            	List<List<TagInfo>> infoListListRow = new ArrayList<>();
	            		for(int j=0;j<row;j++) {//第二层  每个款色币种下面的数据有几行
	            			List<TagInfo> infoListK = new ArrayList<>();//每五个放在一起
	            			for(int k=0;k<3;k++) {//第三层  把数据放进去  每五个一换行
	            				if((j*3+k) == infoListList.get(i).size()) {
	    							break;
	    						}
	            				infoListK.add(infoListList.get(i).get(j*3+k));
		            		}
	            			infoListListRow.add(infoListK);
	            		}
	            	infoListList3.add(infoListListRow);
	            }
		       
		        
		        JSONResult jsonResult = new JSONResult();
		        jsonResult.setObj(infoListList3);
		        HashMap<String, Object> fileObject = new HashMap<>();
		        fileObject.put("fileName", oriFilename);
		        fileObject.put("fileUrl", saveUrl);
		        jsonResult.setObjects(fileObject);
		        jsonResult.setSuccess(true);
		        return jsonResult;
		        

		} catch (Exception e) {
			log.error("Transfer file fail :", e);
		}

		return JSONResult.error("文件读取失败！请上传规定格式文件！");
	}
	

	/**
	 * excel -- 合格证1
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/excel-upload-hegezheng1", method = RequestMethod.POST)
	public @ResponseBody JSONResult excelUploadHeGeZheng(@RequestParam(value = "file") MultipartFile file) {
		try {	
				String oriFilename = file.getOriginalFilename();
				String fileExt = FilenameUtils.getExtension(oriFilename).toLowerCase();
				String saveUrl = fileUploadPath  + new SimpleDateFormat("/yyyy/MM/dd/").format(new Date()) + DateUtils.formatDate(Calendar.getInstance().getTime(), "yyyyMMddHHmmSS/") + GUIDUtil.generateRandon(8)+"."+fileExt;;
				// 如果文件夹不存在则创建
	            File pathfile = new File(saveUrl);
	            File path = pathfile.getParentFile();
	            if (!path.exists()) {
	            	path.mkdirs();
	            }
				File srcFile = new File(saveUrl);
				FileUtils.copyInputStreamToFile(file.getInputStream(), srcFile);
				
				Workbook wb0; 
				if("xls".equals(fileExt)){
					POIFSFileSystem poifsFileSystem = new POIFSFileSystem(file.getInputStream());
					wb0 = new HSSFWorkbook(poifsFileSystem);//2003
	            }else if("xlsx".equals(fileExt)){
	            	wb0 = new XSSFWorkbook(file.getInputStream());//2007
	            }else{
	            	wb0 = null;
	            	JSONResult.error("不支持的文件类型: " + fileExt);
					throw new RuntimeException("the file is too small, transfer failed.");       
	            }
				
				 // 获取选项卡对象 第0个选项卡  
				Sheet sht0 = wb0.getSheetAt(0);  

		        DecimalFormat df = new DecimalFormat("0");
		        
		        int rowNum = sht0.getLastRowNum();//总行数
		        rowNum = RowNumUtil.getRowNum(sht0);
		        List<Certificate> infoList = new ArrayList<>();

		        for (int i = 1; i <= rowNum; i++) {
		        	for(int j=0;j<=11;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	for(int j=13;j<=44;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	//创建实体类
		        	Certificate info=new Certificate();
		        	if(sht0.getRow(i)!=null) {
		        		info.setCustomerName(sht0.getRow(i).getCell(0)+"");// 公司名称
			        	info.setSmlpc(sht0.getRow(i).getCell(1)+"");// smplc
			        			        	
			        	info.setItemNo(sht0.getRow(i).getCell(2)+"");// 货品编号 
			        	
			        	info.setOrderQty(sht0.getRow(i).getCell(3)+"");// order qty 数量
			        	
			        	info.setProductName(sht0.getRow(i).getCell(4)+"");//产品名称
			        	info.setType(sht0.getRow(i).getCell(5)+"");//号型
			        	//info.setArtNo(sht0.getRow(i).getCell(6)+"");//货号
			        	info.setInternalCode(sht0.getRow(i).getCell(6)+"");//内部码
			        	info.setGrade(sht0.getRow(i).getCell(7)+"");//等级
			        	info.setProductStandard(sht0.getRow(i).getCell(8)+"");//产品标准
			        	info.setSecurityCategory(sht0.getRow(i).getCell(9)+"");//安全级别
			        	info.setCategory(sht0.getRow(i).getCell(10)+"");//安全级别类别
			        	info.setColour(sht0.getRow(i).getCell(11)+"");//颜色
			        	//info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	
			        	Cell riQiCell = sht0.getRow(i).getCell(12);
			        	if(riQiCell != null) {
			        		String haha = parseExcel(riQiCell);
				        	info.setDateOfManufacture(haha);//生产日期
			        		
			        	}else {
			        		info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	}
			        	
			        	List<Fabric> fabricList = new ArrayList<>();
			        	for(int j=0;j<8;j++) {//总共有8列面料信息
			        		int a = 13 + j*3;
			        		int b = 14 + j*3;
			        		int c = 15 + j*3; 
			        		String name = sht0.getRow(i).getCell(a)+"";
				        	String mianliao = sht0.getRow(i).getCell(b)+"";
				        	String beizhu = sht0.getRow(i).getCell(c)+"";
				        	if((mianliao != null && !mianliao.equals("null") && !mianliao.equals(""))) {
					        	Fabric fc = new Fabric();
				        		fc.setName(name);
				        		
				        		List<List<String>> mianListList = new ArrayList<>();//每五个放在一起
				        		String[] mianliaoList = mianliao.split("/");
				        		Integer row = Integer.parseInt(df.format(Math.ceil(mianliaoList.length/3.00)));//判断它有几行
				        		for(int k=0;k<row;k++) {//第二层  每个款色币种下面的数据有几行
			            			List<String> mian = new ArrayList<>();//每五个放在一起
			            			for(int h=0;h<3;h++) {//第三层  把数据放进去  每五个一换行
			            				if((k*3+h) == mianliaoList.length) {
			    							break;
			    						}
			            				
			            				mian.add(mianliaoList[k*3+h]);
				            		}
			            			mianListList.add(mian);
			            		}
				        		
				        		fc.setComponent(mianListList);
				        		fc.setRemarks(beizhu);
				        		/**---------括号为标识分割备注信息start------------**/
				        		String beizhu1 = "";
				        		for(int k=0;k<beizhu.length();k++) {
				        			String r = beizhu.substring(k,k+1);
				        			if(r.equals("（")) {
				        				beizhu1 = beizhu1 + "(";
				        			}else if(r.equals("）")){
				        				beizhu1 = beizhu1 + ")";
				        			}else{
				        				beizhu1 = beizhu1 + r;
				        			}
				        		}
				        		String[] remarksS = beizhu1.split("\\)");
				        		List<String> remarksList = new ArrayList<>();
				        		for(int k=0;k<remarksS.length;k++) {
				        			remarksList.add(remarksS[k]+")");
				        		}
				        		fc.setRemarksList(remarksList);
				        		/**----------------括号为标识分割备注信息end----------------**/
				        		fabricList.add(fc);
				        	}
			        	}
			        	info.setFabricList(fabricList);//(面料/备注)集合
			        	info.setInspector(sht0.getRow(i).getCell(37)+"");//检测员
			        	info.setPlaceOfOrigin(sht0.getRow(i).getCell(38)+"");//产地
			        	info.setDistributor(sht0.getRow(i).getCell(39)+"");//经销商
			        	info.setLocation(sht0.getRow(i).getCell(40)+"");//地址
			        	info.setLocationInfo(sht0.getRow(i).getCell(41)+"");//详情地址
			        	info.setPhone(sht0.getRow(i).getCell(42)+"");//电话
				        info.setPostalCode(sht0.getRow(i).getCell(43)+"");//邮政编码
			        	info.setWashingInstructions(sht0.getRow(i).getCell(44)+"");//洗涤说明
			        	
						info.setItemNoColour(sht0.getRow(i).getCell(2)+"" + sht0.getRow(i).getCell(11)+"");//同款同色
						
						
						infoList.add(info);
		        	}
		        	
		        }
		        
		        List<List<Certificate>> infoListList = new ArrayList<>();
		        
		        // 根据同款同色同币种去重
	            Set<Certificate> personSet = new TreeSet<>((o1, o2) -> o1.getItemNoColour().compareTo(o2.getItemNoColour()) );
	            personSet.addAll(infoList);

	            List<Certificate> a =  new ArrayList<>(personSet);
	            
	            for(int i=0;i<a.size();i++) {//把同款同色同币种的进行分类
	            	List<Certificate> infoList1 = new ArrayList<>();
	            	for(int j=0;j<infoList.size();j++) {
	            		if(a.get(i).getItemNoColour().equals(infoList.get(j).getItemNoColour())) {//比较同款同色同币种 相同的放在一起
	            			infoList1.add(infoList.get(j));
	            		}
	            	}
	            	infoListList.add(infoList1);
	            }
	            
            	List<List<List<Certificate>>> infoListList3 = new ArrayList<>();
	            
	            for(int i=0;i<infoListList.size();i++) {//第一层  不同的款色币种
	            	Integer row = Integer.parseInt(df.format(Math.ceil(infoListList.get(i).size()/3.00)));//判断它有几行
	            	List<List<Certificate>> infoListListRow = new ArrayList<>();
	            		for(int j=0;j<row;j++) {//第二层  每个款色币种下面的数据有几行
	            			List<Certificate> infoListK = new ArrayList<>();//每五个放在一起
	            			for(int k=0;k<3;k++) {//第三层  把数据放进去  每五个一换行
	            				if((j*3+k) == infoListList.get(i).size()) {
	    							break;
	    						}
	            				infoListK.add(infoListList.get(i).get(j*3+k));
		            		}
	            			infoListListRow.add(infoListK);
	            		}
	            	infoListList3.add(infoListListRow);
	            }	            		       
		        
		        JSONResult jsonResult = new JSONResult();
		        jsonResult.setObj(infoListList3);
		        HashMap<String, Object> fileObject = new HashMap<>();
		        fileObject.put("fileName", oriFilename);
		        fileObject.put("fileUrl", saveUrl);
		        jsonResult.setObjects(fileObject);
		        jsonResult.setSuccess(true);
		        return jsonResult;
		        
		} catch (Exception e) {
			log.error("Transfer file fail :", e);
		}

		return JSONResult.error("文件读取失败！请上传规定格式文件！");
	}
	

	
	/**
	 * excel -- 合格证2
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/excel-upload-hegezheng2", method = RequestMethod.POST)
	public @ResponseBody JSONResult excelUploadHeGeZheng2(@RequestParam(value = "file") MultipartFile file) {
		try {	
				String oriFilename = file.getOriginalFilename();
				String fileExt = FilenameUtils.getExtension(oriFilename).toLowerCase();
				String saveUrl = fileUploadPath  + new SimpleDateFormat("/yyyy/MM/dd/").format(new Date()) + DateUtils.formatDate(Calendar.getInstance().getTime(), "yyyyMMddHHmmSS/") + GUIDUtil.generateRandon(8)+"."+fileExt;;
				// 如果文件夹不存在则创建
	            File pathfile = new File(saveUrl);
	            File path = pathfile.getParentFile();
	            if (!path.exists()) {
	            	path.mkdirs();
	            }	
				File srcFile = new File(saveUrl);
				FileUtils.copyInputStreamToFile(file.getInputStream(), srcFile);
				System.out.println(pathfile.getAbsolutePath());
				
				Workbook wb0; 
				if("xls".equals(fileExt)){
					POIFSFileSystem poifsFileSystem = new POIFSFileSystem(file.getInputStream());
					wb0 = new HSSFWorkbook(poifsFileSystem);//2003
	            }else if("xlsx".equals(fileExt)){
	            	wb0 = new XSSFWorkbook(file.getInputStream());//2007
	            }else{
	            	wb0 = null;
	            	JSONResult.error("不支持的文件类型: " + fileExt);
					throw new RuntimeException("the file is too small, transfer failed.");       
	            }

				
				 // 获取选项卡对象 第0个选项卡  
				Sheet sht0 = wb0.getSheetAt(0);  

		        DecimalFormat df = new DecimalFormat("0");
		        
		        int rowNum = sht0.getLastRowNum();//总行数
		        rowNum = RowNumUtil.getRowNum(sht0);
		        List<Certificate> infoList = new ArrayList<>();

		        for (int i = 1; i <= rowNum; i++) {
		        	for(int j=0;j<=11;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	for(int j=13;j<=44;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	//创建实体类
		        	if(sht0.getRow(i)!=null) {
		        		Certificate info=new Certificate();
			        	info.setCustomerName(sht0.getRow(i).getCell(0)+"");// 公司名称
			        	info.setSmlpc(sht0.getRow(i).getCell(1)+"");// smplc
			        			        	
			        	info.setItemNo(sht0.getRow(i).getCell(2)+"");// 货品编号 
			        	
			        	info.setOrderQty(sht0.getRow(i).getCell(3)+"");// order qty 数量
			        	
			        	info.setProductName(sht0.getRow(i).getCell(4)+"");//产品名称
			        	info.setType(sht0.getRow(i).getCell(5)+"");//号型
			        	//info.setArtNo(sht0.getRow(i).getCell(6)+"");//货号
			        	info.setInternalCode(sht0.getRow(i).getCell(6)+"");//内部码
			        	info.setGrade(sht0.getRow(i).getCell(7)+"");//等级
			        	info.setProductStandard(sht0.getRow(i).getCell(8)+"");//产品标准
			        	info.setSecurityCategory(sht0.getRow(i).getCell(9)+"");//安全级别
			        	info.setCategory(sht0.getRow(i).getCell(10)+"");//安全级别类别
			        	info.setColour(sht0.getRow(i).getCell(11)+"");//颜色
			        	//info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	
			        	Cell riQiCell = sht0.getRow(i).getCell(12);
			        	if(riQiCell != null) {
			        		String haha = parseExcel(riQiCell);
				        	info.setDateOfManufacture(haha);//生产日期
			        		
			        	}else {
			        		info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	}
			        	
			        	List<Fabric> fabricList = new ArrayList<>();
			        	for(int j=0;j<8;j++) {//总共有8列面料信息
			        		int a = 13 + j*3;
			        		int b = 14 + j*3;
			        		int c = 15 + j*3; 
			        		String name = sht0.getRow(i).getCell(a)+"";
				        	String mianliao = sht0.getRow(i).getCell(b)+"";
				        	String beizhu = sht0.getRow(i).getCell(c)+"";
				        	if((mianliao != null && !mianliao.equals("null") && !mianliao.equals(""))) {
					        	Fabric fc = new Fabric();
				        		fc.setName(name);
				        		
				        		List<List<String>> mianListList = new ArrayList<>();//每五个放在一起
				        		String[] mianliaoList = mianliao.split("/");
				        		Integer row = Integer.parseInt(df.format(Math.ceil(mianliaoList.length/3.00)));//判断它有几行
				        		for(int k=0;k<row;k++) {//第二层  每个款色币种下面的数据有几行
			            			List<String> mian = new ArrayList<>();//每五个放在一起
			            			for(int h=0;h<3;h++) {//第三层  把数据放进去  每五个一换行
			            				if((k*3+h) == mianliaoList.length) {
			    							break;
			    						}
			            				
			            				mian.add(mianliaoList[k*3+h]);
				            		}
			            			mianListList.add(mian);
			            		}
				        		
				        		fc.setComponent(mianListList);
				        		fc.setRemarks(beizhu);
				        		/**---------括号为标识分割备注信息start------------**/
				        		String beizhu1 = "";
				        		for(int k=0;k<beizhu.length();k++) {
				        			String r = beizhu.substring(k,k+1);
				        			if(r.equals("（")) {
				        				beizhu1 = beizhu1 + "(";
				        			}else if(r.equals("）")){
				        				beizhu1 = beizhu1 + ")";
				        			}else{
				        				beizhu1 = beizhu1 + r;
				        			}
				        		}
				        		String[] remarksS = beizhu1.split("\\)");
				        		List<String> remarksList = new ArrayList<>();
				        		for(int k=0;k<remarksS.length;k++) {
				        			remarksList.add(remarksS[k]+")");
				        		}
				        		fc.setRemarksList(remarksList);
				        		/**----------------括号为标识分割备注信息end----------------**/
				        		fabricList.add(fc);
				        	}
			        	}
			        	info.setFabricList(fabricList);//(面料/备注)集合
			        	info.setInspector(sht0.getRow(i).getCell(37)+"");//检测员
			        	info.setPlaceOfOrigin(sht0.getRow(i).getCell(38)+"");//产地
			        	info.setDistributor(sht0.getRow(i).getCell(39)+"");//经销商
			        	info.setLocation(sht0.getRow(i).getCell(40)+"");//地址
			        	info.setLocationInfo(sht0.getRow(i).getCell(41)+"");//详情地址
			        	info.setPhone(sht0.getRow(i).getCell(42)+"");//电话
				        info.setPostalCode(sht0.getRow(i).getCell(43)+"");//邮政编码
			        	info.setWashingInstructions(sht0.getRow(i).getCell(44)+"");//洗涤说明
			        	
						info.setItemNoColour(sht0.getRow(i).getCell(2)+"" + sht0.getRow(i).getCell(11)+"");//同款同色
						
						
						infoList.add(info);
		        	}
		        	
		        }
		        
		        List<List<Certificate>> infoListList = new ArrayList<>();
		        
		        // 根据同款同色同币种去重
	            Set<Certificate> personSet = new TreeSet<>((o1, o2) -> o1.getItemNoColour().compareTo(o2.getItemNoColour()) );
	            personSet.addAll(infoList);

	            List<Certificate> a =  new ArrayList<>(personSet);
	            
	            for(int i=0;i<a.size();i++) {//把同款同色同币种的进行分类
	            	List<Certificate> infoList1 = new ArrayList<>();
	            	for(int j=0;j<infoList.size();j++) {
	            		if(a.get(i).getItemNoColour().equals(infoList.get(j).getItemNoColour())) {//比较同款同色同币种 相同的放在一起
	            			infoList1.add(infoList.get(j));
	            		}
	            	}
	            	infoListList.add(infoList1);
	            }
	            
            	List<List<List<Certificate>>> infoListList3 = new ArrayList<>();
	            
	            for(int i=0;i<infoListList.size();i++) {//第一层  不同的款色币种
	            	Integer row = Integer.parseInt(df.format(Math.ceil(infoListList.get(i).size()/3.00)));//判断它有几行
	            	List<List<Certificate>> infoListListRow = new ArrayList<>();
	            		for(int j=0;j<row;j++) {//第二层  每个款色币种下面的数据有几行
	            			List<Certificate> infoListK = new ArrayList<>();//每五个放在一起
	            			for(int k=0;k<3;k++) {//第三层  把数据放进去  每五个一换行
	            				if((j*3+k) == infoListList.get(i).size()) {
	    							break;
	    						}
	            				infoListK.add(infoListList.get(i).get(j*3+k));
		            		}
	            			infoListListRow.add(infoListK);
	            		}
	            	infoListList3.add(infoListListRow);
	            }
		        
		        JSONResult jsonResult = new JSONResult();
		        jsonResult.setObj(infoListList3);
		        HashMap<String, Object> fileObject = new HashMap<>();
		        fileObject.put("fileName", oriFilename);
		        fileObject.put("fileUrl", saveUrl);
		        jsonResult.setObjects(fileObject);
		        jsonResult.setSuccess(true);
		        return jsonResult;
		        
		} catch (Exception e) {
			log.error("Transfer file fail :", e);
		}

		return JSONResult.error("文件读取失败！请上传规定格式文件！");
	}
	
	
	
	/**
	 * excel -- fall合格证  大版
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/excel-upload-hegezheng-fall-da", method = RequestMethod.POST)
	public @ResponseBody JSONResult excelUploadHeGeZhengFallBig(@RequestParam(value = "file") MultipartFile file) {
		try {	
				String oriFilename = file.getOriginalFilename();
				String fileExt = FilenameUtils.getExtension(oriFilename).toLowerCase();
				String saveUrl = fileUploadPath  + new SimpleDateFormat("/yyyy/MM/dd/").format(new Date()) + DateUtils.formatDate(Calendar.getInstance().getTime(), "yyyyMMddHHmmSS/") + GUIDUtil.generateRandon(8)+"."+fileExt;;
				// 如果文件夹不存在则创建
	            File pathfile = new File(saveUrl);
	            File path = pathfile.getParentFile();
	            if (!path.exists()) {
	            	path.mkdirs();
	            }
				File srcFile = new File(saveUrl);
				FileUtils.copyInputStreamToFile(file.getInputStream(), srcFile);
				
				Workbook wb0; 
				if("xls".equals(fileExt)){
					POIFSFileSystem poifsFileSystem = new POIFSFileSystem(file.getInputStream());
					wb0 = new HSSFWorkbook(poifsFileSystem);//2003
	            }else if("xlsx".equals(fileExt)){
	            	wb0 = new XSSFWorkbook(file.getInputStream());//2007
	            }else{
	            	wb0 = null;
	            	JSONResult.error("不支持的文件类型: " + fileExt);
					throw new RuntimeException("the file is too small, transfer failed.");       
	            }
				
				 // 获取选项卡对象 第0个选项卡  
				Sheet sht0 = wb0.getSheetAt(0);  

		        DecimalFormat df = new DecimalFormat("0");
		        
		        int rowNum = sht0.getLastRowNum();//总行数
		        
		        
		        rowNum = RowNumUtil.getRowNum(sht0);

		        
		        List<Certificate> infoList = new ArrayList<>();

		        for (int i = 1; i <= rowNum; i++) {
		        	for(int j=0;j<=11;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	for(int j=13;j<=21;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	//创建实体类
		        	Certificate info=new Certificate();
		        	if(sht0.getRow(i)!=null) {
		        		info.setCustomerName(sht0.getRow(i).getCell(0)+"");// 公司名称
			        	info.setSmlpc(sht0.getRow(i).getCell(1)+"");// smplc
			        			        	
			        	info.setItemNo(sht0.getRow(i).getCell(2)+"");// 货品编号 
			        	
			        	info.setOrderQty(sht0.getRow(i).getCell(3)+"");// order qty 数量
			        	
			        	info.setProductName(sht0.getRow(i).getCell(4)+"");//产品名称
			        	info.setType(sht0.getRow(i).getCell(5)+"");//号型
			        	info.setInternalCode(sht0.getRow(i).getCell(6)+"");//内部码
			        	info.setGrade(sht0.getRow(i).getCell(7)+"");//等级
			        	info.setProductStandard(sht0.getRow(i).getCell(8)+"");//产品标准
			        	info.setSecurityCategory(sht0.getRow(i).getCell(9)+"");//安全级别
			        	info.setCategory(sht0.getRow(i).getCell(10)+"");//安全级别类别
			        	info.setColour(sht0.getRow(i).getCell(11)+"");//颜色
			        	info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	
			            
			        	Cell riQiCell = sht0.getRow(i).getCell(12);
			        	if(riQiCell != null) {
			        		String haha = parseExcel(riQiCell);
				        	info.setDateOfManufacture(haha);//生产日期
			        		
			        	}else {
			        		info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	}
			        	
			        	info.setFabricString(sht0.getRow(i).getCell(13)+"");//面料
			        	
			        	info.setInspector(sht0.getRow(i).getCell(14)+"");//检测员
			        	info.setPlaceOfOrigin(sht0.getRow(i).getCell(15)+"");//产地
			        	info.setDistributor(sht0.getRow(i).getCell(16)+"");//经销商
			        	info.setLocation(sht0.getRow(i).getCell(17)+"");//地址
			        	info.setLocationInfo(sht0.getRow(i).getCell(18)+"");//详情地址
			        	info.setPhone(sht0.getRow(i).getCell(19)+"");//电话
				        info.setPostalCode(sht0.getRow(i).getCell(20)+"");//邮政编码
			        	info.setWashingInstructions(sht0.getRow(i).getCell(21)+"");//洗涤说明
			        	
						info.setItemNoColour(sht0.getRow(i).getCell(2)+"" + sht0.getRow(i).getCell(11)+"");//同款同色
						
						
						infoList.add(info);
		        	}
		        	
		        }
		        
		        List<List<Certificate>> infoListList = new ArrayList<>();
		        
		        // 根据同款同色同币种去重
	            Set<Certificate> personSet = new TreeSet<>((o1, o2) -> o1.getItemNoColour().compareTo(o2.getItemNoColour()) );
	            personSet.addAll(infoList);

	            List<Certificate> a =  new ArrayList<>(personSet);
	            
	            for(int i=0;i<a.size();i++) {//把同款同色同币种的进行分类
	            	List<Certificate> infoList1 = new ArrayList<>();
	            	for(int j=0;j<infoList.size();j++) {
	            		if(a.get(i).getItemNoColour().equals(infoList.get(j).getItemNoColour())) {//比较同款同色同币种 相同的放在一起
	            			infoList1.add(infoList.get(j));
	            		}
	            	}
	            	infoListList.add(infoList1);
	            }
	            
            	List<List<List<Certificate>>> infoListList3 = new ArrayList<>();
	            
	            for(int i=0;i<infoListList.size();i++) {//第一层  不同的款色币种
	            	Integer row = Integer.parseInt(df.format(Math.ceil(infoListList.get(i).size()/3.00)));//判断它有几行
	            	List<List<Certificate>> infoListListRow = new ArrayList<>();
	            		for(int j=0;j<row;j++) {//第二层  每个款色币种下面的数据有几行
	            			List<Certificate> infoListK = new ArrayList<>();//每五个放在一起
	            			for(int k=0;k<3;k++) {//第三层  把数据放进去  每五个一换行
	            				if((j*3+k) == infoListList.get(i).size()) {
	    							break;
	    						}
	            				infoListK.add(infoListList.get(i).get(j*3+k));
		            		}
	            			infoListListRow.add(infoListK);
	            		}
	            	infoListList3.add(infoListListRow);
	            }	            		       
		        
		        JSONResult jsonResult = new JSONResult();
		        jsonResult.setObj(infoListList3);
		        HashMap<String, Object> fileObject = new HashMap<>();
		        fileObject.put("fileName", oriFilename);
		        fileObject.put("fileUrl", saveUrl);
		        jsonResult.setObjects(fileObject);
		        jsonResult.setSuccess(true);
		        return jsonResult;
		        
		} catch (Exception e) {
			log.error("Transfer file fail :", e);
		}

		return JSONResult.error("文件读取失败！请上传规定格式文件！");
	}
	
	
	
	/**
	 * excel -- fall合格证  小版
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/excel-upload-hegezheng-fall-xiao", method = RequestMethod.POST)
	public @ResponseBody JSONResult excelUploadHeGeZhengFallSmall(@RequestParam(value = "file") MultipartFile file) {
		try {		
				String oriFilename = file.getOriginalFilename();
				String fileExt = FilenameUtils.getExtension(oriFilename).toLowerCase();
				String saveUrl = fileUploadPath  + new SimpleDateFormat("/yyyy/MM/dd/").format(new Date()) + DateUtils.formatDate(Calendar.getInstance().getTime(), "yyyyMMddHHmmSS/") + GUIDUtil.generateRandon(8)+"."+fileExt;;
				// 如果文件夹不存在则创建
	            File pathfile = new File(saveUrl);
	            File path = pathfile.getParentFile();
	            if (!path.exists()) {
	            	path.mkdirs();
	            }
				File srcFile = new File(saveUrl);
				FileUtils.copyInputStreamToFile(file.getInputStream(), srcFile);
				
				Workbook wb0; 
				if("xls".equals(fileExt)){
					POIFSFileSystem poifsFileSystem = new POIFSFileSystem(file.getInputStream());
					wb0 = new HSSFWorkbook(poifsFileSystem);//2003
	            }else if("xlsx".equals(fileExt)){
	            	wb0 = new XSSFWorkbook(file.getInputStream());//2007
	            }else{
	            	wb0 = null;
	            	JSONResult.error("不支持的文件类型: " + fileExt);
					throw new RuntimeException("the file is too small, transfer failed.");       
	            }
				
				 // 获取选项卡对象 第0个选项卡  
				Sheet sht0 = wb0.getSheetAt(0);  

		        DecimalFormat df = new DecimalFormat("0");
		        
		        int rowNum = sht0.getLastRowNum();//总行数
		        rowNum = RowNumUtil.getRowNum(sht0);
		        List<Certificate> infoList = new ArrayList<>();

		        for (int i = 1; i <= rowNum; i++) {
		        	for(int j=0;j<=11;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	for(int j=13;j<=21;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	//创建实体类
		        	Certificate info=new Certificate();
		        	if(sht0.getRow(i)!=null) {
		        		info.setCustomerName(sht0.getRow(i).getCell(0)+"");// 公司名称
			        	info.setSmlpc(sht0.getRow(i).getCell(1)+"");// smplc
			        			        	
			        	info.setItemNo(sht0.getRow(i).getCell(2)+"");// 货品编号 
			        	
			        	info.setOrderQty(sht0.getRow(i).getCell(3)+"");// order qty 数量
			        	
			        	info.setProductName(sht0.getRow(i).getCell(4)+"");//产品名称
			        	info.setType(sht0.getRow(i).getCell(5)+"");//号型
			        	info.setInternalCode(sht0.getRow(i).getCell(6)+"");//内部码
			        	info.setGrade(sht0.getRow(i).getCell(7)+"");//等级
			        	info.setProductStandard(sht0.getRow(i).getCell(8)+"");//产品标准
			        	info.setSecurityCategory(sht0.getRow(i).getCell(9)+"");//安全级别
			        	info.setCategory(sht0.getRow(i).getCell(10)+"");//安全级别类别
			        	info.setColour(sht0.getRow(i).getCell(11)+"");//颜色
			        	//info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	
			        	Cell riQiCell = sht0.getRow(i).getCell(12);
			        	if(riQiCell != null) {
			        		String haha = parseExcel(riQiCell);
				        	info.setDateOfManufacture(haha);//生产日期
			        		
			        	}else {
			        		info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	}
			        	
			        	info.setFabricString(sht0.getRow(i).getCell(13)+"");//面料
			        	
			        	info.setInspector(sht0.getRow(i).getCell(14)+"");//检测员
			        	info.setPlaceOfOrigin(sht0.getRow(i).getCell(15)+"");//产地
			        	info.setDistributor(sht0.getRow(i).getCell(16)+"");//经销商
			        	info.setLocation(sht0.getRow(i).getCell(17)+"");//地址
			        	info.setLocationInfo(sht0.getRow(i).getCell(18)+"");//详情地址
			        	info.setPhone(sht0.getRow(i).getCell(19)+"");//电话
				        info.setPostalCode(sht0.getRow(i).getCell(20)+"");//邮政编码
			        	info.setWashingInstructions(sht0.getRow(i).getCell(21)+"");//洗涤说明
			        	
						info.setItemNoColour(sht0.getRow(i).getCell(2)+"" + sht0.getRow(i).getCell(11)+"");//同款同色
						
						
						infoList.add(info);
		        	}
		        	
		        }
		        
		        List<List<Certificate>> infoListList = new ArrayList<>();
		        
		        // 根据同款同色同币种去重
	            Set<Certificate> personSet = new TreeSet<>((o1, o2) -> o1.getItemNoColour().compareTo(o2.getItemNoColour()) );
	            personSet.addAll(infoList);

	            List<Certificate> a =  new ArrayList<>(personSet);
	            
	            for(int i=0;i<a.size();i++) {//把同款同色同币种的进行分类
	            	List<Certificate> infoList1 = new ArrayList<>();
	            	for(int j=0;j<infoList.size();j++) {
	            		if(a.get(i).getItemNoColour().equals(infoList.get(j).getItemNoColour())) {//比较同款同色同币种 相同的放在一起
	            			infoList1.add(infoList.get(j));
	            		}
	            	}
	            	infoListList.add(infoList1);
	            }
	            
            	List<List<List<Certificate>>> infoListList3 = new ArrayList<>();
	            
	            for(int i=0;i<infoListList.size();i++) {//第一层  不同的款色币种
	            	Integer row = Integer.parseInt(df.format(Math.ceil(infoListList.get(i).size()/3.00)));//判断它有几行
	            	List<List<Certificate>> infoListListRow = new ArrayList<>();
	            		for(int j=0;j<row;j++) {//第二层  每个款色币种下面的数据有几行
	            			List<Certificate> infoListK = new ArrayList<>();//每五个放在一起
	            			for(int k=0;k<3;k++) {//第三层  把数据放进去  每五个一换行
	            				if((j*3+k) == infoListList.get(i).size()) {
	    							break;
	    						}
	            				infoListK.add(infoListList.get(i).get(j*3+k));
		            		}
	            			infoListListRow.add(infoListK);
	            		}
	            	infoListList3.add(infoListListRow);
	            }	            		       
		        
		        JSONResult jsonResult = new JSONResult();
		        jsonResult.setObj(infoListList3);
		        HashMap<String, Object> fileObject = new HashMap<>();
		        fileObject.put("fileName", oriFilename);
		        fileObject.put("fileUrl", saveUrl);
		        jsonResult.setObjects(fileObject);
		        jsonResult.setSuccess(true);
		        return jsonResult;
		        
		} catch (Exception e) {
			log.error("Transfer file fail :", e);
		}

		return JSONResult.error("文件读取失败！请上传规定格式文件！");
	}
	
	
	/**
	 * excel -- 2019新版合格证
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/excel-upload-hegezheng-xin", method = RequestMethod.POST)
	public @ResponseBody JSONResult excelUploadHeGeZhengXin(@RequestParam(value = "file") MultipartFile file) {
		try {	
				String oriFilename = file.getOriginalFilename();
				String fileExt = FilenameUtils.getExtension(oriFilename).toLowerCase();
				String saveUrl = fileUploadPath  + new SimpleDateFormat("/yyyy/MM/dd/").format(new Date()) + DateUtils.formatDate(Calendar.getInstance().getTime(), "yyyyMMddHHmmSS/") + GUIDUtil.generateRandon(8)+"."+fileExt;;
				// 如果文件夹不存在则创建
	            File pathfile = new File(saveUrl);
	            File path = pathfile.getParentFile();
	            if (!path.exists()) {
	            	path.mkdirs();
	            }
				File srcFile = new File(saveUrl);
				FileUtils.copyInputStreamToFile(file.getInputStream(), srcFile);
				
				Workbook wb0; 
				if("xls".equals(fileExt)){
					POIFSFileSystem poifsFileSystem = new POIFSFileSystem(file.getInputStream());
					wb0 = new HSSFWorkbook(poifsFileSystem);//2003
	            }else if("xlsx".equals(fileExt)){
	            	wb0 = new XSSFWorkbook(file.getInputStream());//2007
	            }else{
	            	wb0 = null;
	            	JSONResult.error("不支持的文件类型: " + fileExt);
					throw new RuntimeException("the file is too small, transfer failed.");       
	            }
				
				 // 获取选项卡对象 第0个选项卡  
				Sheet sht0 = wb0.getSheetAt(0);  

		        DecimalFormat df = new DecimalFormat("0");
		        
		        int rowNum = sht0.getLastRowNum();//总行数
		        rowNum = RowNumUtil.getRowNum(sht0);
		        List<Certificate> infoList = new ArrayList<>();

		        for (int i = 1; i <= rowNum; i++) {
		        	for(int j=0;j<=11;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	for(int j=13;j<=44;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	//创建实体类
		        	Certificate info=new Certificate();
		        	if(sht0.getRow(i)!=null) {
		        		info.setCustomerName(sht0.getRow(i).getCell(0)+"");// 公司名称
			        	info.setSmlpc(sht0.getRow(i).getCell(1)+"");// smplc
			        			        	
			        	info.setItemNo(sht0.getRow(i).getCell(2)+"");// 货品编号 
			        	
			        	info.setOrderQty(sht0.getRow(i).getCell(3)+"");// order qty 数量
			        	
			        	info.setProductName(sht0.getRow(i).getCell(4)+"");//产品名称
			        	info.setType(sht0.getRow(i).getCell(5)+"");//号型
			        	//info.setArtNo(sht0.getRow(i).getCell(6)+"");//货号
			        	info.setInternalCode(sht0.getRow(i).getCell(6)+"");//内部码
			        	info.setGrade(sht0.getRow(i).getCell(7)+"");//等级
			        	info.setProductStandard(sht0.getRow(i).getCell(8)+"");//执行标准
			        	info.setSecurityCategory(sht0.getRow(i).getCell(9)+"");//安全级别
			        	info.setCategory(sht0.getRow(i).getCell(10)+"");//安全级别类别
			        	info.setColour(sht0.getRow(i).getCell(11)+"");//颜色
			        	//info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	
			        	Cell riQiCell = sht0.getRow(i).getCell(12);
			        	if(riQiCell != null) {
			        		String haha = parseExcel(riQiCell);
				        	info.setDateOfManufacture(haha);//生产日期
			        		
			        	}else {
			        		info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	}
			        	
			        	List<Fabric> fabricList = new ArrayList<>();
			        	for(int j=0;j<8;j++) {//总共有8列面料信息
			        		int a = 13 + j*3;
			        		int b = 14 + j*3;
			        		int c = 15 + j*3; 
			        		String name = sht0.getRow(i).getCell(a)+"";
				        	String mianliao = sht0.getRow(i).getCell(b)+"";
				        	String beizhu = sht0.getRow(i).getCell(c)+"";
				        	if((mianliao != null && !mianliao.equals("null") && !mianliao.equals(""))) {
					        	Fabric fc = new Fabric();
				        		fc.setName(name);
				        		
				        		List<List<String>> mianListList = new ArrayList<>();//每五个放在一起
				        		String[] mianliaoList = mianliao.split("/");
				        		Integer row = Integer.parseInt(df.format(Math.ceil(mianliaoList.length/3.00)));//判断它有几行
				        		for(int k=0;k<row;k++) {//第二层  每个款色币种下面的数据有几行
			            			List<String> mian = new ArrayList<>();//每五个放在一起
			            			for(int h=0;h<3;h++) {//第三层  把数据放进去  每五个一换行
			            				if((k*3+h) == mianliaoList.length) {
			    							break;
			    						}
			            				
			            				mian.add(mianliaoList[k*3+h]);
				            		}
			            			mianListList.add(mian);
			            		}
				        		
				        		fc.setComponent(mianListList);
				        		fc.setRemarks(beizhu);
				        		/**---------括号为标识分割备注信息start------------**/
				        		String beizhu1 = "";
				        		for(int k=0;k<beizhu.length();k++) {
				        			String r = beizhu.substring(k,k+1);
				        			if(r.equals("（")) {
				        				beizhu1 = beizhu1 + "(";
				        			}else if(r.equals("）")){
				        				beizhu1 = beizhu1 + ")";
				        			}else{
				        				beizhu1 = beizhu1 + r;
				        			}
				        		}
				        		String[] remarksS = beizhu1.split("\\)");
				        		List<String> remarksList = new ArrayList<>();
				        		for(int k=0;k<remarksS.length;k++) {
				        			remarksList.add(remarksS[k]+")");
				        		}
				        		fc.setRemarksList(remarksList);
				        		/**----------------括号为标识分割备注信息end----------------**/
				        		fabricList.add(fc);
				        	}
			        	}
			        	info.setFabricList(fabricList);//(面料/备注)集合
			        	info.setInspector(sht0.getRow(i).getCell(37)+"");//检测员
			        	info.setPlaceOfOrigin(sht0.getRow(i).getCell(38)+"");//产地
			        	info.setDistributor(sht0.getRow(i).getCell(39)+"");//经销商
			        	info.setLocation(sht0.getRow(i).getCell(40)+"");//地址
			        	info.setLocationInfo(sht0.getRow(i).getCell(41)+"");//详情地址
			        	info.setPhone(sht0.getRow(i).getCell(42)+"");//电话
				        info.setPostalCode(sht0.getRow(i).getCell(43)+"");//邮政编码
			        	info.setWashingInstructions(sht0.getRow(i).getCell(44)+"");//洗涤说明
			        	
						info.setItemNoColour(sht0.getRow(i).getCell(2)+"" + sht0.getRow(i).getCell(11)+"");//同款同色
						
						
						infoList.add(info);
		        	}
		        	
		        }
		        
		        List<List<Certificate>> infoListList = new ArrayList<>();
		        
		        // 根据同款同色同币种去重
	            Set<Certificate> personSet = new TreeSet<>((o1, o2) -> o1.getItemNoColour().compareTo(o2.getItemNoColour()) );
	            personSet.addAll(infoList);

	            List<Certificate> a =  new ArrayList<>(personSet);
	            
	            for(int i=0;i<a.size();i++) {//把同款同色同币种的进行分类
	            	List<Certificate> infoList1 = new ArrayList<>();
	            	for(int j=0;j<infoList.size();j++) {
	            		if(a.get(i).getItemNoColour().equals(infoList.get(j).getItemNoColour())) {//比较同款同色同币种 相同的放在一起
	            			infoList1.add(infoList.get(j));
	            		}
	            	}
	            	infoListList.add(infoList1);
	            }
	            
            	List<List<List<Certificate>>> infoListList3 = new ArrayList<>();
	            
	            for(int i=0;i<infoListList.size();i++) {//第一层  不同的款色币种
	            	Integer row = Integer.parseInt(df.format(Math.ceil(infoListList.get(i).size()/3.00)));//判断它有几行
	            	List<List<Certificate>> infoListListRow = new ArrayList<>();
	            		for(int j=0;j<row;j++) {//第二层  每个款色币种下面的数据有几行
	            			List<Certificate> infoListK = new ArrayList<>();//每五个放在一起
	            			for(int k=0;k<3;k++) {//第三层  把数据放进去  每五个一换行
	            				if((j*3+k) == infoListList.get(i).size()) {
	    							break;
	    						}
	            				infoListK.add(infoListList.get(i).get(j*3+k));
		            		}
	            			infoListListRow.add(infoListK);
	            		}
	            	infoListList3.add(infoListListRow);
	            }	            		       
		        
		        JSONResult jsonResult = new JSONResult();
		        jsonResult.setObj(infoListList3);
		        HashMap<String, Object> fileObject = new HashMap<>();
		        fileObject.put("fileName", oriFilename);
		        fileObject.put("fileUrl", saveUrl);
		        jsonResult.setObjects(fileObject);
		        jsonResult.setSuccess(true);
		        return jsonResult;
		        
		} catch (Exception e) {
			log.error("Transfer file fail :", e);
		}

		return JSONResult.error("文件读取失败！请上传规定格式文件！");
	}
	
	
	/**
	 * excel -- 成衣	    合格证  大版
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/excel-upload-hegezheng-chengyi", method = RequestMethod.POST)
	public @ResponseBody JSONResult excelUploadHeGeZhengChengYi(@RequestParam(value = "file") MultipartFile file) {
		try {	
				String oriFilename = file.getOriginalFilename();
				String fileExt = FilenameUtils.getExtension(oriFilename).toLowerCase();
				String saveUrl = fileUploadPath  + new SimpleDateFormat("/yyyy/MM/dd/").format(new Date()) + DateUtils.formatDate(Calendar.getInstance().getTime(), "yyyyMMddHHmmSS/") + GUIDUtil.generateRandon(8)+"."+fileExt;;
				// 如果文件夹不存在则创建
	            File pathfile = new File(saveUrl);
	            File path = pathfile.getParentFile();
	            if (!path.exists()) {
	            	path.mkdirs();
	            }
				File srcFile = new File(saveUrl);
				FileUtils.copyInputStreamToFile(file.getInputStream(), srcFile);
				
				Workbook wb0; 
				if("xls".equals(fileExt)){
					POIFSFileSystem poifsFileSystem = new POIFSFileSystem(file.getInputStream());
					wb0 = new HSSFWorkbook(poifsFileSystem);//2003
	            }else if("xlsx".equals(fileExt)){
	            	wb0 = new XSSFWorkbook(file.getInputStream());//2007
	            }else{
	            	wb0 = null;
	            	JSONResult.error("不支持的文件类型: " + fileExt);
					throw new RuntimeException("the file is too small, transfer failed.");       
	            }
				
				 // 获取选项卡对象 第0个选项卡  
				Sheet sht0 = wb0.getSheetAt(0);  

		        DecimalFormat df = new DecimalFormat("0");
		        
		        int rowNum = sht0.getLastRowNum();//总行数
		        
		        
		        rowNum = RowNumUtil.getRowNum(sht0);

		        
		        List<Certificate> infoList = new ArrayList<>();

		        for (int i = 1; i <= rowNum; i++) {
		        	for(int j=0;j<=11;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	for(int j=13;j<=21;j++){
		        		if(sht0.getRow(i)!=null && sht0.getRow(i).getCell(j) != null) {
			        		sht0.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
			        	}  
		        	}
		        	//创建实体类
		        	Certificate info=new Certificate();
		        	if(sht0.getRow(i)!=null) {
		        		info.setCustomerName(sht0.getRow(i).getCell(0)+"");// 公司名称
			        	info.setSmlpc(sht0.getRow(i).getCell(1)+"");// smplc
			        			        	
			        	info.setItemNo(sht0.getRow(i).getCell(2)+"");// 货品编号 
			        	
			        	info.setOrderQty(sht0.getRow(i).getCell(3)+"");// order qty 数量
			        	
			        	info.setProductName(sht0.getRow(i).getCell(4)+"");//产品名称
			        	info.setType(sht0.getRow(i).getCell(5)+"");//号型
			        	info.setInternalCode(sht0.getRow(i).getCell(6)+"");//内部码
			        	info.setGrade(sht0.getRow(i).getCell(7)+"");//等级
			        	info.setProductStandard(sht0.getRow(i).getCell(8)+"");//产品标准
			        	String[] productStandardS = sht0.getRow(i).getCell(8).toString().split("内件");
			        	List<String> productStandardList = new ArrayList<String>();
			        	if(productStandardS != null && productStandardS.length>0) {
			        		productStandardList.add(productStandardS[0]);
			        	}
			        	if(productStandardS != null && productStandardS.length>1) {
			        		productStandardList.add("内件"+productStandardS[1]);
			        	}
			        	info.setProductStandardList(productStandardList);

			        	info.setSecurityCategory(sht0.getRow(i).getCell(9)+"");//安全级别
			        	info.setCategory(sht0.getRow(i).getCell(10)+"");//安全级别类别
			        	info.setColour(sht0.getRow(i).getCell(11)+"");//颜色
			        	info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	
			            
			        	Cell riQiCell = sht0.getRow(i).getCell(12);
			        	if(riQiCell != null) {
			        		String haha = parseExcel(riQiCell);
				        	info.setDateOfManufacture(haha);//生产日期
			        		
			        	}else {
			        		info.setDateOfManufacture(sht0.getRow(i).getCell(12)+"");//生产日期
			        	}
			        	
			        	info.setFabricString(sht0.getRow(i).getCell(13)+"");//面料
			        	
			        	info.setInspector(sht0.getRow(i).getCell(14)+"");//检测员
			        	info.setPlaceOfOrigin(sht0.getRow(i).getCell(15)+"");//产地
			        	info.setDistributor(sht0.getRow(i).getCell(16)+"");//经销商
			        	info.setLocation(sht0.getRow(i).getCell(17)+"");//地址
			        	info.setLocationInfo(sht0.getRow(i).getCell(18)+"");//详情地址
			        	info.setPhone(sht0.getRow(i).getCell(19)+"");//电话
				        info.setPostalCode(sht0.getRow(i).getCell(20)+"");//邮政编码
			        	info.setWashingInstructions(sht0.getRow(i).getCell(21)+"");//洗涤说明
			        	
						info.setItemNoColour(sht0.getRow(i).getCell(2)+"" + sht0.getRow(i).getCell(11)+"");//同款同色
						
						
						infoList.add(info);
		        	}
		        	
		        }
		        
		        List<List<Certificate>> infoListList = new ArrayList<>();
		        
		        // 根据同款同色同币种去重
	            Set<Certificate> personSet = new TreeSet<>((o1, o2) -> o1.getItemNoColour().compareTo(o2.getItemNoColour()) );
	            personSet.addAll(infoList);

	            List<Certificate> a =  new ArrayList<>(personSet);
	            
	            for(int i=0;i<a.size();i++) {//把同款同色同币种的进行分类
	            	List<Certificate> infoList1 = new ArrayList<>();
	            	for(int j=0;j<infoList.size();j++) {
	            		if(a.get(i).getItemNoColour().equals(infoList.get(j).getItemNoColour())) {//比较同款同色同币种 相同的放在一起
	            			infoList1.add(infoList.get(j));
	            		}
	            	}
	            	infoListList.add(infoList1);
	            }
	            
            	List<List<List<Certificate>>> infoListList3 = new ArrayList<>();
	            
	            for(int i=0;i<infoListList.size();i++) {//第一层  不同的款色币种
	            	Integer row = Integer.parseInt(df.format(Math.ceil(infoListList.get(i).size()/3.00)));//判断它有几行
	            	List<List<Certificate>> infoListListRow = new ArrayList<>();
	            		for(int j=0;j<row;j++) {//第二层  每个款色币种下面的数据有几行
	            			List<Certificate> infoListK = new ArrayList<>();//每五个放在一起
	            			for(int k=0;k<3;k++) {//第三层  把数据放进去  每五个一换行
	            				if((j*3+k) == infoListList.get(i).size()) {
	    							break;
	    						}
	            				infoListK.add(infoListList.get(i).get(j*3+k));
		            		}
	            			infoListListRow.add(infoListK);
	            		}
	            	infoListList3.add(infoListListRow);
	            }	            		       
		        
		        JSONResult jsonResult = new JSONResult();
		        jsonResult.setObj(infoListList3);
		        HashMap<String, Object> fileObject = new HashMap<>();
		        fileObject.put("fileName", oriFilename);
		        fileObject.put("fileUrl", saveUrl);
		        jsonResult.setObjects(fileObject);
		        jsonResult.setSuccess(true);
		        return jsonResult;
		        
		} catch (Exception e) {
			log.error("Transfer file fail :", e);
		}

		return JSONResult.error("文件读取失败！请上传规定格式文件！");
	}
	
	
	
	
	
	@RequestMapping("/excel-initial-info.html")
	public String excelInitialInfo(Model model,ExcelInfo info) {
		model.addAttribute("excel", info);
		return "screen/file/excel-initial-info";
	}
	
	@RequestMapping("/print-initial-info.html")
	public String printInitialInfo(Model model,ExcelInfo info) {
		model.addAttribute("excel", info);
		return "screen/file/print-initial";
	}

	/**
	 * excel -- 获取initial具体详情
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/get-excel-initial-info", method = RequestMethod.POST)
	public @ResponseBody JSONResult getExcelInitialInfo(ExcelInfo info) {
		try{
			List<InitialExcelInfo> InitialList = fileUploadService.queryExcelInitialInfo(info);
	        DecimalFormat df = new DecimalFormat("0");
        	List<List<List<InitialExcelInfo>>> infoListList3 = new ArrayList<>();

	        //如果类型是1或者2
			if(info.getFileType() == 1 || info.getFileType() == 2) {
		        List<List<InitialExcelInfo>> infoListList = new ArrayList<>();
		        // 根据同款同色同币种去重
	            Set<InitialExcelInfo> personSet = new TreeSet<>((o1, o2) -> o1.getItemNoColourCurrency().compareTo(o2.getItemNoColourCurrency()) );
	            personSet.addAll(InitialList);

	            List<InitialExcelInfo> a =  new ArrayList<>(personSet);
	            
	            for(int i=0;i<a.size();i++) {//把同款同色同币种的进行分类
	            	List<InitialExcelInfo> infoList1 = new ArrayList<>();
	            	for(int j=0;j<InitialList.size();j++) {
	            		if(a.get(i).getItemNoColourCurrency().equals(InitialList.get(j).getItemNoColourCurrency())) {//比较同款同色同币种 相同的放在一起
	            			infoList1.add(InitialList.get(j));
	            		}
	            	}
	            	infoListList.add(infoList1);
	            }
	            for(int i=0;i<infoListList.size();i++) {//第一层  不同的款色币种
	            	Integer row = Integer.parseInt(df.format(Math.ceil(infoListList.get(i).size()/3.00)));//判断它有几行
	            	List<List<InitialExcelInfo>> infoListListRow = new ArrayList<>();
	            		for(int j=0;j<row;j++) {//第二层  每个款色币种下面的数据有几行
	            			List<InitialExcelInfo> infoListK = new ArrayList<>();//每五个放在一起
	            			for(int k=0;k<3;k++) {//第三层  把数据放进去  每五个一换行
	            				if((j*3+k) == infoListList.get(i).size()) {
	    							break;
	    						}
	            				infoListK.add(infoListList.get(i).get(j*3+k));
		            		}
	            			infoListListRow.add(infoListK);
	            		}
	            	infoListList3.add(infoListListRow);
	            }
			}else if(info.getFileType() == 3 || info.getFileType() == 4 || info.getFileType() == 7 || info.getFileType() == 8){
				
				for(int i=0;i<InitialList.size();i++) {
					InitialList.get(i).setFabricList(getFabricList(InitialList.get(i)));
				}
		        List<List<InitialExcelInfo>> infoListList = new ArrayList<>();
		        
		        // 根据同款同色同币种去重
	            Set<InitialExcelInfo> personSet = new TreeSet<>((o1, o2) -> o1.getItemNoColour().compareTo(o2.getItemNoColour()) );
	            personSet.addAll(InitialList);

	            List<InitialExcelInfo> a =  new ArrayList<>(personSet);
	            
	            for(int i=0;i<a.size();i++) {//把同款同色同币种的进行分类
	            	List<InitialExcelInfo> InitialList1 = new ArrayList<>();
	            	for(int j=0;j<InitialList.size();j++) {
	            		if(a.get(i).getItemNoColour().equals(InitialList.get(j).getItemNoColour())) {//比较同款同色同币种 相同的放在一起
	            			InitialList1.add(InitialList.get(j));
	            		}
	            	}
	            	infoListList.add(InitialList1);
	            }
	            	            
	            for(int i=0;i<infoListList.size();i++) {//第一层  不同的款色币种
	            	Integer row = Integer.parseInt(df.format(Math.ceil(infoListList.get(i).size()/3.00)));//判断它有几行
	            	List<List<InitialExcelInfo>> infoListListRow = new ArrayList<>();
	            		for(int j=0;j<row;j++) {//第二层  每个款色币种下面的数据有几行
	            			List<InitialExcelInfo> infoListK = new ArrayList<>();//每五个放在一起
	            			for(int k=0;k<3;k++) {//第三层  把数据放进去  每五个一换行
	            				if((j*3+k) == infoListList.get(i).size()) {
	    							break;
	    						}
	            				infoListK.add(infoListList.get(i).get(j*3+k));
		            		}
	            			infoListListRow.add(infoListK);
	            		}
	            	infoListList3.add(infoListListRow);
	            }
				
			}else if(info.getFileType() == 5 || info.getFileType() == 6 || info.getFileType() == 9 || info.getFileType() == 10) {
		        List<List<InitialExcelInfo>> infoListList = new ArrayList<>();
		        for(int i=0;i<InitialList.size();i++) {
		        	String productStandard = InitialList.get(i).getProductStandard();//产品标准
		        	if(productStandard !=null) {
		        		String[] productStandardS = productStandard.split("内件");
			        	List<String> productStandardList = new ArrayList<String>();
			        	if(productStandardS != null && productStandardS.length>0) {
			        		productStandardList.add(productStandardS[0]);
			        	}
			        	if(productStandardS != null && productStandardS.length>1) {
			        		productStandardList.add("内件"+productStandardS[1]);
			        	}
			        	InitialList.get(i).setProductStandardList(productStandardList);
		        	}
		        }
		        // 根据同款同色同币种去重
	            Set<InitialExcelInfo> personSet = new TreeSet<>((o1, o2) -> o1.getItemNoColour().compareTo(o2.getItemNoColour()) );
	            personSet.addAll(InitialList);

	            List<InitialExcelInfo> a =  new ArrayList<>(personSet);
	            
	            for(int i=0;i<a.size();i++) {//把同款同色同币种的进行分类
	            	List<InitialExcelInfo> InitialList1 = new ArrayList<>();
	            	for(int j=0;j<InitialList.size();j++) {
	            		if(a.get(i).getItemNoColour().equals(InitialList.get(j).getItemNoColour())) {//比较同款同色同币种 相同的放在一起
	            			InitialList1.add(InitialList.get(j));
	            		}
	            	}
	            	infoListList.add(InitialList1);
	            }
	            	            
	            for(int i=0;i<infoListList.size();i++) {//第一层  不同的款色币种
	            	Integer row = Integer.parseInt(df.format(Math.ceil(infoListList.get(i).size()/3.00)));//判断它有几行
	            	List<List<InitialExcelInfo>> infoListListRow = new ArrayList<>();
	            		for(int j=0;j<row;j++) {//第二层  每个款色币种下面的数据有几行
	            			List<InitialExcelInfo> infoListK = new ArrayList<>();//每五个放在一起
	            			for(int k=0;k<3;k++) {//第三层  把数据放进去  每五个一换行
	            				if((j*3+k) == infoListList.get(i).size()) {
	    							break;
	    						}
	            				infoListK.add(infoListList.get(i).get(j*3+k));
		            		}
	            			infoListListRow.add(infoListK);
	            		}
	            	infoListList3.add(infoListListRow);
	            }
			}

			
			
			JSONResult jsonResult = new JSONResult();
			jsonResult.setObj(infoListList3);
			jsonResult.setSuccess(true);
			return jsonResult;
		}catch (Exception e) {
			log.error("Transfer file fail :", e);
		}

		return null;
	}
	
	
	/**
	 * 封装面料组合
	 * @param InitialList
	 * @return
	 */
	public List<Fabric> getFabricList(InitialExcelInfo InitialList) {
		DecimalFormat df = new DecimalFormat("0");
		String mianliao1 = InitialList.getFabricNameOne();//面料名称1
		String info1 = InitialList.getFabricInfoOne();//面料内容1
		String remarks1 = InitialList.getFabricRemarksOne();//面料备注1
		String mianliao2 = InitialList.getFabricNameTwo();//面料名称2
		String info2 = InitialList.getFabricInfoTwo();//面料内容2
		String remarks2 = InitialList.getFabricRemarksTwo();//面料备注2
		String mianliao3 = InitialList.getFabricNameThree();//面料名称3
		String info3 = InitialList.getFabricInfoThree();//面料内容3
		String remarks3 = InitialList.getFabricRemarksThree();//面料备注3
		String mianliao4 = InitialList.getFabricNameFour();//面料名称4
		String info4 = InitialList.getFabricInfoFour();//面料内容4
		String remarks4 = InitialList.getFabricRemarksFour();//面料备注4
		String mianliao5 = InitialList.getFabricNameFive();//面料名称5
		String info5 = InitialList.getFabricInfoFive();//面料内容5
		String remarks5 = InitialList.getFabricRemarksFive();//面料备注5
		String mianliao6 = InitialList.getFabricNameSix();//面料名称6
		String info6 = InitialList.getFabricInfoSix();//面料内容6
		String remarks6 = InitialList.getFabricRemarksSix();//面料备注6
		String mianliao7 = InitialList.getFabricNameSeven();//面料名称7
		String info7 = InitialList.getFabricInfoSeven();//面料内容7
		String remarks7 = InitialList.getFabricRemarksSeven();//面料备注7
		String mianliao8 = InitialList.getFabricNameEight();//面料名称8
		String info8 = InitialList.getFabricInfoEight();//面料内容8
		String remarks8 = InitialList.getFabricRemarksEight();//面料备注8
		List<Fabric> fabricList = new ArrayList<>();
		
    	if((info1 != null && !info1.equals("null") && !info1.equals(""))) {
        	Fabric fc = new Fabric();
    		fc.setName(mianliao1);
    		List<List<String>> mianListList = new ArrayList<>();//每五个放在一起
    		String[] mianliaoList = info1.split("/");
    		Integer row = Integer.parseInt(df.format(Math.ceil(mianliaoList.length/3.00)));//判断它有几行
    		for(int k=0;k<row;k++) {//第二层  每个款色币种下面的数据有几行
    			List<String> mian = new ArrayList<>();//每五个放在一起
    			for(int h=0;h<3;h++) {//第三层  把数据放进去  每五个一换行
    				if((k*3+h) == mianliaoList.length) {
						break;
					}
    				
    				mian.add(mianliaoList[k*3+h]);
        		}
    			mianListList.add(mian);
    		}
    		fc.setComponent(mianListList);
    		fc.setRemarks(remarks1);
    		/**---------括号为标识分割备注信息start------------**/
    		String beizhu = "";
    		for(int k=0;k<remarks1.length();k++) {
    			String r = remarks1.substring(k,k+1);
    			if(r.equals("（")) {
    				beizhu = beizhu + "(";
    			}else if(r.equals("）")){
    				beizhu = beizhu + ")";
    			}else{
    				beizhu = beizhu + r;
    			}
    		}
    		String[] remarksS = beizhu.split("\\)");
    		List<String> remarksList = new ArrayList<>();
    		for(int k=0;k<remarksS.length;k++) {
    			remarksList.add(remarksS[k]+")");
    		}
    		fc.setRemarksList(remarksList);
    		/**----------------括号为标识分割备注信息end----------------**/
    		fabricList.add(fc);
		}
    	if((info2 != null && !info2.equals("null") && !info2.equals(""))) {
        	Fabric fc = new Fabric();
    		fc.setName(mianliao2);
    		List<List<String>> mianListList = new ArrayList<>();//每五个放在一起
    		String[] mianliaoList = info2.split("/");
    		Integer row = Integer.parseInt(df.format(Math.ceil(mianliaoList.length/3.00)));//判断它有几行
    		for(int k=0;k<row;k++) {//第二层  每个款色币种下面的数据有几行
    			List<String> mian = new ArrayList<>();//每五个放在一起
    			for(int h=0;h<3;h++) {//第三层  把数据放进去  每五个一换行
    				if((k*3+h) == mianliaoList.length) {
						break;
					}
    				
    				mian.add(mianliaoList[k*3+h]);
        		}
    			mianListList.add(mian);
    		}
    		fc.setComponent(mianListList);
    		fc.setRemarks(remarks2);
    		/**---------括号为标识分割备注信息start------------**/
    		String beizhu = "";
    		for(int k=0;k<remarks2.length();k++) {
    			String r = remarks2.substring(k,k+1);
    			if(r.equals("（")) {
    				beizhu = beizhu + "(";
    			}else if(r.equals("）")){
    				beizhu = beizhu + ")";
    			}else{
    				beizhu = beizhu + r;
    			}
    		}
    		String[] remarksS = beizhu.split("\\)");
    		List<String> remarksList = new ArrayList<>();
    		for(int k=0;k<remarksS.length;k++) {
    			remarksList.add(remarksS[k]+")");
    		}
    		fc.setRemarksList(remarksList);
    		/**----------------括号为标识分割备注信息end----------------**/
    		fabricList.add(fc);
		}
    	if((info3 != null && !info3.equals("null") && !info3.equals(""))) {
        	Fabric fc = new Fabric();
    		fc.setName(mianliao3);
    		List<List<String>> mianListList = new ArrayList<>();//每五个放在一起
    		String[] mianliaoList = info3.split("/");
    		Integer row = Integer.parseInt(df.format(Math.ceil(mianliaoList.length/3.00)));//判断它有几行
    		for(int k=0;k<row;k++) {//第二层  每个款色币种下面的数据有几行
    			List<String> mian = new ArrayList<>();//每五个放在一起
    			for(int h=0;h<3;h++) {//第三层  把数据放进去  每五个一换行
    				if((k*3+h) == mianliaoList.length) {
						break;
					}
    				
    				mian.add(mianliaoList[k*3+h]);
        		}
    			mianListList.add(mian);
    		}
    		fc.setComponent(mianListList);
    		fc.setRemarks(remarks3);
    		/**---------括号为标识分割备注信息start------------**/
    		String beizhu = "";
    		for(int k=0;k<remarks3.length();k++) {
    			String r = remarks3.substring(k,k+1);
    			if(r.equals("（")) {
    				beizhu = beizhu + "(";
    			}else if(r.equals("）")){
    				beizhu = beizhu + ")";
    			}else{
    				beizhu = beizhu + r;
    			}
    		}
    		String[] remarksS = beizhu.split("\\)");
    		List<String> remarksList = new ArrayList<>();
    		for(int k=0;k<remarksS.length;k++) {
    			remarksList.add(remarksS[k]+")");
    		}
    		fc.setRemarksList(remarksList);
    		/**----------------括号为标识分割备注信息end----------------**/
    		fabricList.add(fc);
		}	
    	if((info4 != null && !info4.equals("null") && !info4.equals(""))) {
        	Fabric fc = new Fabric();
    		fc.setName(mianliao4);
    		List<List<String>> mianListList = new ArrayList<>();//每五个放在一起
    		String[] mianliaoList = info4.split("/");
    		Integer row = Integer.parseInt(df.format(Math.ceil(mianliaoList.length/3.00)));//判断它有几行
    		for(int k=0;k<row;k++) {//第二层  每个款色币种下面的数据有几行
    			List<String> mian = new ArrayList<>();//每五个放在一起
    			for(int h=0;h<3;h++) {//第三层  把数据放进去  每五个一换行
    				if((k*3+h) == mianliaoList.length) {
						break;
					}
    				mian.add(mianliaoList[k*3+h]);
        		}
    			mianListList.add(mian);
    		}
    		fc.setComponent(mianListList);
    		fc.setRemarks(remarks4);
    		/**---------括号为标识分割备注信息start------------**/
    		String beizhu = "";
    		for(int k=0;k<remarks4.length();k++) {
    			String r = remarks4.substring(k,k+1);
    			if(r.equals("（")) {
    				beizhu = beizhu + "(";
    			}else if(r.equals("）")){
    				beizhu = beizhu + ")";
    			}else{
    				beizhu = beizhu + r;
    			}
    		}
    		String[] remarksS = beizhu.split("\\)");
    		List<String> remarksList = new ArrayList<>();
    		for(int k=0;k<remarksS.length;k++) {
    			remarksList.add(remarksS[k]+")");
    		}
    		fc.setRemarksList(remarksList);
    		/**----------------括号为标识分割备注信息end----------------**/
    		fabricList.add(fc);
		}
    	if((info5 != null && !info5.equals("null") && !info5.equals(""))) {
        	Fabric fc = new Fabric();
    		fc.setName(mianliao5);
    		List<List<String>> mianListList = new ArrayList<>();//每五个放在一起
    		String[] mianliaoList = info5.split("/");
    		Integer row = Integer.parseInt(df.format(Math.ceil(mianliaoList.length/3.00)));//判断它有几行
    		for(int k=0;k<row;k++) {//第二层  每个款色币种下面的数据有几行
    			List<String> mian = new ArrayList<>();//每五个放在一起
    			for(int h=0;h<3;h++) {//第三层  把数据放进去  每五个一换行
    				if((k*3+h) == mianliaoList.length) {
						break;
					}
    				
    				mian.add(mianliaoList[k*3+h]);
        		}
    			mianListList.add(mian);
    		}
    		fc.setComponent(mianListList);
    		fc.setRemarks(remarks5);
    		/**---------括号为标识分割备注信息start------------**/
    		String beizhu = "";
    		for(int k=0;k<remarks5.length();k++) {
    			String r = remarks5.substring(k,k+1);
    			if(r.equals("（")) {
    				beizhu = beizhu + "(";
    			}else if(r.equals("）")){
    				beizhu = beizhu + ")";
    			}else{
    				beizhu = beizhu + r;
    			}
    		}
    		String[] remarksS = beizhu.split("\\)");
    		List<String> remarksList = new ArrayList<>();
    		for(int k=0;k<remarksS.length;k++) {
    			remarksList.add(remarksS[k]+")");
    		}
    		fc.setRemarksList(remarksList);
    		/**----------------括号为标识分割备注信息end----------------**/
    		fabricList.add(fc);
		}	
    	if((info6 != null && !info6.equals("null") && !info6.equals(""))) {
        	Fabric fc = new Fabric();
    		fc.setName(mianliao6);
    		List<List<String>> mianListList = new ArrayList<>();//每五个放在一起
    		String[] mianliaoList = info6.split("/");
    		Integer row = Integer.parseInt(df.format(Math.ceil(mianliaoList.length/3.00)));//判断它有几行
    		for(int k=0;k<row;k++) {//第二层  每个款色币种下面的数据有几行
    			List<String> mian = new ArrayList<>();//每五个放在一起
    			for(int h=0;h<3;h++) {//第三层  把数据放进去  每五个一换行
    				if((k*3+h) == mianliaoList.length) {
						break;
					}
    				
    				mian.add(mianliaoList[k*3+h]);
        		}
    			mianListList.add(mian);
    		}
    		fc.setComponent(mianListList);
    		fc.setRemarks(remarks6);
    		/**---------括号为标识分割备注信息start------------**/
    		String beizhu = "";
    		for(int k=0;k<remarks6.length();k++) {
    			String r = remarks6.substring(k,k+1);
    			if(r.equals("（")) {
    				beizhu = beizhu + "(";
    			}else if(r.equals("）")){
    				beizhu = beizhu + ")";
    			}else{
    				beizhu = beizhu + r;
    			}
    		}
    		String[] remarksS = beizhu.split("\\)");
    		List<String> remarksList = new ArrayList<>();
    		for(int k=0;k<remarksS.length;k++) {
    			remarksList.add(remarksS[k]+")");
    		}
    		fc.setRemarksList(remarksList);
    		/**----------------括号为标识分割备注信息end----------------**/
    		fabricList.add(fc);
		}
    	if((mianliao7 != null && !info7.equals("null") && !info7.equals(""))) {
        	Fabric fc = new Fabric();
    		fc.setName(mianliao7);
    		List<List<String>> mianListList = new ArrayList<>();//每五个放在一起
    		String[] mianliaoList = info7.split("/");
    		Integer row = Integer.parseInt(df.format(Math.ceil(mianliaoList.length/3.00)));//判断它有几行
    		for(int k=0;k<row;k++) {//第二层  每个款色币种下面的数据有几行
    			List<String> mian = new ArrayList<>();//每五个放在一起
    			for(int h=0;h<3;h++) {//第三层  把数据放进去  每五个一换行
    				if((k*3+h) == mianliaoList.length) {
						break;
					}
    				
    				mian.add(mianliaoList[k*3+h]);
        		}
    			mianListList.add(mian);
    		}
    		fc.setComponent(mianListList);
    		fc.setRemarks(remarks7);
    		/**---------括号为标识分割备注信息start------------**/
    		String beizhu = "";
    		for(int k=0;k<remarks7.length();k++) {
    			String r = remarks7.substring(k,k+1);
    			if(r.equals("（")) {
    				beizhu = beizhu + "(";
    			}else if(r.equals("）")){
    				beizhu = beizhu + ")";
    			}else{
    				beizhu = beizhu + r;
    			}
    		}
    		String[] remarksS = beizhu.split("\\)");
    		List<String> remarksList = new ArrayList<>();
    		for(int k=0;k<remarksS.length;k++) {
    			remarksList.add(remarksS[k]+")");
    		}
    		fc.setRemarksList(remarksList);
    		/**----------------括号为标识分割备注信息end----------------**/
    		fabricList.add(fc);
		}
    	if((info8 != null && !info8.equals("null") && !info8.equals(""))) {
        	Fabric fc = new Fabric();
    		fc.setName(mianliao8);
    		List<List<String>> mianListList = new ArrayList<>();//每五个放在一起
    		String[] mianliaoList = info8.split("/");
    		Integer row = Integer.parseInt(df.format(Math.ceil(mianliaoList.length/3.00)));//判断它有几行
    		for(int k=0;k<row;k++) {//第二层  每个款色币种下面的数据有几行
    			List<String> mian = new ArrayList<>();//每五个放在一起
    			for(int h=0;h<3;h++) {//第三层  把数据放进去  每五个一换行
    				if((k*3+h) == mianliaoList.length) {
						break;
					}
    				
    				mian.add(mianliaoList[k*3+h]);
        		}
    			mianListList.add(mian);
    		}
    		fc.setComponent(mianListList);
    		fc.setRemarks(remarks8);
    		/**---------括号为标识分割备注信息start------------**/
    		String beizhu = "";
    		for(int k=0;k<remarks8.length();k++) {
    			String r = remarks8.substring(k,k+1);
    			if(r.equals("（")) {
    				beizhu = beizhu + "(";
    			}else if(r.equals("）")){
    				beizhu = beizhu + ")";
    			}else{
    				beizhu = beizhu + r;
    			}
    		}
    		String[] remarksS = beizhu.split("\\)");
    		List<String> remarksList = new ArrayList<>();
    		for(int k=0;k<remarksS.length;k++) {
    			remarksList.add(remarksS[k]+")");
    		}
    		fc.setRemarksList(remarksList);
    		/**----------------括号为标识分割备注信息end----------------**/
    		fabricList.add(fc);
		}
    	

		return fabricList;
	}
	
	
	boolean isDouble(String str)
	{
	   try
	   {
	      Double.parseDouble(str);
	      return true;
	   }
	   catch(NumberFormatException ex){
		   System.out.println(ex);
	   }
	   return false;
	}
	
	/**
	 * poi读取EXCEL判断是否是日期类型
	 * @param cell
	 * @return
	 */
	private String parseExcel(Cell cell) {  
        String result = new String();  
        switch (cell.getCellType()) {  
        case HSSFCell.CELL_TYPE_NUMERIC:// 数字类型  
            if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式  
                SimpleDateFormat sdf = null;  
                if (cell.getCellStyle().getDataFormat() == HSSFDataFormat  
                        .getBuiltinFormat("h:mm")) {  
                    sdf = new SimpleDateFormat("HH:mm");  
                } else {// 日期  
                    sdf = new SimpleDateFormat("yyyy年MM月dd日");  
                }  
                Date date = cell.getDateCellValue();  
                result = sdf.format(date);  
            } else if (cell.getCellStyle().getDataFormat() == 58) {  
                // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)  
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");  
                double value = cell.getNumericCellValue();  
                Date date = org.apache.poi.ss.usermodel.DateUtil  
                        .getJavaDate(value);  
                result = sdf.format(date);  
            } else {  
                /*double value = cell.getNumericCellValue();  
                CellStyle style = cell.getCellStyle();  
                DecimalFormat format = new DecimalFormat();  
                String temp = style.getDataFormatString();  */
                
                Date date = new Date(0) ;
	        	date = HSSFDateUtil.getJavaDate( new Double(cell.getNumericCellValue() ));
	        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");  
                
                // 单元格设置成常规  
                /*if (temp.equals("General")) {  
                    format.applyPattern("#");  
                }  */
                result = sdf.format(date);  
            }  
            break;  
        case HSSFCell.CELL_TYPE_STRING:// String类型  
            result = cell.getRichStringCellValue().toString();  
            break;  
        case HSSFCell.CELL_TYPE_BLANK:  
            result = "";  
        default:  
            result = "";  
            break;  
        }  
        return result;  
    }  
	
	

	
	
}
