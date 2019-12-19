package com.haoyin.image.entity;

import java.util.Date;
import java.util.List;

/**
 * 系统菜单
 * 
 * @author Summer
 */
public class Menu implements java.io.Serializable, Comparable<Menu> {

	private static final long serialVersionUID = 1L;

	/** 编号ID */
	private Long id;

	/** 父菜单ID */
	private Long parentId;

	/** 名称 */
	private String name;

	/** 类型(0:用户, 1:客户) */
	private Integer type;

	/** 是否是子菜单 */
	private Integer isLeaf;

	/** 排序 */
	private Integer sortOrder;

	/** 链接 */
	private String href;

	/** 样式 class name */
	private String style;

	/** Menu Target */
	private String target;

	/** 状态 */
	private Integer status;

	/** 创建时间 */
	private Date gmtCreate;

	/** 子菜单 */
	private List<Menu> subList;

	/** active status */
	private boolean isActive;

	/**
	 * @return the {@link #id}
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the {@link #id} to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the {@link #parentId}
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the {@link #parentId} to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the {@link #name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the {@link #name} to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the {@link #type}
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the {@link #type} to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the {@link #isLeaf}
	 */
	public Integer getIsLeaf() {
		return isLeaf;
	}

	/**
	 * @param isLeaf
	 *            the {@link #isLeaf} to set
	 */
	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}

	/**
	 * @return the {@link #sortOrder}
	 */
	public Integer getSortOrder() {
		return sortOrder;
	}

	/**
	 * @param sortOrder
	 *            the {@link #sortOrder} to set
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * @return the {@link #href}
	 */
	public String getHref() {
		return href;
	}

	/**
	 * @param href
	 *            the {@link #href} to set
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * @return the {@link #style}
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @param style
	 *            the {@link #style} to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @return the {@link #target}
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @param target
	 *            the {@link #target} to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * @return the {@link #status}
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the {@link #status} to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the {@link #gmtCreate}
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * @param gmtCreate
	 *            the {@link #gmtCreate} to set
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * @return the {@link #subList}
	 */
	public List<Menu> getSubList() {
		return subList;
	}

	/**
	 * @param subList
	 *            the {@link #subList} to set
	 */
	public void setSubList(List<Menu> subList) {
		this.subList = subList;
	}

	/**
	 * @return the {@link #isActive}
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the {@link #isActive} to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int compareTo(Menu m) {
		return this.sortOrder.compareTo(m.getSortOrder());
	}

	/**
	 * Copy a menu
	 * 
	 * @param menu
	 */
	public void copyFrom(Menu menu) {
		this.name = menu.getName();
		this.type = menu.getType();
		this.parentId = menu.getParentId();
		this.isLeaf = menu.getIsLeaf();
		this.sortOrder = menu.getSortOrder();
		this.href = menu.getHref();
		this.style = menu.getStyle();
		this.target = menu.getTarget();
		this.status = menu.getStatus();
	}

	@Override
	public String toString() {
		return new StringBuilder(Menu.class.getSimpleName()).append("\n id=").append(id).append(", name=").append(name).append(", type=").append(type)
				.append(", style=").append(style).append(", parentId=").append(parentId).append(", href=").append(href).append(", sortOrder=")
				.append(sortOrder).append(", isLeaf").append(isLeaf).append(", target=").append(target).append(", status=").append(status).toString();
	}

	// (1:一级菜单; 2:二级菜单; 3:三级菜单)
	private Integer level;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
