/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.concacts.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.concacts.entity.MeContacts;

/**
 * 联系人模块DAO接口
 * @author fudiandong
 * @version 2017-07-25
 */
@MyBatisDao
public interface MeContactsDao extends CrudDao<MeContacts> {
	
}