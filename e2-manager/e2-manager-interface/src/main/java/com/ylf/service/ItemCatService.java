package com.ylf.service;

import java.util.List;

import com.ylf.easyuiresult.TreeNode;
import com.ylf.pojo.TbItem;
import com.ylf.utils.E2Result;

public interface ItemCatService {
	List<TreeNode> getItemCatList(Long parentId);

}
