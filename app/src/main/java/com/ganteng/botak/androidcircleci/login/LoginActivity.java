package com.ganteng.botak.androidcircleci.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.ganteng.botak.androidcircleci.R;
import com.ganteng.botak.androidcircleci.root.App;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

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

    }
}
