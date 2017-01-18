package com.ganteng.botak.androidcircleci;

import com.ganteng.botak.androidcircleci.login.LoginActivityMVP;
import com.ganteng.botak.androidcircleci.login.LoginActivityPresenter;
import com.ganteng.botak.androidcircleci.login.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;


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
         verifyZeroInteractions(mockLoginView);
    }

    @Test
    public void shouldCreateErrorMessageIfUsernamEmpty(){
        when(mockLoginView.getUserName()).thenReturn("");

        presenter.saveUser();

        verify(mockLoginView, times(1)).getUserName();
        verify(mockLoginView, never()).getPassword();
        verify(mockLoginView, times(1)).showInputError();


    }

    @Test
    public void sholdCreateErrorMessageIfPasswordEmpty(){
        when(mockLoginView.getUserName()).thenReturn("username");
        when(mockLoginView.getPassword()).thenReturn("");

        presenter.saveUser();
        verify(mockLoginView, times(1)).getUserName();
        verify(mockLoginView, never()).getPassword();
        verify(mockLoginView, times(1)).showInputError();
    }

    @Test
    public void shouldSaveValidUser(){
        when(mockLoginView.getUserName()).thenReturn("username");
        when(mockLoginView.getPassword()).thenReturn("password");

        presenter.saveUser();

        verify(mockLoginView, times(1)).getUserName();
        verify(mockLoginView, times(1)).getPassword();

        verify(mockLoginModel, times(1)).createUser("username", "password");

        verify(mockLoginView, times(1)).showUserSavedMessage();
    }


}
