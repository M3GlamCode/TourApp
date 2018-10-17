package com.example.barclays.tourguideapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RelativeLayout relativeLayout = findViewById(R.id.relative_layout);

        //Setting a blurred background to the Splash Activity
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nairobi_city);
        Bitmap blurredBitmap = BlurBuilder.blur( SplashActivity.this, originalBitmap );
        relativeLayout.setBackground(new BitmapDrawable(getResources(), blurredBitmap));

        getSupportActionBar().hide();

        final int splash_display_length = 4000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextActivity = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(nextActivity);
                SplashActivity.this.finish();
            }
        }, splash_display_length);

    }//end of onCreate

}//end of public class
