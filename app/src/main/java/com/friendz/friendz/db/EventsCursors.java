package com.friendz.friendz.db;

import io.realm.RealmObject;

public class EventsCursors extends RealmObject{
	private String before;
	private String after;

	public void setBefore(String before){
		this.before = before;
	}

	public String getBefore(){
		return before;
	}

	public void setAfter(String after){
		this.after = after;
	}

	public String getAfter(){
		return after;
	}

	@Override
 	public String toString(){
		return 
			"Cursors{" + 
			"before = '" + before + '\'' + 
			",after = '" + after + '\'' + 
			"}";
		}
}
