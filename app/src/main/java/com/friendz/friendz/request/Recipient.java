package com.friendz.friendz.request;

public class Recipient{
	private String id;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Recipient{" + 
			"id = '" + id + '\'' + 
			"}";
		}
}
