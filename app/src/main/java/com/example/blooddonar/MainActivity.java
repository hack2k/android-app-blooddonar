package com.example.blooddonar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

            public void rreg(View view)
            {

                startActivity(new Intent(this,reg.class));
            }



            public void ssearch(View view)
            {

                startActivity(new Intent(this,search.class));
            }


            public void eexit(View view) {
                finish();
            }
        }


