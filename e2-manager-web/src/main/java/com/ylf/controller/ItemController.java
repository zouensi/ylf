package com.ylf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylf.easyuiresult.EasyUIDataGridResult;
import com.ylf.pojo.TbItem;
import com.ylf.pojo.TbItemDesc;
import com.ylf.service.ItemService;
import com.ylf.utils.E2Result;
import com.ylf.utils.JsonUtils;

/**
 * 商品controller
 * @author DELL
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	/**
	 * Restful模式
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	/**
	 * 获取商品分页列表
	 * @param page 当前页数
	 * @param rows 展示行数
	 * @return
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(int page,int rows) {
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	
	/**
	 * 保存订单信息
	 * @param item 商品信息
	 * @param desc 商品描述
	 * @return
	 */
	@RequestMapping("/item/save")
	@ResponseBody
	public E2Result save(TbItem item,String desc) {//有问题，返回为什么不能为Sting
		E2Result e2Result =  itemService.save(item,desc);
		return e2Result;
	}
	
	@RequestMapping("/rest/page/item-edit")
	@ResponseBody
	public E2Result itemEdit() {
		return new E2Result().ok();
	}
	
	/**
	 * 加载商品描述
	 */
	@RequestMapping("/rest/item/query/item/desc/{id}")
	@ResponseBody
	public E2Result getDescByItemId(@PathVariable("id") Long itemId) {
		TbItemDesc desc = itemService.getDescByItemId(itemId);
		E2Result result = new E2Result(desc);
		return result;
	}
	
	/**
	 * 加载商品信息
	 */
	@RequestMapping("/item/query/{id}")
	@ResponseBody
	public E2Result getItemByItemId(@PathVariable("id") Long itemId) {
		TbItem item = itemService.getItemByItemId(itemId);
		E2Result result = new E2Result(item);
		return result;
	}
}
