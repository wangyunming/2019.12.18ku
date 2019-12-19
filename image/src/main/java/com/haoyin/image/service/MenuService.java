package com.haoyin.image.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.Menu;
import com.haoyin.image.entity.MenuQuery;



/**
 * 系统菜单 Service
 * 
 * @author Summer
 *
 *         2016年4月21日
 */
public interface MenuService {

	/**
	 * create a new system menu, return <code>true</code> or <code>false</code>
	 * 
	 * @param menu
	 * @return
	 */
	public boolean createMenu(Menu menu);

	/**
	 * update the menu info
	 * 
	 * @param menu
	 * @return
	 */
	public boolean updateMenu(Menu menu);

	/**
	 * Remove the menu by id
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeMenu(long id);

	/**
	 * 查询菜单
	 * 
	 * @param menuId
	 * @return
	 */
	public Menu queryMenu(long menuId);

	/**
	 * 查询菜单
	 * 
	 * @param query
	 * @return
	 */
	public PageInfo<Menu> queryMenuForList(MenuQuery query);

	/**
	 * 验证菜单是否存在
	 * 
	 * @param menuName
	 * @return
	 */
	public boolean verifyMenu(String menuName);

	/**
	 * 查询菜单树结构列表
	 * 
	 * @return
	 */
	public List<Menu> queryMenuTreeForList();
	
	/**
	 * 查询菜单树结构列表role菜单使用
	 * 
	 * @return
	 */
	public List<Menu> queryMenuTreeForRoleList();

}
