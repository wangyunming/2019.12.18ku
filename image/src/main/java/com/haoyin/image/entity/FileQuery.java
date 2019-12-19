package com.haoyin.image.entity;

public class FileQuery extends Paginator{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String startTime;
	
	private String  endTime;
	
	private Integer fileType;
	
	private String uploadUsername;
	
	private Integer status;
	
	private String fileName;
	
	private Integer pageNumTxt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public String getUploadUsername() {
		return uploadUsername;
	}

	public void setUploadUsername(String uploadUsername) {
		this.uploadUsername = uploadUsername;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPageNumTxt() {
		return pageNumTxt;
	}

	public void setPageNumTxt(Integer pageNumTxt) {
		this.pageNumTxt = pageNumTxt;
	}

	
	
}
