package com.example.directory.activities;

import android.annotation.SuppressLint;
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
import com.example.directory.utils.ViewUtils;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText mobileNumber;
    private TextView mobileNumberError;
    private Button btnSend;
    private ImageView logo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        setupUI();
        setupListeners();
    }

    @SuppressLint("WrongConstant")
    private void setupUI() {
        mobileNumber = findViewById(R.id.mobileNumberText);
        btnSend = findViewById(R.id.btn_send);
        logo = findViewById(R.id.img_logo);
        mobileNumberError = findViewById(R.id.mobile_number_error);

        mobileNumberError.setVisibility(Constants.INVISIBLE);
        validateData();
    }

    private void setupListeners() {

        mobileNumber.addTextChangedListener(mobileNumberTextWatcher);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkMobileNumberDetails()) {
                    ViewUtils.showToastShort(ForgotPasswordActivity.this, "Reset password instruction sent successfully");
                }
            }
        });
    }

    TextWatcher mobileNumberTextWatcher = new TextWatcher() {

        @SuppressLint("WrongConstant")
        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            mobileNumberError.setVisibility(Constants.INVISIBLE);
            validateData();
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) { }

        @Override
        public void afterTextChanged(Editable s) { }
    };


    void validateData() {

        if (mobileNumber.getText().toString().length() < 10) {
            btnSend.setEnabled(false);
        } else {
            btnSend.setEnabled(true);
        }

        if (mobileNumber.getText().toString().length() == 10) {
            mobileNumber.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_user, 0, R.drawable.ic_valid_mark, 0);
        } else {
            mobileNumber.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_user, 0, 0, 0);
        }
    }

    private boolean checkMobileNumberDetails() {
        boolean isValid = true;

        if (mobileNumber.getText().toString().length() < 10) {
            mobileNumberError.setVisibility(Constants.VISIBLE);
            mobileNumberError.setText("Please enter valid mobile number");
            mobileNumber.setBackgroundResource(R.drawable.edit_text_error);
            mobileNumber.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_user, 0, R.drawable.ic_invalid_mark, 0);
            isValid = false;
        } else {
            mobileNumber.setBackgroundResource(R.drawable.edit_text_normal);
            mobileNumber.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_user, 0, R.drawable.ic_valid_mark, 0);
        }
        return isValid;
    }
}
