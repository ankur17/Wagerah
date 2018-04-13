package com.wagerah;

import com.wagerah.model.Authorise;
import com.wagerah.model.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;

/**
 * Created by ankurharna on 07/04/18.
 */

public interface UberClient {
    @GET("me")
    Call<User> getUser(
            @HeaderMap Map<String,String> header
    );

    @GET("token")
    Call<Authorise> getMe(
            @HeaderMap Map<String,String> header
    );


}
