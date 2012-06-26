package com.ifixit.guidebook;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

public class GuidebookActivity extends Activity {
   protected static final String GUIDEID = "guideid";
   protected static final String SPLASH_URL = "http://www.ifixit.com";
   protected static final String NEW_APP_URL =
    "market://details?id=com.dozuki.ifixit";

   protected WebView mWebView;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setContentView(R.layout.webview);
      mWebView = (WebView)findViewById(R.id.webView);
      mWebView.getSettings().setJavaScriptEnabled(true);
      mWebView.loadUrl(SPLASH_URL);
      mWebView.setWebViewClient(new GuideWebView(this));

      showDialog(0);
   }

   public void viewGuide(int guideid) {
      Intent intent = new Intent(this, GuideView.class);

      intent.putExtra(GUIDEID, guideid);
      startActivity(intent);
   }

   @Override
   public boolean onKeyDown(int keyCode, KeyEvent event) {
       if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
           mWebView.goBack();
           return true;
       }
       return super.onKeyDown(keyCode, event);
   }

   protected Dialog onCreateDialog(int id) {
      AlertDialog.Builder builder = new AlertDialog.Builder(this);

      builder.setMessage(R.string.newAppNotification)
             .setCancelable(false)
             .setPositiveButton(R.string.downloadNow,
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                   Intent intent = new Intent(Intent.ACTION_VIEW);
                   intent.setData(Uri.parse(NEW_APP_URL));
                   startActivity(intent);
                }
             })
             .setNegativeButton(R.string.cancel,
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                   dialog.cancel();
                }
             });

      return builder.create();
   }
}
