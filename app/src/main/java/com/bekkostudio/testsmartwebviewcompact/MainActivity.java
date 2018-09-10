package com.bekkostudio.testsmartwebviewcompact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;

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
