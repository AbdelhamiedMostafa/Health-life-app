package com.healthyLife.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class SportsActivity extends AppCompatActivity {


    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        browser = findViewById(R.id.webView);
        browser.loadUrl("https://youtu.be/LVRqRbHall4");

    }

    


}
