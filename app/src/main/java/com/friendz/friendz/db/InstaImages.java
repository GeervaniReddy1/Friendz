package com.friendz.friendz.db;

public class InstaImages {
	private InstaThumbnail thumbnail;
	private InstaLowResolution lowResolution;
	private InstaStandardResolution standardResolution;

	public void setThumbnail(InstaThumbnail thumbnail){
		this.thumbnail = thumbnail;
	}

	public InstaThumbnail getThumbnail(){
		return thumbnail;
	}

	public void setLowResolution(InstaLowResolution lowResolution){
		this.lowResolution = lowResolution;
	}

	public InstaLowResolution getLowResolution(){
		return lowResolution;
	}

	public void setStandardResolution(InstaStandardResolution standardResolution){
		this.standardResolution = standardResolution;
	}

	public InstaStandardResolution getStandardResolution(){
		return standardResolution;
	}

	@Override
 	public String toString(){
		return 
			"InstaImages{" +
			"thumbnail = '" + thumbnail + '\'' + 
			",low_resolution = '" + lowResolution + '\'' + 
			",standard_resolution = '" + standardResolution + '\'' + 
			"}";
		}
}
