package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.quiz.databinding.ActivityLoginBinding;
import com.example.quiz.databinding.ActivitySignupBinding;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    FirebaseAuth auth;
    GoogleSignInClient mGoogleSignInClient;
    BeginSignInRequest signInRequest;
    FirebaseDatabase firebaseDatabase;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        progressDialog=new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("Login User");
        progressDialog.setMessage("We are Login to Your Account");
//......................Google Signin Activity..................
       // signInRequest= new BeginSignInResult();
//        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
//                .build();
//        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);
//        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(this);
//
//        binding.Googlebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent SigninIntent=mGoogleSignInClient.getSignInIntent();
//            }
//        });


        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,pass;
                email=binding.lemail.getText().toString();
                pass=binding.loginPassword.getText().toString();

//                if (TextUtils.isEmpty(email)){
//                    binding.lemail.setError("Email is required");
//                }
//                if (TextUtils.isEmpty(pass)){
//                    binding.loginPassword.setError("Email is required");
//                }

                progressDialog.show();
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       progressDialog.dismiss();
                       if(task.isSuccessful()){
                           Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(LoginActivity.this,MainActivity.class));
                           finish();
                       }
                       else{
                           Toast.makeText(LoginActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                       }
                    }
                });

            }
        });
       
        findViewById(R.id.notAccountSignup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
                finish();
            }
        });
    }

    }
