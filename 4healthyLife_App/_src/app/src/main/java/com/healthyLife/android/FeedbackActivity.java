package com.healthyLife.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeedbackActivity extends AppCompatActivity {
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBtn();
            }
        });
    }
    public void sendBtn(){
        Intent intent = new Intent(FeedbackActivity.this, FeedbackSendActivity.class);
        startActivity(intent);
    }
}
