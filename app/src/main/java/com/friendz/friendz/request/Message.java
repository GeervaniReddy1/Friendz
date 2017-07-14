package com.friendz.friendz.request;

public class Message{
	private String text;

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"Message{" + 
			"text = '" + text + '\'' + 
			"}";
		}
}
