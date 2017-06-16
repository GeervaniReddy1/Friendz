package com.friendz.friendz.db;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.Ignore;

public class Posts extends RealmObject {
	private RealmList<PostsDataItem> data;
	@Ignore
	private PostsPaging paging;

	public void setData(RealmList<PostsDataItem> data){
		this.data = data;
	}

	public RealmList<PostsDataItem> getData(){
		return data;
	}

	public void setPaging(PostsPaging paging){
		this.paging = paging;
	}

	public PostsPaging getPaging(){
		return paging;
	}

	@Override
 	public String toString(){
		return 
			"Posts{" + 
			"data = '" + data + '\'' + 
			",paging = '" + paging + '\'' + 
			"}";
		}
}