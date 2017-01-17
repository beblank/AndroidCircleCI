package com.ganteng.botak.androidcircleci.login;

import android.support.annotation.Nullable;

/**
 * Created by adityahadiwijaya on 1/17/17.
 */

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        saveUser();
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();

        if(view != null){
            if (user == null){
                view.showUserNotAvailable();
            } else {
                view.setUsername(user.getUsername());
                view.setPassword(user.getPassword());
            }
        }
    }

    @Override
    public void saveUser() {
        if (view != null){
            if (view.getUserName().trim().equals("")||view.getPassword().trim().equals("")){
                view.showInputError();
            } else {
                model.createUser(view.getUserName(), view.getPassword());
                view.showUserSavedMessage();
            }
        }
    }
}
