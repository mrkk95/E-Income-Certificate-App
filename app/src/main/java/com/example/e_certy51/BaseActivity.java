package com.example.e_certy51;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.commonmenus,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.share)
        {
            Toast.makeText(this,"share menu is clicked",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Main2Activity.class));
        }
        else if(id==R.id.option)
        {
            Toast.makeText(this,"option menu is clicked",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Main3Activity.class));

        }
        else if(id==R.id.setting)
        {
            Toast.makeText(this,"setting menu is clicked",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Main4Activity.class));

        }

        return super.onOptionsItemSelected(item);
    }
}