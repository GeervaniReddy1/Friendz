package com.friendz.friendz.db;

import java.util.List;

public class InstaDataItem {
	private String createdTime;
	private InstaImages images;
	private InstaComments comments;
	private List<Object> usersInPhoto;
	private String link;
	private InstaCaption caption;
	private String type;
	private List<String> tags;
	private String filter;
	private InstaLocation location;
	private String id;
	private InstaUser user;
	private InstaLikes likes;

	public void setCreatedTime(String createdTime){
		this.createdTime = createdTime;
	}

	public String getCreatedTime(){
		return createdTime;
	}

	public void setImages(InstaImages images){
		this.images = images;
	}

	public InstaImages getImages(){
		return images;
	}

	public void setComments(InstaComments comments){
		this.comments = comments;
	}

	public InstaComments getComments(){
		return comments;
	}

	public void setUsersInPhoto(List<Object> usersInPhoto){
		this.usersInPhoto = usersInPhoto;
	}

	public List<Object> getUsersInPhoto(){
		return usersInPhoto;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setCaption(InstaCaption caption){
		this.caption = caption;
	}

	public InstaCaption getCaption(){
		return caption;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	public void setFilter(String filter){
		this.filter = filter;
	}

	public String getFilter(){
		return filter;
	}

	public void setLocation(InstaLocation location){
		this.location = location;
	}

	public InstaLocation getLocation(){
		return location;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUser(InstaUser user){
		this.user = user;
	}

	public InstaUser getUser(){
		return user;
	}

	public void setLikes(InstaLikes likes){
		this.likes = likes;
	}

	public InstaLikes getLikes(){
		return likes;
	}

	@Override
 	public String toString(){
		return 
			"InstaDataItem{" +
			"created_time = '" + createdTime + '\'' + 
			",images = '" + images + '\'' + 
			",comments = '" + comments + '\'' + 
			",users_in_photo = '" + usersInPhoto + '\'' + 
			",link = '" + link + '\'' + 
			",caption = '" + caption + '\'' + 
			",type = '" + type + '\'' + 
			",tags = '" + tags + '\'' + 
			",filter = '" + filter + '\'' + 
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' + 
			",user = '" + user + '\'' + 
			",likes = '" + likes + '\'' + 
			"}";
		}
}