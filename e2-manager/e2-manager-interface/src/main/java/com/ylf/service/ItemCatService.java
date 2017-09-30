package com.ylf.service;

import java.util.List;

import com.ylf.easyuiresult.TreeNode;

public interface ItemCatService {
	List<TreeNode> getItemCatList(Long parentId);
}
