package com.ylf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylf.easyuiresult.EasyUIDataGridResult;
import com.ylf.pojo.TbItem;
import com.ylf.pojo.TbItemDesc;
import com.ylf.service.ItemCatParamService;
import com.ylf.service.ItemService;
import com.ylf.utils.E2Result;

/**
 * 商品controller
 * @author DELL
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemCatParamService itemCatParamService;
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
	
	/**
	 * 获取修改页面
	 * @return
	 */
	@RequestMapping("/rest/page/item-edit")
	public String  itemEdit() {
		return "item-edit";
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
	@RequestMapping("/rest/item/param/item/query/{id}")
	@ResponseBody
	public E2Result getItemCatParamByItemId(@PathVariable("id") Long itemId) {
		E2Result result = itemCatParamService.getItemCatParam(itemId);
		return result;
	}
	
	
	/**
	 * 删除商品
	 * @param ids
	 * @return
	 */
	@RequestMapping("/item/delete")
	@ResponseBody
	public E2Result deleteItem(@RequestParam String ids) {
		//商品状态，1-正常，2-下架，3-删除
		E2Result result = itemService.updateItemStatus(ids,(byte)3);
		return result;
	}
	
	/**
	 * 下架
	 * @param ids
	 * @return
	 */
	@RequestMapping("/item/instock")
	@ResponseBody
	public E2Result instock(@RequestParam String ids) {
		//商品状态，1-正常，2-下架，3-删除
		E2Result result = itemService.updateItemStatus(ids,(byte)2);
		return result;
	}
	
	/**
	 * 上架
	 * @param ids
	 * @return
	 */
	@RequestMapping("/item/reshelf")
	@ResponseBody
	public E2Result reshelf(@RequestParam String ids) {
		//商品状态，1-正常，2-下架，3-删除
		E2Result result = itemService.updateItemStatus(ids,(byte)1);
		return result;
	}
	@RequestMapping("/item/update")
	@ResponseBody
	public E2Result updateItem(TbItem item,String desc) {
		E2Result result = itemService.updateItem(item, desc);
		return result;
	}
}
