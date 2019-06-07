package com.example.directory.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.directory.R;
import com.example.directory.constants.Constants;
import com.example.directory.utils.ValidationUtils;
import com.example.directory.utils.ViewUtils;

public class ChangePasswordActivity extends AppCompatActivity {

    private EditText newPassword;
    private EditText confirmPassword;
    private Button btnDone;
    private TextView newPasswordError;
    private TextView confirmPasswordError;
    private ImageView logo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        setupUI();
        setupListeners();
    }

    @SuppressLint("WrongConstant")
    private void setupUI() {
        newPassword = findViewById(R.id.newPasswordText);
        confirmPassword = findViewById(R.id.confirmPasswordText);
        btnDone = findViewById(R.id.btn_done);
        logo = findViewById(R.id.img_logo);
        newPasswordError = findViewById(R.id.new_password_error);
        confirmPasswordError = findViewById(R.id.confirm_password_error);

        newPasswordError.setVisibility(Constants.INVISIBLE);
        confirmPasswordError.setVisibility(Constants.INVISIBLE);
        validateData();
    }

    private void setupListeners() {

        newPassword.addTextChangedListener(newPasswordTextWatcher);
        confirmPassword.addTextChangedListener(confirmPasswordTextWatcher);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkChangePasswordDetails()) {
                    ViewUtils.showToastShort(ChangePasswordActivity.this, "Password changed successfully");
                    Intent intent = new Intent(ChangePasswordActivity.this, ListViewActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    TextWatcher newPasswordTextWatcher = new TextWatcher() {

        @SuppressLint("WrongConstant")
        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            newPasswordError.setVisibility(Constants.INVISIBLE);
            validateData();
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    TextWatcher confirmPasswordTextWatcher = new TextWatcher() {

        @SuppressLint("WrongConstant")
        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            confirmPasswordError.setVisibility(Constants.INVISIBLE);
            validateData();
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };


    void validateData() {

        if (ValidationUtils.isEmpty(newPassword) || ValidationUtils.isEmpty(confirmPassword)) {
            btnDone.setEnabled(false);
        } else {
            btnDone.setEnabled(true);
        }

        if (newPassword.getText().toString().length() >= 8 && newPassword.getText().toString().length() <= 15) {
            newPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_unlock, 0, R.drawable.ic_pending_mark, 0);
        } else if (newPassword.getText().toString().length() >= 15) {
            newPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_unlock, 0, R.drawable.ic_valid_mark, 0);
        } else {
            newPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_unlock, 0, 0, 0);
        }

        if (!ValidationUtils.isEmpty(confirmPassword) && confirmPassword.getText().toString().equals(newPassword.getText().toString())) {
            confirmPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock, 0, R.drawable.ic_valid_mark, 0);
        } else {
            confirmPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock, 0, 0, 0);
        }
    }

    private boolean checkChangePasswordDetails() {
        boolean isValid = true;

        if (newPassword.getText().toString().length() < 8) {
            newPasswordError.setVisibility(Constants.VISIBLE);
            newPasswordError.setText("Password must be atleast 8 characters long");
            newPassword.setBackgroundResource(R.drawable.edit_text_error);
            newPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_unlock, 0, R.drawable.ic_invalid_mark, 0);
            isValid = false;
        } else if (newPassword.getText().toString().length() < 15) {
            newPassword.setBackgroundResource(R.drawable.edit_text_normal);
            newPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_unlock, 0, R.drawable.ic_pending_mark, 0);
        } else {
            newPassword.setBackgroundResource(R.drawable.edit_text_normal);
            newPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_unlock, 0, R.drawable.ic_valid_mark, 0);
        }

        if (!confirmPassword.getText().toString().equals(newPassword.getText().toString())) {
            confirmPasswordError.setVisibility(Constants.VISIBLE);
            confirmPasswordError.setText("Confirm password must be same");
            confirmPassword.setBackgroundResource(R.drawable.edit_text_error);
            confirmPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock, 0, R.drawable.ic_invalid_mark, 0);
            isValid = false;
        } else {
            confirmPassword.setBackgroundResource(R.drawable.edit_text_normal);
            confirmPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock, 0, R.drawable.ic_valid_mark, 0);
        }
        return isValid;
    }
}
