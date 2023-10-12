package com.example.youtubeclone.api;

import com.example.youtubeclone.model.Resultado;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeService {
    /*
    search parameters
    https://www.googleapis.com/youtube/v3/
    search
    ?part=snippet
    &order=date
    &maxResults=10
    &key=AIzaSyAmtKuRZzYbZ7YjduQRrUYDZ2pYJLJ8ee8
    &channelId=@TheOffice

    https://www.googleapis.com/youtube/v3/search?part=snippet&order=date&maxResults=10&key=AIzaSyAmtKuRZzYbZ7YjduQRrUYDZ2pYJLJ8ee8&channelId=@TheOffice
     */

    @GET("search")
    Call<Resultado> recuperarVideos(@Query("part") String part,
                                    @Query("order") String order,
                                    @Query("maxResults") String maxResults,
                                    @Query("key")  String key,
                                    @Query("order") String channelId
    );
}
