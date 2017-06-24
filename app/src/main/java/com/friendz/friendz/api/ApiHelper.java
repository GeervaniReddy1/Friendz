package com.friendz.friendz.api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dineshkumarbalasubramanian on 24/06/17.
 */

public class ApiHelper {
private static final String BASE_URL="http://samples.openweathermap.org";

    public Call<Object> getWeather(String q, String appid){
        return getRetrofit().create(WeatherAPI.class).getWeather(q,appid);
    }

    Retrofit getRetrofit(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
