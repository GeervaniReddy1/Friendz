package com.friendz.friendz.model;

import java.util.List;

public class FriendsResponse{
	private List<DataItem> data;
	private Paging paging;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setPaging(Paging paging){
		this.paging = paging;
	}

	public Paging getPaging(){
		return paging;
	}

	@Override
 	public String toString(){
		return 
			"FriendsResponse{" + 
			"data = '" + data + '\'' + 
			",paging = '" + paging + '\'' + 
			"}";
		}
}