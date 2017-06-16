package com.friendz.friendz.model;

public class Picture{
	private Data data;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"Picture{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}
