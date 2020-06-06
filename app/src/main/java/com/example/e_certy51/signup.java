package com.example.e_certy51;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    EditText txtEmail,txtPassword,txtConfirmPassword;
    Button btn_Register;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        txtEmail=findViewById(R.id.txt_email_s);
        txtPassword=findViewById(R.id.txtPassword_s);
        txtConfirmPassword=findViewById(R.id.txtPassword2);
        firebaseAuth=FirebaseAuth.getInstance();
        btn_Register=findViewById(R.id.signup);


        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String confirmpassword = txtConfirmPassword.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(signup.this, "please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(signup.this, "please Enter password", Toast.LENGTH_SHORT).show();
                    return;


                }
                if (TextUtils.isEmpty(confirmpassword)) {
                    Toast.makeText(signup.this, "please Enter confirmpassword", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<6)
                {
                    Toast.makeText(signup.this,"password is too small",Toast.LENGTH_SHORT).show();
                }

                if(password.equals(confirmpassword))
                {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful())
                                    {
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        Toast.makeText(signup.this,"Registration complete",Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(signup.this,"Authentication failed",Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });
                }


            }
        });

    }
}
