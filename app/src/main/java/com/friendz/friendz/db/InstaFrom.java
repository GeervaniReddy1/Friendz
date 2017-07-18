package com.friendz.friendz.db;

public class InstaFrom {
	private String fullName;
	private String id;
	private String type;
	private String username;

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
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

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"InstaFrom{" +
			"full_name = '" + fullName + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}
