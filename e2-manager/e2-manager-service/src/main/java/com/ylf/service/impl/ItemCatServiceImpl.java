package com.ylf.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylf.easyuiresult.TreeNode;
import com.ylf.mapper.TbItemCatMapper;
import com.ylf.pojo.TbItem;
import com.ylf.pojo.TbItemCat;
import com.ylf.pojo.TbItemCatExample;
import com.ylf.pojo.TbItemCatExample.Criteria;
import com.ylf.service.ItemCatService;
import com.ylf.utils.E2Result;
import com.ylf.utils.IDUtils;
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	@Override
	public List<TreeNode> getItemCatList(Long parentId) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		//创建条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		//获取商品类型集合信息
		List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(example);
		//封装数据
		for (TbItemCat tbItemCat : tbItemCats) {
			TreeNode treeNode = new TreeNode();
			treeNode.setId(tbItemCat.getId());
			treeNode.setText(tbItemCat.getName());
			treeNode.setState(tbItemCat.getIsParent()?"closed":"open");
			result.add(treeNode);
		}
		return result;
	}


}
