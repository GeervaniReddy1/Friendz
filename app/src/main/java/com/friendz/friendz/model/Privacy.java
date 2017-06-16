package com.friendz.friendz.model;

import com.google.gson.annotations.SerializedName;

public class Privacy{

	@SerializedName("allow")
	private String allow;

	@SerializedName("deny")
	private String deny;

	@SerializedName("description")
	private String description;

	@SerializedName("value")
	private String value;

	@SerializedName("friends")
	private String friends;

	public void setAllow(String allow){
		this.allow = allow;
	}

	public String getAllow(){
		return allow;
	}

	public void setDeny(String deny){
		this.deny = deny;
	}

	public String getDeny(){
		return deny;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public void setFriends(String friends){
		this.friends = friends;
	}

	public String getFriends(){
		return friends;
	}

	@Override
 	public String toString(){
		return 
			"PostsPrivacy{" +
			"allow = '" + allow + '\'' + 
			",deny = '" + deny + '\'' + 
			",description = '" + description + '\'' + 
			",value = '" + value + '\'' + 
			",friends = '" + friends + '\'' + 
			"}";
		}
}