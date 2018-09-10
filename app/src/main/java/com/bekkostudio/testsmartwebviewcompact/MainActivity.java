package com.bekkostudio.testsmartwebviewcompact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.bekkostudio.compactWebview.SmartWebView;
import com.bekkostudio.compactWebview.SmartWebViewCompact;

public class MainActivity extends AppCompatActivity {

    SmartWebViewCompact smartWebViewCompact = new SmartWebViewCompact();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        smartWebViewCompact.onActivityResult(requestCode, resultCode, intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Permission variables
        SmartWebView.ASWP_JSCRIPT     = true;     //enable JavaScript for webview
        SmartWebView.ASWP_FUPLOAD     = true;     //upload file from webview
        SmartWebView.ASWP_CAMUPLOAD   = true;     //enable upload from camera for photos
        SmartWebView.ASWP_ONLYCAM		= false;	//incase you want only camera files to upload
        SmartWebView.ASWP_MULFILE     = false;    //upload multiple files in webview
        SmartWebView.ASWP_LOCATION    = false;     //track GPS locations
        SmartWebView.ASWP_RATINGS     = false;     //show ratings dialog; auto configured, edit method get_rating() for customizations
        SmartWebView.ASWP_PBAR        = true;     //show progress bar in app
        SmartWebView.ASWP_ZOOM        = false;    //zoom control for webpages view
        SmartWebView.ASWP_SFORM       = true;    //save form cache and auto-fill information
        SmartWebView.ASWP_OFFLINE     = false;    //whether the loading webpages are offline or online
        SmartWebView.ASWP_EXTURL      = false;     //open external url with default browser instead of app webview

        //Configuration variables
        SmartWebView.ASWV_URL          = "https://m.facebook.com"; //complete URL of your website or webpage
        SmartWebView.ASWV_F_TYPE       = "*/*";  //to upload any file type using "*/*"; check file type references for more

        //Rating system variables
        SmartWebView.ASWR_DAYS            = 3;        //after how many days of usage would you like to show the dialoge
        SmartWebView.ASWR_TIMES           = 10;       //overall request launch times being ignored
        SmartWebView.ASWR_INTERVAL        = 2;        //reminding users to rate after days interval

        smartWebViewCompact.onCreate(this,(WebView) findViewById(R.id.msw_view),(ProgressBar) findViewById(R.id.msw_progress));
    }

    @Override
    public void onBackPressed() {
        smartWebViewCompact.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState ){
        super.onSaveInstanceState(outState);
        smartWebViewCompact.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        smartWebViewCompact.onRestoreInstanceState(savedInstanceState);
    }
}
