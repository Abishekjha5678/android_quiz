package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class AccountActivity extends AppCompatActivity {
    TextView email;
    Button logOut;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        getSupportActionBar().setTitle("Profile");

        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        logOut = findViewById(R.id.logout);

        email.setText(auth.getCurrentUser().getEmail());

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(AccountActivity.this, LoginActivity.class));
                finish();
            }
        });

    }
}