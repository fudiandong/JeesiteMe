/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.me.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.me.entity.MeUser;
import com.thinkgem.jeesite.modules.me.dao.MeUserDao;

/**
 * user信息Service
 * @author fudiandong
 * @version 2017-07-20
 */
@Service
@Transactional(readOnly = true)
public class MeUserService extends CrudService<MeUserDao, MeUser> {

	public MeUser get(String id) {
		return super.get(id);
	}
	
	public List<MeUser> findList(MeUser meUser) {
		return super.findList(meUser);
	}
	
	public Page<MeUser> findPage(Page<MeUser> page, MeUser meUser) {
		return super.findPage(page, meUser);
	}
	
	@Transactional(readOnly = false)
	public void save(MeUser meUser) {
		super.save(meUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(MeUser meUser) {
		super.delete(meUser);
	}
	
}