package com.healthyLife.android;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SaveProfile extends AppCompatActivity {

    EditText name, phone;
    Button Save;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";

    public static final String MyMail = "MyMail" ;
    String accMail;


    SharedPreferences sharedpreferencesMail;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_profile);

        name = (EditText) findViewById(R.id.saveProfileName);
        phone = (EditText) findViewById(R.id.SaveProfilePhone);

        Save = (Button)findViewById(R.id.Save);
        sharedpreferencesMail = getSharedPreferences(MyMail,Context.MODE_PRIVATE);



        accMail = sharedpreferencesMail.getString("emailKey",null);
        sharedpreferences = getSharedPreferences(accMail, Context.MODE_PRIVATE);


        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name,name.getText().toString());
                editor.putString(Phone,phone.getText().toString());
                editor.commit();

                startActivity(new Intent(SaveProfile.this,MainActivity.class));


            }
        });


    }
}
