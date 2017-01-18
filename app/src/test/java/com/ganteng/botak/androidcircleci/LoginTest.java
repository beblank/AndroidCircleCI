package com.ganteng.botak.androidcircleci;

import com.ganteng.botak.androidcircleci.login.LoginActivityMVP;
import com.ganteng.botak.androidcircleci.login.LoginActivityPresenter;
import com.ganteng.botak.androidcircleci.login.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;


import org.junit.Before;
import org.junit.Test;

/**
 * Created by adityahadiwijaya on 1/18/17.
 */

public class LoginTest {
    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockLoginView;
    LoginActivityMVP.Presenter presenter;
    User user;

    @Before
    public void setup(){
        mockLoginModel = mock(LoginActivityMVP.Model.class);
        mockLoginView = mock(LoginActivityMVP.View.class);
        presenter = new LoginActivityPresenter(mockLoginModel);
        presenter.setView(mockLoginView);
    }

    @Test
    public void noInteractionWithView(){
        presenter.getCurrentUser();
        verifyZeroInteractions(mockLoginView);
    }


}
