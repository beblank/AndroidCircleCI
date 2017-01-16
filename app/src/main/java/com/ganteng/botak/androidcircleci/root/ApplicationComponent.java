package com.ganteng.botak.androidcircleci.root;

import com.ganteng.botak.androidcircleci.login.LoginActivity;

import javax.inject.Singleton;

/**
 * Created by adityahadiwijaya on 1/16/17.
 */

@Singleton
public interface ApplicationComponent {

    void inject(LoginActivity target);

}
