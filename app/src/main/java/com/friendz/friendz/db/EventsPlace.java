package com.friendz.friendz.db;

import io.realm.RealmObject;

public class EventsPlace extends RealmObject{
	private String name;
	private EventsLocation location;
	private String id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(EventsLocation location){
		this.location = location;
	}

	public EventsLocation getLocation(){
		return location;
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
			"EventsPlace{" +
			"name = '" + name + '\'' + 
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
