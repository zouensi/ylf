package com.ylf.easyuiresult;

import java.io.Serializable;
/**
 * 已部树空间返回对象
 * @author DELL
 *
 */
public class TreeNode implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String text;
	//是父类节点closed,不是父类节点open
	private String state;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
