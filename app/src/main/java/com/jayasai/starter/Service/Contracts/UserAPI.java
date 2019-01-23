package com.jayasai.starter.Service.Contracts;

import com.jayasai.starter.Service.Model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserAPI {

    @GET("user/get/all")
    Call<User> getResults();

    @GET("user/get/email/{email}")
    Call<User> getUserByEmail(@Path("email") String email);
}
