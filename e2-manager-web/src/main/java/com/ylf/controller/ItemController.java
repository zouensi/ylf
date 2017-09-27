package com.ylf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylf.easyuiresult.EasyUIDataGridResult;
import com.ylf.pojo.TbItem;
import com.ylf.service.ItemService;


@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(int page,int rows) {
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
}
