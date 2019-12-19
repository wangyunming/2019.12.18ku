package com.haoyin.image.entity;


/**
 * 文件详情
 * @author admin
 *
 */
public class ExcelInfo{
	
	private String id;
	
	/** 文件名 **/
	private String fileName;
 
    /** 绝对地址 **/
    private String absoluteUrl;
 
    /** 相对地址 **/
    private String relativeUrl;

    /** 上传人ID **/
    private Long uploadUserId;
    
    /** 上传时间 **/
    private String uploadTime;
    /**OEM姓名 */
    private String uploadUsername;
    
    /** 文件状态*/
    private Integer status;
    
    public String getUploadUsername() {
		return uploadUsername;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setUploadUsername(String uploadUsername) {
		this.uploadUsername = uploadUsername;
	}

	/** **/
    private Long fileType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAbsoluteUrl() {
		return absoluteUrl;
	}

	public void setAbsoluteUrl(String absoluteUrl) {
		this.absoluteUrl = absoluteUrl;
	}

	public String getRelativeUrl() {
		return relativeUrl;
	}

	public void setRelativeUrl(String relativeUrl) {
		this.relativeUrl = relativeUrl;
	}

	public Long getUploadUserId() {
		return uploadUserId;
	}

	public void setUploadUserId(Long uploadUserId) {
		this.uploadUserId = uploadUserId;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Long getFileType() {
		return fileType;
	}

	public void setFileType(Long fileType) {
		this.fileType = fileType;
	}
    
    
    

}
