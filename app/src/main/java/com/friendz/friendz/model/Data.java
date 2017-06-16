package com.friendz.friendz.model;

public class Data{
	private boolean isSilhouette;
	private String url;

	public void setIsSilhouette(boolean isSilhouette){
		this.isSilhouette = isSilhouette;
	}

	public boolean isIsSilhouette(){
		return isSilhouette;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"is_silhouette = '" + isSilhouette + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}
