package com.haoyin.image.serviceImpl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
//import org.springframework.util.CollectionUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.Menu;
import com.haoyin.image.entity.MenuQuery;
import com.haoyin.image.exception.TransactionRuntimeException;
import com.haoyin.image.mapper.MenuDAO;
import com.haoyin.image.service.MenuService;




/**
 * @author Summer
 *
 *         2015年10月17日
 */
@Service
public class MenuServiceImpl extends BaseService implements MenuService {

	private static Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);

	private static final String SYS_CACHE = "systemCache";
	private static final String MENU_CACHE = "menu_cache";
	@Autowired
	private MenuDAO menuDAO;
	@Autowired
	private CacheManager cacheManager;

	/**
	 * @param menuDAO
	 *            the {@link #menuDAO} to set
	 */
	
	/**
	 * @param cacheManager
	 *            the {@link #cacheManager} to set
	 */
	

	
	
	@Override
	public boolean removeMenu(long id) {
		return executeTransaction(action -> {
			try {
				menuDAO.deleteMenuById(id);
				Menu menu = menuDAO.findMenuById(id);
				menuDAO.reorderAfterRemove(menu);

				
				

				return true;
			} catch (Exception e) {
				log.error("Exception occurs in remove menu :", e);
				throw new TransactionRuntimeException("Remove Menu Transaction Failed :", e);
			}
		});
	}

	
	

	@Override
	public List<Menu> queryMenuTreeForList() {

		try {
		Cache cache = cacheManager.getCache(SYS_CACHE);
		List<Menu> menuList = cache.get(MENU_CACHE, List.class);				
		if (CollectionUtils.isEmpty(menuList)) {
			menuList = menuDAO.findMenuTreeForList();
			paraFilter(menuList);
		}
		cache.putIfAbsent(MENU_CACHE, menuList);
		log.debug("system menu-list already exist in cache");
		return menuList;

		} catch (Exception e) {
			log.error("Exception occurs in query menu for list :", e);
		}

		return Collections.emptyList();
	}

	@Override
	public List<Menu> queryMenuTreeForRoleList() {

		try {
			List<Menu> menuList = menuDAO.findMenuTreeForList();
			return menuList;
		} catch (Exception e) {
			log.error("Exception occurs in query menu for list :", e);
		}

		return Collections.emptyList();
	}

	@Override
	public boolean verifyMenu(String menuName) {

		try {
			Menu menu = menuDAO.findMenuByName(menuName);
			return null == menu ? false : true;
		} catch (Exception e) {
			log.error("Exception occurs in verify menu is exists :", e);
		}

		return false;
	}

	/**
	 * 去除列表中空对象
	 * 
	 * @param menuList
	 */
	private void paraFilter(List<Menu> menuList) {
		if (CollectionUtils.isEmpty(menuList)) {
			return;
		}
		Iterator<Menu> iterator = menuList.iterator();
		while (iterator.hasNext()) {
			Menu menu = iterator.next();
			if (null == menu.getId()) {
				iterator.remove();
				continue;
			}
			paraFilter(menu.getSubList());
		}
	}

	@Override
	public boolean createMenu(Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Menu queryMenu(long menuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Menu> queryMenuForList(MenuQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

}
