/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.concacts.service;

import java.util.List;

import com.thinkgem.jeesite.modules.me.entity.MeUser;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.concacts.entity.MeContacts;
import com.thinkgem.jeesite.modules.concacts.dao.MeContactsDao;

/**
 * 联系人模块Service
 * @author fudiandong
 * @version 2017-07-25
 */
@Service
@Transactional(readOnly = true)
public class MeContactsService extends CrudService<MeContactsDao, MeContacts> {

	public MeContacts get(String id) {
		return super.get(id);
	}
	
	public List<MeContacts> findList(MeContacts meContacts) {
		return super.findList(meContacts);
	}
	
	public Page<MeContacts> findPage(Page<MeContacts> page, MeContacts meContacts) {
		return super.findPage(page, meContacts);
	}
	
	@Transactional(readOnly = false)
	public void save(MeContacts meContacts) {
		super.save(meContacts);
	}
	
	@Transactional(readOnly = false)
	public void delete(MeContacts meContacts) {
		super.delete(meContacts);
	}

	public List<MeContacts> app_contactslist(Page<MeContacts> page, MeContacts meContacts) {
		meContacts.setPage(page);
		meContacts.setUser(UserUtils.getUser());
		page.setList(dao.findList(meContacts));
		return page.getList();
	}
}