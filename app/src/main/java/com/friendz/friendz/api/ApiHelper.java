package com.friendz.friendz.api;

import com.friendz.friendz.db.InstagramMediaResponse;
import com.friendz.friendz.request.FbMessageReq;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dineshkumarbalasubramanian on 24/06/17.
 */

public class ApiHelper {
private static final String BASE_URL="https://api.instagram.com/v1/";

    public Call<InstagramMediaResponse> getInstagramData(String accessToken){
        return getRetrofit().create(FriendsApi.class).getInstagramData(accessToken);
    }
    public Call<Object> sendMessage(String url,FbMessageReq req){
        return getRetrofit().create(FriendsApi.class).sendFbMessage(url, req);
    }

    Retrofit getRetrofit(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
