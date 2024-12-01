package com.example.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // Initialize the logo ImageView
        logoImageView = findViewById(R.id.logoImageView);

        // Load the translate and scale animations
        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);

        // Start both animations together
        logoImageView.startAnimation(translateAnimation);
        logoImageView.startAnimation(scaleAnimation);

        // After the animation finishes, navigate to the login screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Navigate to LoginActivity
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Finish the splash screen activity
            }
        }, 2000); // Duration for splash screen (in milliseconds)
    }
}
