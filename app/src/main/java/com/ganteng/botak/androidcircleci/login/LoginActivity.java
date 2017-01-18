package com.ganteng.botak.androidcircleci.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ganteng.botak.androidcircleci.R;
import com.ganteng.botak.androidcircleci.root.App;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    @Inject
    LoginActivityMVP.Presenter presenter;

    @BindView(R.id.button_submit)
    Button submitButton;

    @BindView(R.id.input_username)
    EditText usernameInput;

    @BindView(R.id.input_password)
    EditText passwordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App)getApplication()).getComponent().inject(this);

        ButterKnife.bind(this);

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked();
            }
        });

    }

    @Override
    public String getUserName() {
        return usernameInput.getText().toString();
    }

    @Override
    public String getPassword() {
        return usernameInput.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "Error: the user is not available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "Username or Password cannot be empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUsername(String uname) {
        usernameInput.setText(uname);
    }

    @Override
    public void setPassword(String pass) {
        passwordInput.setText(pass);
    }
}
