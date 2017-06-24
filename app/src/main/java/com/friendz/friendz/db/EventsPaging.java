package com.friendz.friendz.db;



import io.realm.RealmObject;

public class EventsPaging extends RealmObject{
	private EventsCursors cursors;

	public void setCursors(EventsCursors cursors){
		this.cursors = cursors;
	}

	public EventsCursors getCursors(){
		return cursors;
	}

	@Override
 	public String toString(){
		return 
			"EventsPaging{" +
			"cursors = '" + cursors + '\'' + 
			"}";
		}
}
