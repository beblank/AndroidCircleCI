package com.ganteng.botak.androidcircleci.login;

/**
 * Created by adityahadiwijaya on 1/17/17.
 */

public interface LoginRepository {

    User getUser();

    void saveUser(User user);
}
