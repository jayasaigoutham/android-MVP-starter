package com.jayasai.starter.Home;

import com.jayasai.starter.Service.Model.User;

public interface HomeView {
    void showResult(User user);
    void showError();
}
