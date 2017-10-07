package com.ylf.service;

import com.ylf.easyuiresult.EasyUIDataGridResult;
import com.ylf.pojo.TbItem;
import com.ylf.pojo.TbItemDesc;
import com.ylf.utils.E2Result;

public interface ItemService {
	TbItem getItemById(Long id);
	
	EasyUIDataGridResult getItemList(int page,int rows);

	E2Result save(TbItem item, String desc);

	TbItemDesc getDescByItemId(Long itemId);

	TbItem getItemByItemId(Long itemId);

	E2Result updateItemStatus(String ids, Byte status);

	E2Result updateItem(TbItem item, String desc);
}
