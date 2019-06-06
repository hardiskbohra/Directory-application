package com.example.directory.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.logging.Logger;

public class ViewUtils {

    public static void showToastShort(@Nullable Context context, String message) {
        if (context != null) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showToastLong(@Nullable Context context, String message) {
        if (context != null) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }
}
