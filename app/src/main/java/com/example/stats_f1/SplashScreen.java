package com.example.stats_f1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        FirebaseAuth.getInstance().signOut();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        // Check if the user is already signed in
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(() -> {
            // Check if the user is logged in
            if (mAuth.getCurrentUser() != null) {
                // If user is logged in, go to MainActivity or SignIn
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
            } else {
                // If user is not logged in, go to SignUp
                startActivity(new Intent(SplashScreen.this, SignUp.class));
            }
            finish();  // Close SplashScreen activity after navigating
        }, 3000);  // Delay for 3 seconds
    }
}
