package com.example.android.tvguide.view.utils;

/**
 * Created by Wa'el Ahmad on 2/10/2018.
 */
import android.app.ProgressDialog;
import android.content.Context;

public class DialogFactory {
  public static ProgressDialog createSimpleProgressDialog(Context context, String message) {
    ProgressDialog progressDialog = new ProgressDialog(context);
    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    progressDialog.setMessage(message);
    return progressDialog;
  }
}
