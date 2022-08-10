package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.quiz.Models.Users;
import com.example.quiz.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.TimeUnit;

public class SignupActivity extends AppCompatActivity {

private FirebaseAuth auth;
FirebaseDatabase firebaseDatabase;
ActivitySignupBinding activitySignupBinding;
ProgressDialog progressDialog;
String email,pass,name,mobile,s;
String otp;
boolean isVerified=false;
FirebaseFirestore firebaseFirestore;
@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activitySignupBinding = ActivitySignupBinding.inflate(getLayoutInflater());
    setContentView(activitySignupBinding.getRoot());
    getSupportActionBar().hide();
    auth = FirebaseAuth.getInstance();
    activitySignupBinding.signupSubmit.setVisibility(View.INVISIBLE);
    firebaseFirestore = FirebaseFirestore.getInstance();
    firebaseDatabase = FirebaseDatabase.getInstance();
    progressDialog = new ProgressDialog(SignupActivity.this);
    progressDialog.setTitle("Creating User");
    progressDialog.setMessage("We are Creating Your Account");

//...........................getenrate otp...............

    activitySignupBinding.mailsent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            generateOtp(activitySignupBinding.email.getText().toString());

        }
    });

activitySignupBinding.verifyuserotp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String inputOTP=activitySignupBinding.verifyotp.getText().toString();
        if(inputOTP.equals(otp)){
            Toast.makeText(SignupActivity.this, "OTP Successfully Verified", Toast.LENGTH_SHORT).show();
            isVerified=true;
            activitySignupBinding.signupSubmit.setVisibility(View.VISIBLE);
            activitySignupBinding.verifyotp.setVisibility(View.INVISIBLE);
            activitySignupBinding.verifyuserotp.setVisibility(View.INVISIBLE);
            activitySignupBinding.mailsent.setVisibility(View.INVISIBLE);
        }
        else {
            Toast.makeText(SignupActivity.this, "OTP not Matched", Toast.LENGTH_SHORT).show();
        }
    }
});


    activitySignupBinding.signupSubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            progressDialog.show();

            email = activitySignupBinding.email.getText().toString();
            pass = activitySignupBinding.loginPassword.getText().toString();
            name = activitySignupBinding.signupName.getText().toString();
            mobile = activitySignupBinding.signupPhone.getText().toString();
            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {


                    //it create a new user in realtime database and it will store users data
                    Users users = new Users(name, email, pass, mobile);
                    if (task.isSuccessful()) {

                        String id = task.getResult().getUser().getUid();
                        //firebaseDatabase.getReference("Users").child(id).setValue(users);
                        firebaseFirestore.collection("users")
                                .document(id).set(users)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            progressDialog.dismiss();
                                            Toast.makeText(SignupActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                                            finish();
                                        } else {
                                            Toast.makeText(SignupActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    } else {
                        Toast.makeText(SignupActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    });


    if(auth.getCurrentUser()!=null)
    {
        Intent intent=new Intent(SignupActivity.this,MainActivity.class);
        intent.putExtra("userName",email);
        startActivity(intent);
        finish();
    }
    findViewById(R.id.notAccountSignup).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(SignupActivity.this,LoginActivity.class));
            finish();
        }
    });

}


    public void generateOtp(String email)
    {
        otp=((int)(Math.random()*(100000-1000)+1000))+"";

        if(email.length()>0)
            sendMail(email,"Enter otp to validate your email. \nOTP:"+otp,"OTP");
        else
            Toast.makeText(SignupActivity.this, "Enter your email", Toast.LENGTH_SHORT).show();

    }


    private void sendMail(String mail,String msg,String sub) {

        JavaMailAPI javaMailAPI = new JavaMailAPI(this,mail,sub,msg);

        javaMailAPI.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }



}