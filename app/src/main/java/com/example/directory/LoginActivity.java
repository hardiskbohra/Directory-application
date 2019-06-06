package com.example.directory;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.directory.constants.Constants;
import com.example.directory.utils.ValidationUtils;
import com.example.directory.utils.ViewUtils;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextView forgotPassword;
    private TextView signUp;
    private Button btnLogin;
    private TextView usernameError;
    private TextView passwordError;
    private ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setupUI();
        setupListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();

        username.setText("");
//        username.requestFocus();
        password.setText("");
    }

    @SuppressLint("WrongConstant")
    private void setupUI() {
        username = findViewById(R.id.usernameText);
        password = findViewById(R.id.passwordText);
        forgotPassword = findViewById(R.id.link_forgot_password);
        signUp = findViewById(R.id.link_signup);
        btnLogin = findViewById(R.id.btn_login);
        logo = findViewById(R.id.img_logo);
        usernameError = findViewById(R.id.username_error);
        passwordError = findViewById(R.id.password_error);

        usernameError.setVisibility(Constants.INVISIBLE);
        passwordError.setVisibility(Constants.INVISIBLE);
        validateData();
    }

    private void setupListeners() {

        username.addTextChangedListener(usernameTextWatcher);
        password.addTextChangedListener(passwordTextWatcher);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewUtils.showToastShort(LoginActivity.this, "Forgot Password");
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkLoginDetails()) {
                    sendMessage();
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewUtils.showToastShort(LoginActivity.this, "Request For Login Credentials");
            }
        });
    }

    TextWatcher usernameTextWatcher = new TextWatcher() {

        @SuppressLint("WrongConstant")
        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            usernameError.setVisibility(Constants.INVISIBLE);
            validateData();
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) { }

        @Override
        public void afterTextChanged(Editable s) { }
    };

    TextWatcher passwordTextWatcher = new TextWatcher() {

        @SuppressLint("WrongConstant")
        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            passwordError.setVisibility(Constants.INVISIBLE);
            validateData();
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) { }

        @Override
        public void afterTextChanged(Editable s) { }
    };


    void validateData() {

        if (ValidationUtils.isEmpty(username) || ValidationUtils.isEmpty(password)) {
            btnLogin.setEnabled(false);
        } else {
            btnLogin.setEnabled(true);
        }

        if (username.getText().toString().length() == 10) {
            username.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_user, 0, R.drawable.ic_valid_mark, 0);
        } else {
            username.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_user, 0, 0, 0);
        }

        if (password.getText().toString().length() >= 8) {
            password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock, 0, R.drawable.ic_valid_mark, 0);
        } else {
            password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock, 0, 0, 0);
        }
    }

    private boolean checkLoginDetails() {
        boolean isValid = true;

        if (username.getText().toString().length() < 10) {
            usernameError.setVisibility(Constants.VISIBLE);
            usernameError.setText("Please enter valid mobile number");
            username.setBackgroundResource(R.drawable.edit_text_error);
            username.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_user, 0, R.drawable.ic_invalid_mark, 0);
            username.requestFocus();
            isValid = false;
        } else {
            username.setBackgroundResource(R.drawable.edit_text_normal);
            username.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_user, 0, R.drawable.ic_valid_mark, 0);
        }

        if (password.getText().toString().length() < 8) {
            passwordError.setVisibility(Constants.VISIBLE);
            passwordError.setText("Password must be atleast 8 characters long");
            password.setBackgroundResource(R.drawable.edit_text_error);
            password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock, 0, R.drawable.ic_invalid_mark, 0);
            isValid = false;
        } else {
            password.setBackgroundResource(R.drawable.edit_text_normal);
            password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock, 0, R.drawable.ic_valid_mark, 0);
        }
        return isValid;
    }

    public void sendMessage() {
        Intent intent = new Intent(this, ChangePasswordActivity.class);
        String message = username.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
