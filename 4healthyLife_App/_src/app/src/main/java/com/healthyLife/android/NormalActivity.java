package com.healthyLife.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.PublicKey;

public class NormalActivity extends AppCompatActivity {
    private Button gain;
    private Button lose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);


        gain = (Button) findViewById(R.id.gain_weight);
        gain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gainBtn();
            }
        });

        lose = (Button) findViewById(R.id.lose_weight);
        lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loseBtn();
            }
        });

    }

    public void gainBtn() {
        Intent intent = new Intent(NormalActivity.this, GainWeightActivity.class);
        startActivity(intent);
    }


    public void loseBtn() {
        Intent intent = new Intent(NormalActivity.this, LoseWeightActivity.class);
        startActivity(intent);
    }
}
