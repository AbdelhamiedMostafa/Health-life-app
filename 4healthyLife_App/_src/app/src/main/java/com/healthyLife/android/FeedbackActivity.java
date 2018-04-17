package com.healthyLife.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity {
    private Button send;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        editText = (EditText) findViewById(R.id.editText11);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBtn();
                editText.setText("");

            }
        });


    }

    public void sendBtn() {
        Intent intent = new Intent(FeedbackActivity.this, FeedbackSendActivity.class);
        startActivity(intent);
    }

}
