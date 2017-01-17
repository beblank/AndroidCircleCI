package com.ganteng.botak.androidcircleci.login;

/**
 * Created by adityahadiwijaya on 1/17/17.
 */

public class MemoryRepository implements LoginRepository {

    private User user;

    @Override
    public User getUser() {
        if (user == null){
            User user = new User("MNC", "Playmedia");
            user.setId(0);
            return user;
        } else {
            return user;
        }
    }

    @Override
    public void saveUser(User user) {
        if (user == null){
            user = getUser();
        }

        this.user = user;
    }
}
