package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Animation animate = AnimationUtils.loadAnimation(this,R.anim.scaleanim);
        textView = findViewById(R.id.Title);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        textView.startAnimation(animate);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                startActivity(intent);
                finish();
            }
        };
        new Handler(Looper.getMainLooper()).postDelayed(runnable,4000);
    }
}