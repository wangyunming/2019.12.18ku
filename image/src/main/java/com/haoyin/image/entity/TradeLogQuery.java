package com.haoyin.image.entity;

import java.util.Date;

public class TradeLogQuery extends Paginator {

		private static final long serialVersionUID = 1L;

		/** 订单 ID */
		private String orderId;

		/** 订单编号 */
		private String orderNo;

		/** 用户 ID */
		private Long userId;

		/** 交易或订单名称 */
		private String subject;

		/** 交易类型 (1: 商品购买; 2: 充值(服务购买)), 3: 余额支付 */
		private String tradeType;

		/** 支付方式 */
		private Integer payMode;

		/** 查询开始日期 */
		private Date startDate;

		/** 查询结束日期 */
		private Date endDate;

		/**
		 * @return the {@link #orderId}
		 */
		public String getOrderId() {
			return orderId;
		}

		/**
		 * @param orderId
		 *            the {@link #orderId} to set
		 */
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}

		/**
		 * @return <code>the {@link #orderNo}</code>
		 */
		public String getOrderNo() {
			return orderNo;
		}

		/**
		 * @param orderNo
		 *            <code>the {@link #orderNo} to set</code>
		 */
		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}

		/**
		 * @return the userId
		 */
		public Long getUserId() {
			return userId;
		}

		/**
		 * @param userId
		 *            the userId to set
		 */
		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		/**
		 * @return the {@link #tradeType}
		 */
		public String getTradeType() {
			return tradeType;
		}

		/**
		 * @param tradeType
		 *            the {@link #tradeType} to set
		 */
		public void setTradeType(String tradeType) {
			this.tradeType = tradeType;
		}

		/**
		 * @return the {@link #payMode}
		 */
		public Integer getPayMode() {
			return payMode;
		}

		/**
		 * @param payMode
		 *            the {@link #payMode} to set
		 */
		public void setPayMode(Integer payMode) {
			this.payMode = payMode;
		}

		/**
		 * @return the {@link #startDate}
		 */
		public Date getStartDate() {
			return startDate;
		}

		/**
		 * @param startDate
		 *            the {@link #startDate} to set
		 */
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		/**
		 * @return the {@link #endDate}
		 */
		public Date getEndDate() {
			return endDate;
		}

		/**
		 * @param endDate
		 *            the {@link #endDate} to set
		 */
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

	}


