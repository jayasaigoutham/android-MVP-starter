package com.jayasai.starter.Login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jayasai.starter.Home.MainActivity;
import com.jayasai.starter.R;
import com.jayasai.starter.sqlite.Helper.SqliteController;
import com.jayasai.starter.sqlite.model.User;


public class LoginActivity extends AppCompatActivity implements LoginView{

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SqliteController sqliteController = new SqliteController(this);

        presenter = new LoginPresenter(this, new LoginInteractor()); //Future enhancement : Dagger2 can be used for DI

        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }


    private void attemptLogin() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        presenter.validateCredentials(mEmailView.getText().toString(), mPasswordView.getText().toString());

    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }


    @Override
    public void showProgress() {
        mProgressView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        mProgressView.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        mEmailView.setError("");
    }

    @Override
    public void setPasswordError() {
        mPasswordView.setError("");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}

