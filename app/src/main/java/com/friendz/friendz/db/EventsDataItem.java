package com.friendz.friendz.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class EventsDataItem extends RealmObject{
	private String startTime;
	private String rsvpStatus;
	private String endTime;
	private String name;
	private String description;
	private EventsPlace place;
	@PrimaryKey
	private String id;

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}

	public String getStartTime(){
		return startTime;
	}

	public void setRsvpStatus(String rsvpStatus){
		this.rsvpStatus = rsvpStatus;
	}

	public String getRsvpStatus(){
		return rsvpStatus;
	}

	public void setEndTime(String endTime){
		this.endTime = endTime;
	}

	public String getEndTime(){
		return endTime;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setPlace(EventsPlace place){
		this.place = place;
	}

	public EventsPlace getPlace(){
		return place;
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
			"InstaDataItem{" +
			"start_time = '" + startTime + '\'' + 
			",rsvp_status = '" + rsvpStatus + '\'' + 
			",end_time = '" + endTime + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",place = '" + place + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
