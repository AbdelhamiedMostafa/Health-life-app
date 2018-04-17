package com.healthyLife.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class profile extends AppCompatActivity {
    TextView name,phone,emil,BMILast;
    EditText weight,height;
    Button callc,reset;

    public static final String MyMail = "MyMail" ;
    String accMail;


    SharedPreferences sharedpreferencesMail;
    SharedPreferences sharedpreferences;

    String nameget,phoneget,mailget;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = (TextView)findViewById(R.id.showName);
        phone = (TextView)findViewById(R.id.showPhone);
        emil = (TextView)findViewById(R.id.showMail);
        BMILast = (TextView)findViewById(R.id.BMI);
        callc = (Button)findViewById(R.id.showBMI);
        reset = (Button)findViewById(R.id.resset);


        weight = (EditText)findViewById(R.id.weight);
        height = (EditText)findViewById(R.id.height);

        sharedpreferencesMail = getSharedPreferences(MyMail, Context.MODE_PRIVATE);
        accMail = sharedpreferencesMail.getString("emailKey",null);

        sharedpreferences = getSharedPreferences(accMail,Context.MODE_PRIVATE);
        nameget = sharedpreferences.getString(Name,null);
        phoneget = sharedpreferences.getString(Phone,null);

        name.setText(nameget);
        phone.setText(phoneget);
        emil.setText(accMail);





        callc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double weight2 = Double.parseDouble(weight.getText().toString());
                Double height2 = Double.parseDouble(height.getText().toString());

                double BMI = weight2/(height2*height2);

                BMI = Math.floor(BMI*10)/10;
                BMILast.setText(""+BMI);


            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(profile.this,SaveProfile.class));
            }
        });



    }


}
