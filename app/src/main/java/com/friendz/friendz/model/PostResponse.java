package com.friendz.friendz.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostResponse{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("paging")
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
			"PostResponse{" + 
			"data = '" + data + '\'' + 
			",paging = '" + paging + '\'' + 
			"}";
		}
}