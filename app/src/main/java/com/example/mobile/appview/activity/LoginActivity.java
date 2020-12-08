package com.example.mobile.appview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mobile.appview.R;
import com.example.mobile.appview.utils.ConfigStorage;
import com.scottyab.showhidepasswordedittext.ShowHidePasswordEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.mobile.appview.utils.ConfigStorage.regEx;

public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView mEmail;
    private ShowHidePasswordEditText mPasswordView;

    ConfigStorage cfg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cfg = new ConfigStorage(this);

        InitView();

    }

    private void InitView(){

        mEmail = findViewById(R.id.email);
        mPasswordView = findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener((textView, id, keyEvent) -> {
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                attemptLogin();
                return true;
            }
            return false;
        });

        Button Login = findViewById(R.id.login);
        Login.setOnClickListener(view -> attemptLogin());

    }

    private void attemptLogin() {

        // Reset errors.
        mEmail.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String Email = mEmail.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(Email);

        if (TextUtils.isEmpty(Email)) {
            mEmail.setError(getString(R.string.error_field_required));
            focusView = mEmail;
            cancel = true;
        }else if (!m.find()) {
            mEmail.setError(getString(R.string.email_not_valid));
            focusView = mEmail;
            cancel = true;
        }else if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;
        }else if (isPasswordValid(password)){
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            Login();
        }
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() <= 5;
    }

    private void Login(){
        cfg.SetNotLogin(false);
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED);
        finish();
    }
}