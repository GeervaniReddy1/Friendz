package com.friendz.friendz.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ProfileData extends RealmObject {
	private String last_name;
	@PrimaryKey
	private String id;
	private String first_name;

	public void setLastName(String lastName){
		this.last_name = lastName;
	}

	public String getLastName(){
		return last_name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setFirstName(String firstName){
		this.first_name = firstName;
	}

	public String getFirstName(){
		return first_name;
	}

	@Override
 	public String toString(){
		return 
			"ProfileData{" + 
			"last_name = '" +last_name+ '\'' +
			",id = '" + id + '\'' + 
			",first_name = '" + first_name + '\'' +
			"}";
		}
}
