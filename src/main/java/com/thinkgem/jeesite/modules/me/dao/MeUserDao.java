/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.me.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.me.entity.MeUser;

import java.util.List;

/**
 * user信息DAO接口
 * @author fudiandong
 * @version 2017-07-20
 */
@MyBatisDao
public interface MeUserDao extends CrudDao<MeUser> {
//    List<MeUser> findList(MeUser meUser);
}