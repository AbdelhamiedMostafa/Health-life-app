package com.healthyLife.android;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ProgressBar progressBar;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private Button normal;
    private Button sports;
    private Button hypertension;
    private Button diabetes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        auth = FirebaseAuth.getInstance();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };



        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switch (item.getItemId())
                {
                    case R.id.singOut:
                        signOut();
                        return true;
                    case R.id.profile:
                        profile();
                        return true;
                    case R.id.feedBack:
                        feedBack();
                        return true;
                }
                mDrawerLayout.closeDrawers();


                return true;
            }
        });


        normal = (Button) findViewById(R.id.normal_button);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalBtn();
            }
        });

        sports = (Button) findViewById(R.id.sport_button);
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sportsBtn();
            }
        });

        hypertension = (Button) findViewById(R.id.hypertension_button);
        hypertension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hypertensionBtn();
            }
        });

        diabetes = (Button) findViewById(R.id.diabetes_button);
        diabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diabetesBtn();
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void signOut() {
        auth.signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }

    void profile()
    {
        startActivity(new Intent(MainActivity.this,profile.class));
    }
    void feedBack()
    {
        startActivity(new Intent(MainActivity.this,FeedbackActivity.class));
    }

    public void normalBtn(){
        Intent intent = new Intent(this,NormalActivity.class);
        startActivity(intent);
    }

    public void sportsBtn(){
        Intent intent = new Intent(this, SportsActivity.class);
        startActivity(intent);
    }

    public void hypertensionBtn(){
        Intent intent = new Intent (this, HypertensionActivity.class);
        startActivity(intent);
    }

    public void diabetesBtn(){
        Intent intent = new Intent(this,DiabetesActivity.class);
        startActivity(intent);
    }



}
