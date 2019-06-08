package com.example.directory.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

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

    public static void showSnackbarShort(@Nullable View view, String message) {
        if (view != null) {
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
        }
    }

    public static void showSnackbarLong(@Nullable View view, String message) {
        if (view != null) {
            Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
        }
    }
}
