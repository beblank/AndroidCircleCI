package com.ganteng.botak.androidcircleci.login;

import com.ganteng.botak.androidcircleci.login.model.User;

/**
 * Created by adityahadiwijaya on 1/17/17.
 */

public interface LoginActivityMVP {

    interface View{

        String getUserName();
        String getPassword();

        void showUserNotAvailable();
        void showInputError();
        void showUserSavedMessage();

        void setUsername(String uname);
        void setPassword(String pass);

    }

    interface Presenter{
        void setView(LoginActivityMVP.View view);

        void loginButtonClicked();

        void getCurrentUser();

        void saveUser();
    }

    interface Model{
        void createUser(String uname, String pass);

        User getUser();
    }


}
