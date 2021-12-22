package com.example.myapplication.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
  private ActivityLoginBinding binding;
  private final FirebaseAuth auth = FirebaseAuth.getInstance();
  private final FirebaseFirestore db = FirebaseFirestore.getInstance();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityLoginBinding.inflate(getLayoutInflater());
    View view = binding.getRoot();
    setContentView(view);

    final Button loginButton = binding.signInBtn;
    final Button signupButton = binding.signUpBtn;

    loginButton.setOnClickListener(v -> {
      onLoginPress();
    });

    signupButton.setOnClickListener(v -> {

    });
  }

  private void onLoginPress() {
    String username = binding.signInUsernameEditText.getText().toString();
    String password = binding.signInPasswordEditText.getText().toString();
    Log.d("Mylog", "onLoginPress: " + username + password);
    if (!username.isEmpty() && !password.isEmpty()) {
      binding.loading.setVisibility(View.VISIBLE);
      login(username, password);
    } else Toast.makeText(this, "Hãy nhập email và mật khẩu", Toast.LENGTH_SHORT).show();
  }

  private void updateUiWithUser(FirebaseUser user) {
    if (user != null) {
      Intent intent = new Intent(this, MainActivity.class);
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(intent);
    } else Toast.makeText(this.getApplicationContext(), "user is null wtf", Toast.LENGTH_LONG).show();
  }

  public void login(String username, String password) {
    auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(task -> {
      if (task.isSuccessful()) {
        Log.d("Mylog", "signInWithEmail:success");
        FirebaseUser user = auth.getCurrentUser();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> map = new HashMap<>();
        map.put("name", user.getDisplayName());
        map.put("profileImage", user.getPhotoUrl().toString());
        map.put("email", user.getEmail());
        db.collection("person")
            .document(user.getUid())
            .set(map);
        updateUiWithUser(user);
      } else
        Toast.makeText(this.getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
      binding.loading.setVisibility(View.GONE);
    });
  }

  public void signUp(String username, String password, String displayName) {
    auth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
      @Override
      public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
          FirebaseUser user = auth.getCurrentUser();
          UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(displayName).build();
          user.updateProfile(profileUpdates);
        }
      }

    });
  }

  @Override
  protected void onDestroy() {
    binding = null;
    super.onDestroy();
  }
}