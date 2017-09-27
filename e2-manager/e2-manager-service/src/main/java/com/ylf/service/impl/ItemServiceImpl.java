package com.ylf.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylf.easyuiresult.EasyUIDataGridResult;
import com.ylf.mapper.TbItemMapper;
import com.ylf.pojo.TbItem;
import com.ylf.pojo.TbItemExample;
import com.ylf.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	
	/**
	 * 根据id获取商品信息
	 */
	@Override
	public TbItem getItemById(Long id) {
		TbItem item = itemMapper.selectByPrimaryKey(id);
		return item;
	}

	/**
	 * 获取分页信息
	 */
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample tbItemExample = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(tbItemExample);
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		//获取返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult(pageInfo.getTotal(), list);
		return result;
	}

}
