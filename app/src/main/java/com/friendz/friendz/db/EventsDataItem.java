package com.friendz.friendz.db;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class EventsDataItem extends RealmObject{
	private Date start_time;
	private String rsvpStatus;
	private String endTime;
	private String name;
	private String description;
	private EventsPlace place;
	@PrimaryKey
	private String id;

	public void setStartTime(Date startTime){
		this.start_time = startTime;
	}

	public Date getStartTime(){
		return start_time;
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
			"start_time = '" + start_time + '\'' +
			",rsvp_status = '" + rsvpStatus + '\'' + 
			",end_time = '" + endTime + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",place = '" + place + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
