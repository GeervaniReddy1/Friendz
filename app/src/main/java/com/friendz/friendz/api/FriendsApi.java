package com.friendz.friendz.api;

import com.friendz.friendz.db.InstagramMediaResponse;
import com.friendz.friendz.request.FbMessageReq;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by dineshkumarbalasubramanian on 24/06/17.
 */

public interface FriendsApi {

    @GET("users/self/media/recent")
     Call<InstagramMediaResponse> getInstagramData(@Query("access_token") String accessToken);

    @POST
    Call<Object> sendFbMessage(@Url String url, @Body FbMessageReq req);
}
