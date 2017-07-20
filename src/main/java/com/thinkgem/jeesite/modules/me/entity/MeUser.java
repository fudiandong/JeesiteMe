/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.me.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.Office;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * user信息Entity
 * @author fudiandong
 * @version 2017-07-20
 */
public class MeUser extends DataEntity<MeUser> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String sex;		// sex
	private String phone;		// phone
	private String moblie;		// moblie
	private String companyId;		// company_id
	private Office office;		// office_id
	
	public MeUser() {
		super();
	}

	public MeUser(String id){
		super(id);
	}

	@Length(min=0, max=100, message="name长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=64, message="sex长度必须介于 0 和 64 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=200, message="phone长度必须介于 0 和 200 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=200, message="moblie长度必须介于 0 和 200 之间")
	public String getMoblie() {
		return moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}
	
	@Length(min=0, max=64, message="company_id长度必须介于 0 和 64 之间")
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
}