package com.friendz.friendz.model;

import com.google.gson.annotations.SerializedName;

public class StoryTagsItem{

	@SerializedName("offset")
	private int offset;

	@SerializedName("name")
	private String name;

	@SerializedName("length")
	private int length;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
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