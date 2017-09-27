package com.ylf.service;

import com.ylf.easyuiresult.EasyUIDataGridResult;
import com.ylf.pojo.TbItem;

public interface ItemService {
	TbItem getItemById(Long id);
	
	EasyUIDataGridResult getItemList(int page,int rows);
}
