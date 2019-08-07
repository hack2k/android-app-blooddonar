package com.example.blooddonar;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class reg extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);


        Button b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
           public void onClick(View view) {


               EditText t1=(EditText) findViewById(R.id.editText);
               EditText t2=(EditText) findViewById(R.id.editText5);
               Spinner s1=(Spinner)findViewById(R.id.spinner);
               Spinner s2=(Spinner)findViewById(R.id.spinner2);

               UserData obj = new UserData();
               obj.Name=t1.getText().toString();
               obj.Mobile=t2.getText().toString();
               obj.BG=s1.getSelectedItem().toString();
               obj.City=s2.getSelectedItem().toString();

               if(obj.Name.length()==0 || obj.Mobile.length()==0)
               {
                   Toast.makeText(getApplicationContext(), "Value cannot be empty", Toast.LENGTH_SHORT).show();
                return;
               }






               FirebaseDatabase database = FirebaseDatabase.getInstance();
               DatabaseReference myRef = database.getReference("/test/data/"+obj.Mobile);

                myRef.setValue(obj);
               Toast.makeText(reg.this, "record saved! hooray", Toast.LENGTH_SHORT).show();
               finish();
            }
        });

}}
