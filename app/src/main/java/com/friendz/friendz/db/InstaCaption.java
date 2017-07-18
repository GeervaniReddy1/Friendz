package com.friendz.friendz.db;

public class InstaCaption {
	private String createdTime;
	private InstaFrom from;
	private String text;
	private String id;

	public void setCreatedTime(String createdTime){
		this.createdTime = createdTime;
	}

	public String getCreatedTime(){
		return createdTime;
	}

	public void setFrom(InstaFrom from){
		this.from = from;
	}

	public InstaFrom getFrom(){
		return from;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
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
			"InstaCaption{" +
			"created_time = '" + createdTime + '\'' + 
			",from = '" + from + '\'' + 
			",text = '" + text + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
