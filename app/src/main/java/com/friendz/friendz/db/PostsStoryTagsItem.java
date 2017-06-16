package com.friendz.friendz.db;

import io.realm.RealmObject;

public class PostsStoryTagsItem extends RealmObject{
	private int offset;
	private String name;
	private int length;
	private String id;
	private String type;

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLength(int length){
		this.length = length;
	}

	public int getLength(){
		return length;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"PostsStoryTagsItem{" +
			"offset = '" + offset + '\'' + 
			",name = '" + name + '\'' + 
			",length = '" + length + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}
