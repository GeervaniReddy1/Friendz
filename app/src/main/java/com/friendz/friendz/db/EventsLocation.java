package com.friendz.friendz.db;

import io.realm.RealmObject;

public class EventsLocation extends RealmObject{
	private String zip;
	private String country;
	private String city;
	private String street;
	private double latitude;
	private String state;
	private double longitude;

	public void setZip(String zip){
		this.zip = zip;
	}

	public String getZip(){
		return zip;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getStreet(){
		return street;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"zip = '" + zip + '\'' + 
			",country = '" + country + '\'' + 
			",city = '" + city + '\'' + 
			",street = '" + street + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",state = '" + state + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}
