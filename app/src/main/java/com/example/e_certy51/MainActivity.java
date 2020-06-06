package com.example.e_certy51;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity{

    EditText Email,Password;
    Button Login,signup;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email= findViewById(R.id.txt_email_s);
        Password=findViewById(R.id.txtPassword_s);
        Login=(Button)findViewById(R.id.Login);
        signup=(Button)findViewById(R.id.signup);
        firebaseAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, signup.class));
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email1=Email.getText().toString().trim();
                String Password1=Password.getText().toString().trim();

                if (TextUtils.isEmpty(Email1))
                {
                    Toast.makeText(MainActivity.this,"please enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Password1))
                {
                    Toast.makeText(MainActivity.this,"please enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Password1.length()<6)
                {
                    Toast.makeText(MainActivity.this,"password is too small",Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(Email1, Password1)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(), home.class));

                                } else {
                                    Toast.makeText(MainActivity.this, "login failed or user not available", Toast.LENGTH_SHORT).show();

                                }// ...
                            }
                        });

            }
        });

    }


}
