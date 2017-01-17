package com.ganteng.botak.androidcircleci.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adityahadiwijaya on 1/17/17.
 */
@Module
public class LoginModule {

    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model){
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model provdeLoginActivityModel(LoginRepository loginRepository){
        return new LoginModel(loginRepository);
    }

    @Provides
    public LoginRepository provideLoginRepository(){
        return new MemoryRepository();
    }
}
