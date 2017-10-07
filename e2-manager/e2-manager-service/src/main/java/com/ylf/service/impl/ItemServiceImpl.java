package com.ylf.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylf.easyuiresult.EasyUIDataGridResult;
import com.ylf.mapper.TbItemDescMapper;
import com.ylf.mapper.TbItemMapper;
import com.ylf.pojo.TbItem;
import com.ylf.pojo.TbItemDesc;
import com.ylf.pojo.TbItemExample;
import com.ylf.service.ItemService;
import com.ylf.utils.E2Result;
import com.ylf.utils.IDUtils;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
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
	
	/**
	 * 保存订单信息
	 */
	@Override
	public E2Result save(TbItem item, String desc) {
		//创建itemid
		Long itemId = IDUtils.genItemId();
		item.setId(itemId);
		//商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		//设置创建时间和更新时间
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		//保存订单数据
		itemMapper.insert(item);
		//创建商品描述信息
		TbItemDesc tbItemDesc = new TbItemDesc();
		//设置属性信息
		tbItemDesc.setItemId(itemId);
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setCreated(date);
		tbItemDesc.setUpdated(date);
		itemDescMapper.insert(tbItemDesc);
		return E2Result.ok();
	}

	@Override
	public TbItemDesc getDescByItemId(Long itemId) {
		TbItemDesc desc = itemDescMapper.selectByPrimaryKey(itemId);
		return desc;
	}

	@Override
	public TbItem getItemByItemId(Long itemId) {
		TbItemExample example = new TbItemExample();
		com.ylf.pojo.TbItemExample.Criteria createCriteria = example.createCriteria();
		List<TbItem> items = itemMapper.selectByExample(example);
		if(items!=null&&items.size()!=0) {
			return items.get(0);
		}
		return null;
	}

	@Override
	public E2Result updateItemStatus(String ids, Byte status) {
		String[] newIds = null;
		TbItem item = null;
		if(ids!=null&&!ids.equals("")) {
			item = new TbItem();
			if(ids.contains(",")) {
				newIds = ids.split(",");
				for (int j = 0; j < newIds.length; j++) {
					item.setId(Long.parseLong(newIds[j]));
					item.setStatus(status);
					//更新操作
					itemMapper.updateByPrimaryKeySelective(item);
				}
			}else {
				item.setId(Long.parseLong(ids));
				item.setStatus(status);
				//更新操作
				itemMapper.updateByPrimaryKeySelective(item);
			}
		}
		return E2Result.ok();
	}

	@Override
	public E2Result updateItem(TbItem item, String desc) {
		
		//设置创建时间和更新时间
		Date date = new Date();
		item.setUpdated(date);
		//保存订单数据
		itemMapper.updateByPrimaryKey(item);
		//创建商品描述信息
		TbItemDesc tbItemDesc = new TbItemDesc();
		//设置属性信息
		tbItemDesc.setItemId(item.getId());
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setUpdated(date);
		itemDescMapper.updateByPrimaryKeyWithBLOBs(tbItemDesc);
		return E2Result.ok();
	}
}
