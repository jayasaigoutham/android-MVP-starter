package com.jayasai.starter.Home;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayasai.starter.Base.BaseInteractor;
import com.jayasai.starter.Service.Implementation.UserService;
import com.jayasai.starter.Service.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeInteractor extends BaseInteractor {

    interface OnHomeListener {
        void fetchSuccess(User result);
        void showFailure();
    }

    public void fetchUsers(UserService service, final OnHomeListener listener)
    {
        GsonBuilder gsonb = new GsonBuilder();
        final Gson gson = gsonb.create();

        service.getAPI().getResults().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User data = response.body();

                if (data != null) {
                    User result = gson.fromJson(data.toString(), User.class);
                    listener.fetchSuccess(result);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listener.showFailure();
            }
        });
    }

}
