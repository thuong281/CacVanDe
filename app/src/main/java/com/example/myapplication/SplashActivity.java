package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

  private static final int DELAYED_TIME = 4000;
  FirebaseUser user;
  FirebaseAuth auth;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    auth = FirebaseAuth.getInstance();
    user = auth.getCurrentUser();

    Intent intent;
    if (user == null){
      intent = new Intent(this, LoginActivity.class);
    }
    else {
      intent = new Intent(this, MainActivity.class);
    }

    new Handler().postDelayed(() -> {
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(intent);
    }, DELAYED_TIME);

  }
}