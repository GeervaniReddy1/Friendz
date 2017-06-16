package com.friendz.friendz.db;

import io.realm.RealmObject;

public class PostsShares extends RealmObject{
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
			"PostsShares{" +
			"count = '" + count + '\'' + 
			"}";
		}
}
