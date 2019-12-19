package com.haoyin.image.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import com.haoyin.image.entity.Menu;
import com.haoyin.image.entity.MenuQuery;
import com.haoyin.image.exception.DaoException;



/**
 * 系统菜单
 * 
 * @author Summer
 *
 *         2015年10月17日
 */
@Mapper
public interface MenuDAO {

	/**
	 * 保存菜单
	 * 
	 * @param menu
	 * @return
	 * @throws DaoException
	 */
	public Integer saveMenu(Menu menu) throws DaoException;

	/**
	 * 更新菜单
	 * 
	 * @param menu
	 * @return
	 * @throws DaoException
	 */
	public Integer updateMenu(Menu menu) throws DaoException;

	/**
	 * 删除菜单
	 * 
	 * @param menuId
	 * @return
	 * @throws DaoException
	 */
	public Integer deleteMenuById(Long menuId) throws DaoException;

	/**
	 * 根据 ID 查询菜单
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Menu findMenuById(Long id) throws DaoException;

	/**
	 * 根据 Name 查询菜单
	 * 
	 * @param menuName
	 * @return
	 * @throws DaoException
	 */
	public Menu findMenuByName(String menuName) throws DaoException;

	/**
	 * 查询菜单
	 * 
	 * @param query
	 * @return
	 * @throws DaoException
	 */
	public Page<Menu> findMenuForList(MenuQuery query) throws DaoException;

	/**
	 * 查询菜单树结构列表
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<Menu> findMenuTreeForList() throws DaoException;
	
	/**
	 * 查询菜单树结构列表根据角色
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<Menu> findMenuTreeByRole(Long id) throws DaoException;
	
	/**
	 * 查询系统菜单树结构列表
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<Menu> findAdminMenuTreeForList() throws DaoException;

	/**
	 * 更新前重新排序
	 * 
	 * @param sort
	 * @return
	 * @throws DaoException
	 */
	public Integer reorderBeforeUpdate(Menu menu) throws DaoException;

	/**
	 * 删除后重新排序
	 * 
	 * @param sort
	 * @return
	 * @throws DaoException
	 */
	public Integer reorderAfterRemove(Menu menu) throws DaoException;

}
