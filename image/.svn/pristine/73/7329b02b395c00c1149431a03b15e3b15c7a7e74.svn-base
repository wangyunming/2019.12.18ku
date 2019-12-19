package com.haoyin.image.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.ExcelInfo;
import com.haoyin.image.entity.FileQuery;
import com.haoyin.image.entity.JSONResult;
import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.service.FileService;

@Controller
public class FileController {

	@Autowired
	private FileService fileService;

	@RequestMapping("/fileList.html")
	public String fileList(@ModelAttribute FileQuery query, Model model) {
		if(query==null){
			query=new FileQuery();
		}
		if(query.getPageNumTxt() != null) {
			query.setPageNum(query.getPageNumTxt());
		}
		UserProfile profile=getUser();
		if("OEM".equalsIgnoreCase(profile.getPosition())){
			return "redirect:/oem-fileList.html";
		}
		query.setPageSize(10);
		PageInfo<ExcelInfo> page = fileService.selectFileList(query);
		List<String>		uploadUsernameList=null;
		List<Long>			fileTypeList=null;
		List<Integer>       statusList=null;
		if(page.getList()!=null&&page.getList().size()>0){
		uploadUsernameList=page.getList().stream().map(excel->excel.getUploadUsername()).distinct().collect(Collectors.toList());
		statusList=page.getList().stream().distinct().map(excel->excel.getStatus()).distinct().collect(Collectors.toList());
		}
		model.addAttribute("fileList", page.getList());
		model.addAttribute("page", page);
		model.addAttribute("uploadUsernameList", uploadUsernameList);
		model.addAttribute("statusList", statusList);
		model.addAttribute("query", query);
		query.setPageSize(10000);
		PageInfo<ExcelInfo> page1 = fileService.selectFileList(query);
		query.setPageSize(10);
		if(page1.getList()!=null&&page1.getList().size()>0){
			fileTypeList=page1.getList().stream().distinct().map(excel->excel.getFileType()).distinct().collect(Collectors.toList());
		}
		model.addAttribute("fileTypeList", fileTypeList);
		return "screen/file/order-list-finished";
	}
	@RequestMapping("/oem-fileList.html")
	public String oemFileList(FileQuery query, Model model){
		if(query==null){
			query=new FileQuery();
		}
		if(query.getPageNumTxt() != null) {
			query.setPageNum(query.getPageNumTxt());
		}
		query.setPageSize(10);
		query.setId(getUser().getId());
		PageInfo<ExcelInfo> page = fileService.selectFileList(query);
		List<String>		uploadUsernameList=null;
		List<Long>			fileTypeList=null;
		List<Integer>       statusList=null;
		if(page.getList()!=null&&page.getList().size()>0){
		uploadUsernameList=page.getList().stream().map(excel->excel.getUploadUsername()).distinct().collect(Collectors.toList());
		statusList=page.getList().stream().distinct().map(excel->excel.getStatus()).distinct().collect(Collectors.toList());
		}
		model.addAttribute("fileList", page.getList());
		model.addAttribute("page", page);
		model.addAttribute("uploadUsernameList", uploadUsernameList);
		
		model.addAttribute("statusList", statusList);
		model.addAttribute("query", query);
		query.setPageSize(10000);
		PageInfo<ExcelInfo> page1 = fileService.selectFileList(query);
		query.setPageSize(10);
		if(page1.getList()!=null&&page1.getList().size()>0){
			fileTypeList=page1.getList().stream().distinct().map(excel->excel.getFileType()).distinct().collect(Collectors.toList());
		}
		model.addAttribute("fileTypeList", fileTypeList);
		return "screen/file/oem-file-list";
	}
	@PostMapping("/confirm-excel-file.html")
	public @ResponseBody JSONResult confirm(ExcelInfo info){
		Boolean  result=fileService.updateExcelStatus(info);
		JSONResult data=new JSONResult();
		data.setSuccess(result);
		return data;
	}
	private UserProfile getUser(){
		return (UserProfile) SecurityUtils.getSubject().getSession().getAttribute("uus");
	}
}
