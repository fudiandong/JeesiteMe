/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.concacts.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.me.entity.MeUser;
import com.thinkgem.jeesite.modules.sys.entity.AppResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.concacts.entity.MeContacts;
import com.thinkgem.jeesite.modules.concacts.service.MeContactsService;

import java.util.Map;

/**
 * 联系人模块Controller
 * @author fudiandong
 * @version 2017-07-25
 */
@Controller
@RequestMapping(value = "${adminPath}/concacts/meContacts")
public class MeContactsController extends BaseController {

	@Autowired
	private MeContactsService meContactsService;
	
	@ModelAttribute
	public MeContacts get(@RequestParam(required=false) String id) {
		MeContacts entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = meContactsService.get(id);
		}
		if (entity == null){
			entity = new MeContacts();
		}
		return entity;
	}
	
	@RequiresPermissions("concacts:meContacts:view")
	@RequestMapping(value = {"list", ""})
	public String list(MeContacts meContacts, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MeContacts> page = meContactsService.findPage(new Page<MeContacts>(request, response), meContacts); 
		model.addAttribute("page", page);
		return "modules/concacts/meContactsList";
	}

	@RequiresPermissions("concacts:meContacts:view")
	@RequestMapping(value = "form")
	public String form(MeContacts meContacts, Model model) {
		model.addAttribute("meContacts", meContacts);
		return "modules/concacts/meContactsForm";
	}

	@RequiresPermissions("concacts:meContacts:edit")
	@RequestMapping(value = "save")
	public String save(MeContacts meContacts, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, meContacts)){
			return form(meContacts, model);
		}
		meContactsService.save(meContacts);
		addMessage(redirectAttributes, "保存联系人成功");
		return "redirect:"+Global.getAdminPath()+"/concacts/meContacts/?repage";
	}
	
	@RequiresPermissions("concacts:meContacts:edit")
	@RequestMapping(value = "delete")
	public String delete(MeContacts meContacts, RedirectAttributes redirectAttributes) {
		meContactsService.delete(meContacts);
		addMessage(redirectAttributes, "删除联系人成功");
		return "redirect:"+Global.getAdminPath()+"/concacts/meContacts/?repage";
	}

	@RequiresPermissions("concacts:meContacts:view")
	@ResponseBody
	@RequestMapping(value = {"app_contactslist"})
	public Map<String, Object> app_contactslist(MeContacts meContacts, HttpServletRequest request, HttpServletResponse response, Model model) {
		Map<String, Object> r = null;
		try {
			r = AppResult.appSuccessResult(meContactsService.app_contactslist(
					new Page<MeContacts>(request, response), meContacts));
			AppResult.setPageInfo(r, meContacts.getPage());
		} catch (Exception e) {
			e.printStackTrace();
			r = AppResult.appErrorResult("-1", "获取联系人列表失败");
		}
		return r;
	}

}