package com.ylf.easyuiresult;

import java.io.Serializable;
import java.util.List;

/**
 * easyUi列表结果返回bean
 * @author DELL
 *
 */
public class EasyUIDataGridResult implements Serializable{
	private static final long serialVersionUID = 1L;
	//总记录数
	private Integer total;
	//获取的信息集合
	private List<?> rows;

	public EasyUIDataGridResult(Integer total, List<?> rows) {
		this.total = total;
		this.rows = rows;
	}

	public EasyUIDataGridResult(Long total, List<?> rows) {
		this.total = total.intValue();
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
