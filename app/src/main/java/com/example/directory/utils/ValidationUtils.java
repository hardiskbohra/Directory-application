package com.example.directory.utils;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

public class ValidationUtils {

    public static boolean isEmpty(EditText text) {
        CharSequence data = text.getText().toString();
        return TextUtils.isEmpty(data);
    }

    public static boolean isEmail(EditText text) {
        CharSequence data = text.getText().toString();
        if (TextUtils.isEmpty(data)) {
            return false;
        }
        return (!TextUtils.isEmpty(data) && Patterns.EMAIL_ADDRESS.matcher(data).matches());
    }

    public static boolean isMobile(EditText text) {
        CharSequence data = text.getText().toString();
        if (TextUtils.isEmpty(data)) {
            return false;
        }
        return (!TextUtils.isEmpty(data) && Patterns.PHONE.matcher(data).matches());
    }
}
