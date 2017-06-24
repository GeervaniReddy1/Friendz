package com.friendz.friendz.api;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dineshkumarbalasubramanian on 24/06/17.
 */

public interface WeatherAPI {

    @GET("/data/2.5/forecast")
     Call<Object> getWeather(@Query("q") String query,@Query("appid")String appId);
}
