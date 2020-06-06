package com.example.e_certy51;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {

    private Button FillDetail;
    private Button Documents;
    private Button Criteria;
    private Button About;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FillDetail=findViewById(R.id.button);
        Documents=findViewById(R.id.button2);
        Criteria=findViewById(R.id.button3);
        About=findViewById(R.id.button4);


        FillDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this, Fill_details.class));
            }
        });

        Documents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this, Documents.class));
            }
        });

        Criteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this, Criteria.class));
            }
        });

        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this, About.class));
            }
        });

    }
}
