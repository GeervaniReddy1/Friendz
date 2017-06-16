package com.friendz.friendz.model;

public class DataItem{
	private String name;
	private String id;
	private Picture picture;

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

	public void setPicture(Picture picture){
		this.picture = picture;
	}

	public Picture getPicture(){
		return picture;
	}

	@Override
 	public String toString(){
		return 
			"PostsDataItem{" +
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",picture = '" + picture + '\'' + 
			"}";
		}
}
