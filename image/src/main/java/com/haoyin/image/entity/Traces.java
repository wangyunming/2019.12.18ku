package com.haoyin.image.entity;

/**
 * 物流信息
 */
public class Traces {
	// 时间 R
	private String AcceptTime;
	// 描述 R
	private String AcceptStation;
	// 备注
	private String Remark;

	public String getAcceptTime() {
		return AcceptTime;
	}

	public void setAcceptTime(String acceptTime) {
		AcceptTime = acceptTime;
	}

	public String getAcceptStation() {
		return AcceptStation;
	}

	public void setAcceptStation(String acceptStation) {
		AcceptStation = acceptStation;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	@Override
	public String toString() {
		return "Traces [AcceptTime=" + AcceptTime + ", AcceptStation=" + AcceptStation + ", Remark=" + Remark + "]";
	}

}
