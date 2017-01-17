package com.ganteng.botak.androidcircleci.root;

import com.ganteng.botak.androidcircleci.login.LoginActivity;
import com.ganteng.botak.androidcircleci.login.LoginModel;
import com.ganteng.botak.androidcircleci.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adityahadiwijaya on 1/16/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);

}
