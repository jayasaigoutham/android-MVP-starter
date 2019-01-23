package com.jayasai.starter.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jayasai.starter.R;
import com.jayasai.starter.Service.Implementation.UserService;
import com.jayasai.starter.Service.Model.User;

public class MainActivity extends AppCompatActivity implements HomeView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomePresenter homePresenter = new HomePresenter(this, new UserService(), new HomeInteractor());
    }

    @Override
    public void showResult(User user) {
        //Popluate list
    }

    @Override
    public void showError() {
        //Show Toast
    }
}
