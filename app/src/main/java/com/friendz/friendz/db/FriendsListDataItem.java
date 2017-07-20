package com.friendz.friendz.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FriendsListDataItem extends RealmObject{
	private String name;
	@PrimaryKey
	private String id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return
			"InstaDataItem{" +
			"name = '" + name + '\'' +
			",id = '" + id + '\'' + 
			"}";
		}
}
