package com.ganteng.botak.androidcircleci.login;

/**
 * Created by adityahadiwijaya on 1/17/17.
 */

public class LoginModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginModel(LoginRepository loginRepository){
        this.repository = loginRepository;
    }

    @Override
    public void createUser(String uname, String pass) {
        repository.saveUser(new User(uname, pass));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
