/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.me.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.thinkgem.jeesite.modules.me.entity.MeUser;
import com.thinkgem.jeesite.modules.me.service.MeUserService;

import java.util.Map;

/**
 * user信息Controller
 * @author fudiandong
 * @version 2017-07-20
 */
@Controller
@RequestMapping(value = "${adminPath}/me/meUser")
public class MeUserController extends BaseController {

	@Autowired
	private MeUserService meUserService;
	
	@ModelAttribute
	public MeUser get(@RequestParam(required=false) String id) {
		MeUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = meUserService.get(id);
		}
		if (entity == null){
			entity = new MeUser();
		}
		return entity;
	}
	
	@RequiresPermissions("me:meUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(MeUser meUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MeUser> page = meUserService.findPage(new Page<MeUser>(request, response), meUser); 
		model.addAttribute("page", page);
		return "modules/me/meUserList";
	}

	@RequiresPermissions("me:meUser:view")
	@RequestMapping(value = "form")
	public String form(MeUser meUser, Model model) {
		model.addAttribute("meUser", meUser);
		return "modules/me/meUserForm";
	}

	@RequiresPermissions("me:meUser:edit")
	@RequestMapping(value = "save")
	public String save(MeUser meUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, meUser)){
			return form(meUser, model);
		}
		meUserService.save(meUser);
		addMessage(redirectAttributes, "保存用户成功");
		return "redirect:"+Global.getAdminPath()+"/me/meUser/?repage";
	}
	
	@RequiresPermissions("me:meUser:edit")
	@RequestMapping(value = "delete")
	public String delete(MeUser meUser, RedirectAttributes redirectAttributes) {
		meUserService.delete(meUser);
		addMessage(redirectAttributes, "删除用户成功");
		return "redirect:"+Global.getAdminPath()+"/me/meUser/?repage";
	}

	@RequiresPermissions("me:meUser:view")
	@ResponseBody
	@RequestMapping(value = "app_myList")
	public Map<String, Object> app_myList(MeUser meUser,
										  HttpServletRequest request, HttpServletResponse response,
										  Model model) {
		Map<String, Object> r = null;
		try {
			r = AppResult.appSuccessResult(meUserService.app_myList(
					new Page<MeUser>(request, response), meUser));
			AppResult.setPageInfo(r, meUser.getPage());
		} catch (Exception e) {
			e.printStackTrace();
			r = AppResult.appErrorResult("-1", "获取用户列表失败");
		}
		return r;
	}


}