package com.healthyLife.android;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void CalcBMI(View view){

        EditText weightText = findViewById(R.id.editText4);
        double weight = Double.parseDouble(weightText.getText().toString());

        System.out.println(weight);

        EditText heightText = findViewById(R.id.editText5);
        double height = Double.parseDouble(heightText.getText().toString())/100;

        System.out.println(height);

        double BMI = weight/(height*height);

        BMI = Math.floor(BMI*10)/10;

        System.out.println(BMI);

        TextView bmiText = (TextView) findViewById(R.id.bmi_label);

        String bmiStr = "BMI: "+BMI;

        bmiText.setText(bmiStr);


    }

}
