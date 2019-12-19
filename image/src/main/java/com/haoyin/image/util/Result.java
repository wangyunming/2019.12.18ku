package com.haoyin.image.util;

import java.io.Serializable;

public class Result implements Serializable{
	
		private static final long serialVersionUID = 1L;

		private Boolean isSuccess = false;

		private Long id;
		
		private String result;
		
		private String fileName;
		
		private String errorMessage;

		public Boolean getIsSuccess() {
			return isSuccess;
		}

		public void setIsSuccess(Boolean isSuccess) {
			this.isSuccess = isSuccess;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

	}


