package com.example.blooddonar;

import android.os.Bundle;
import android.content.*;
import android.util.Log;
import android.widget.*;
import android.view.*;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class search extends AppCompatActivity {

    ArrayList x;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        final Spinner s1 = (Spinner) findViewById(R.id.spinner3);
        final Spinner s2 = (Spinner) findViewById(R.id.spinner4);


        String bg = s1.getSelectedItem().toString();
        String city = s2.getSelectedItem().toString();
        final GridView gv = (GridView) findViewById(R.id.grid);

        x=new ArrayList();
        x.add("NAME");
        x.add("MOBILE");
        x.add("");
        Button b1 = (Button) findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                android.widget.Toast.makeText(search.this,s1.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(search.this, "Loading", Toast.LENGTH_SHORT).show();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("/test/data/");


                 myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        Long count = dataSnapshot.getChildrenCount();

                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            UserData dd = child.getValue(UserData.class);

                            //   Toast.makeText(getApplicationContext(), dd.Name + " " + dd.Mobile, Toast.LENGTH_SHORT).show();

                            if (s1.getSelectedItem().toString().equals(dd.BG) && s2.getSelectedItem().toString().equals(dd.City)) {


                                x.add(dd.Name);
                                x.add(dd.Mobile);


                            }
                            }

                             ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(),
                                     android.R.layout.simple_list_item_1,x);

                            gv.setAdapter(adapter);
                            gv.getSelectedItem();

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                    }

                });

            }


        });


    }
}