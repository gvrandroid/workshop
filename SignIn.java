package com.target.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
EditText email, password;
Button signIn, signOut;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.email_et);
        password = findViewById(R.id.pwd_et);
        signOut = findViewById(R.id.sign_out_btn);
        signIn = findViewById(R.id.sign_in_btn);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailValue = email.getText().toString();
                String pwdValue = password.getText().toString();
                mAuth.signInWithEmailAndPassword(emailValue,pwdValue).addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Intent in = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(in);
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"Invalid User!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                );
            }
        });


    }
}