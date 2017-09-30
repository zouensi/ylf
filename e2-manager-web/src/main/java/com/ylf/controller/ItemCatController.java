package com.ylf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylf.easyuiresult.TreeNode;
import com.ylf.service.ItemCatService;

@Controller
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/itemCat/list")
	@ResponseBody
	public List<TreeNode> getItemCatList(@RequestParam(value="id",required=true,defaultValue="0") Long parentId ) {
		List<TreeNode> itemCatList = itemCatService.getItemCatList(parentId);
		return itemCatList;
	}
	
}
