package com.friendz.friendz.db;

import io.realm.RealmObject;

public class FriendsListSummary extends RealmObject{
	private int totalCount;

	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
	}

	public int getTotalCount(){
		return totalCount;
	}

	@Override
 	public String toString(){
		return 
			"Summary{" + 
			"total_count = '" + totalCount + '\'' + 
			"}";
		}
}
