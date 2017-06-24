package com.friendz.friendz.db;



import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

public class Events extends RealmObject{
	private RealmList<EventsDataItem> data;
	@Ignore
	private EventsPaging paging;

	public void setData(RealmList<EventsDataItem> data){
		this.data = data;
	}

	public RealmList<EventsDataItem> getData(){
		return data;
	}

	public void setPaging(EventsPaging paging){
		this.paging = paging;
	}

	public EventsPaging getPaging(){
		return paging;
	}

	@Override
 	public String toString(){
		return 
			"Events{" + 
			"data = '" + data + '\'' + 
			",paging = '" + paging + '\'' + 
			"}";
		}
}