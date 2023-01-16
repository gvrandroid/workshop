package com.target.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
EditText name, email, password, confirmPassword;
Button signUp,signIn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.name_et);
        email = findViewById(R.id.email_et);
        password = findViewById(R.id.pwd_et);
        confirmPassword = findViewById(R.id.conf_pwd_et);
        signUp = findViewById(R.id.sign_up_btn);
        signIn = findViewById(R.id.sign_in_btn);

        mAuth = FirebaseAuth.getInstance();
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),SignIn.class);
                startActivity(in);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
                      @Override
            public void onClick(View v) {
                String emailValue = email.getText().toString();
                String pwdValue = password.getText().toString();
                if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() ||
                        password.getText().toString().isEmpty() || confirmPassword.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fields cannot be empty",Toast.LENGTH_SHORT).show();
                }
                else{

                    mAuth.createUserWithEmailAndPassword(emailValue,pwdValue).addOnCompleteListener(task -> {
                        Intent in = new Intent(getApplicationContext(),SignIn.class);
                        Toast.makeText(getApplicationContext(),  "user created",Toast.LENGTH_SHORT).show();
                        startActivity(in);
                    });
                }

            }
        });


    }
}