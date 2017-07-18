package com.friendz.friendz.db;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PostsDataItem extends RealmObject {
    private String createdTime;
    private String updatedTime;
    private boolean isPublished;
    private String statusType;
    private String icon;
    private boolean isHidden;
    private String link;
    private String caption;
    private PostsPrivacy privacy;
    private String type;
    private String picture;
    private String source;
    private PostsShares shares;
    private String instagramEligibility;
    private RealmList<PostsStoryTagsItem> storyTags;
    private String name;
    private boolean isInstagramEligible;
    private PostsFrom from;
    @PrimaryKey
    private String id;
    private String permalinkUrl;
    private FbLikes likes;
    private FbComments comments;
    private String story;

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setIsPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public boolean isIsPublished() {
        return isPublished;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public boolean isIsHidden() {
        return isHidden;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public void setPrivacy(PostsPrivacy privacy) {
        this.privacy = privacy;
    }

    public PostsPrivacy getPrivacy() {
        return privacy;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setShares(PostsShares shares) {
        this.shares = shares;
    }

    public PostsShares getShares() {
        return shares;
    }

    public void setInstagramEligibility(String instagramEligibility) {
        this.instagramEligibility = instagramEligibility;
    }

    public String getInstagramEligibility() {
        return instagramEligibility;
    }

    public void setStoryTags(RealmList<PostsStoryTagsItem> storyTags) {
        this.storyTags = storyTags;
    }

    public RealmList<PostsStoryTagsItem> getStoryTags() {
        return storyTags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIsInstagramEligible(boolean isInstagramEligible) {
        this.isInstagramEligible = isInstagramEligible;
    }

    public boolean isIsInstagramEligible() {
        return isInstagramEligible;
    }

    public void setFrom(PostsFrom from) {
        this.from = from;
    }

    public PostsFrom getFrom() {
        return from;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPermalinkUrl(String permalinkUrl) {
        this.permalinkUrl = permalinkUrl;
    }

    public String getPermalinkUrl() {
        return permalinkUrl;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getStory() {
        return story;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public FbLikes getLikes() {
        return likes;
    }

    public void setLikes(FbLikes likes) {
        this.likes = likes;
    }

    public FbComments getComments() {
        return comments;
    }

    public void setComments(FbComments comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return
                "PostsDataItem{" +
                        "created_time = '" + createdTime + '\'' +
                        ",updated_time = '" + updatedTime + '\'' +
                        ",is_published = '" + isPublished + '\'' +
                        ",status_type = '" + statusType + '\'' +
                        ",icon = '" + icon + '\'' +
                        ",is_hidden = '" + isHidden + '\'' +
                        ",link = '" + link + '\'' +
                        ",caption = '" + caption + '\'' +
                        ",privacy = '" + privacy + '\'' +
                        ",type = '" + type + '\'' +
                        ",picture = '" + picture + '\'' +
                        ",shares = '" + shares + '\'' +
                        ",instagram_eligibility = '" + instagramEligibility + '\'' +
                        ",story_tags = '" + storyTags + '\'' +
                        ",name = '" + name + '\'' +
                        ",is_instagram_eligible = '" + isInstagramEligible + '\'' +
                        ",from = '" + from + '\'' +
                        ",id = '" + id + '\'' +
                        ",permalink_url = '" + permalinkUrl + '\'' +
                        ",story = '" + story + '\'' +
                        "}";
    }
}