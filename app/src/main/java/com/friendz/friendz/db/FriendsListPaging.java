package com.friendz.friendz.db;

import io.realm.RealmObject;

public class FriendsListPaging extends RealmObject{
	private FriendsListCursors cursors;

	public void setCursors(FriendsListCursors cursors){
		this.cursors = cursors;
	}

	public FriendsListCursors getCursors(){
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

