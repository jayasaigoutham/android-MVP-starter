package com.jayasai.starter.Service.Implementation;

import com.jayasai.starter.Service.Contracts.UserAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UserService {
    private Retrofit retrofit = null;


    /**
     * This method creates a new instance of the API interface.
     * @return
     */
    public UserAPI getAPI() {
        String BASE_URL = "http://services.jayasai.com/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(UserAPI.class);
    }
}
