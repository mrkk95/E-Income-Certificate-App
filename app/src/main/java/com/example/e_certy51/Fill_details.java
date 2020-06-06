package com.example.e_certy51;

import android.icu.text.Edits;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class Fill_details extends AppCompatActivity {
    private EditText name;
    private Button submit;

    DatabaseReference databaseuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_details);

        databaseuser= FirebaseDatabase.getInstance().getReference();
        name= (EditText) findViewById(R.id.editText);
      ; submit=(Button) findViewById(R.id.button8);


        
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
    }
    
    private void add(){
        String name1= name.getText().toString().trim();
        if(!TextUtils.isEmpty(name1)){

            String id=databaseuser.push().getKey();
            database_fill_details data=new database_fill_details(id, name1);
            databaseuser.child(id).setValue(data);
        }
        else{
            Toast.makeText(this,"You should fill every details",Toast.LENGTH_SHORT).show();
        }

    }

    public void onRadioButtonClicked (View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
