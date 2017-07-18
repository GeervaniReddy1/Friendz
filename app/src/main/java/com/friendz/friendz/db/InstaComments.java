package com.friendz.friendz.db;

public class InstaComments {
	private int count;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	@Override
 	public String toString(){
		return 
			"Comments{" + 
			"count = '" + count + '\'' + 
			"}";
		}
}
