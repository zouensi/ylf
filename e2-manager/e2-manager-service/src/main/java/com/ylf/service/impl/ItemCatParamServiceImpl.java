package com.ylf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylf.mapper.TbItemMapper;
import com.ylf.mapper.TbItemParamMapper;
import com.ylf.pojo.TbItem;
import com.ylf.pojo.TbItemParam;
import com.ylf.pojo.TbItemParamExample;
import com.ylf.pojo.TbItemParamExample.Criteria;
import com.ylf.service.ItemCatParamService;
import com.ylf.utils.E2Result;
@Service
public class ItemCatParamServiceImpl implements ItemCatParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	@Autowired
	private TbItemMapper itemMapper;
	/**
	 * 获取商品规格
	 */
	@Override
	public E2Result getItemCatParam(Long itemId) {
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		TbItemParamExample example = new TbItemParamExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andItemCatIdEqualTo(item.getCid());
		List<TbItemParam> itemParams = itemParamMapper.selectByExample(example);
		if(itemParams!=null&&itemParams.size()!=0) {
			return new E2Result(itemParams.get(0));
		}
		return null;
	}

}
