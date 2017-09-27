package com.ylf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 展示后台页面controller
 * @author DELL
 */
@Controller
public class PageController {
	/**
	 * 展示后台首页
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	/**
	 * 展示tree对应的具体内容
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
}
