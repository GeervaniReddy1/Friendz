package com.friendz.friendz.db;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

public class FriendsList extends RealmObject{
	private FriendsListSummary summary;
	private RealmList<FriendsListDataItem> data;
	@Ignore
	private FriendsListPaging paging;

	public void setSummary(FriendsListSummary summary){
		this.summary = summary;
	}

	public FriendsListSummary getSummary(){
		return summary;
	}

	public void setData(RealmList<FriendsListDataItem> data){
		this.data = data;
	}

	public RealmList<FriendsListDataItem> getData(){
		return data;
	}

	public void setPaging(FriendsListPaging paging){
		this.paging = paging;
	}

	public FriendsListPaging getPaging(){
		return paging;
	}

	@Override
 	public String toString(){
		return 
			"FriendsList{" + 
			"summary = '" + summary + '\'' + 
			",data = '" + data + '\'' + 
			",paging = '" + paging + '\'' + 
			"}";
		}
}