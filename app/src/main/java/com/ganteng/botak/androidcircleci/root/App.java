package com.ganteng.botak.androidcircleci.root;

import android.app.Application;

/**
 * Created by adityahadiwijaya on 1/16/17.
 */

public class App extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
