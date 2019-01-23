package com.jayasai.starter.Home;

import com.jayasai.starter.Base.BasePresenter;
import com.jayasai.starter.Service.Implementation.UserService;
import com.jayasai.starter.Service.Model.User;

import java.util.List;

public class HomePresenter extends BasePresenter implements  HomeInteractor.OnHomeListener{

    private  HomeView homeView;
    private UserService userService;
    private HomeInteractor homeInteractor;

    public HomePresenter(HomeView view, UserService service,  HomeInteractor interactor) {
        this.homeView = view;
        this.userService = service;
        this.homeInteractor = interactor;
    }

    public void getListOfUsers()
    {
        homeInteractor.fetchUsers(userService, this);
    }

    @Override
    public void fetchSuccess(User result) {
        homeView.showResult(result);
    }

    @Override
    public void showFailure() {
        homeView.showError();
    }
}
