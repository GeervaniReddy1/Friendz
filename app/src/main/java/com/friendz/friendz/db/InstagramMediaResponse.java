package com.friendz.friendz.db;

import java.util.List;

public class InstagramMediaResponse{
	private List<InstaDataItem> data;

	public void setData(List<InstaDataItem> data){
		this.data = data;
	}

	public List<InstaDataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"InstagramMediaResponse{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}