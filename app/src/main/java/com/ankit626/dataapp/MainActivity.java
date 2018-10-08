package com.ankit626.dataapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView nametext,regtext,phonetext,display;
    EditText nameedit,regedit,phoneedit;
    Button senddata,recdata;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     nameedit=(EditText) findViewById(R.id.nameedit);
     regedit=(EditText) findViewById(R.id.regedit);
     phoneedit=(EditText) findViewById(R.id.phoneedit);
     senddata=(Button)findViewById(R.id.senddata);
     recdata=(Button)findViewById(R.id.recdata);
     display=(TextView)findViewById(R.id.display);

     firebaseDatabase=FirebaseDatabase.getInstance();
     reference=firebaseDatabase.getReferenceFromUrl("https://dataapp-531cc.firebaseio.com/");

     senddata.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             reference.setValue(nameedit.getText().toString());
             /*
         -----------------------------------------------------------
         Here it is simple code to a write a text in database what we are doing is we are creating a object of firebasedatabase
         and having our database instance in it now we are getting our database reference with the help of url
              */
             /*
             reference.child(regedit.getText().toString()).child("Name").setValue(nameedit.getText().toString());
             reference.child(regedit.getText().toString()).child("Phone no").setValue(phoneedit.getText().toString());
            -------------------------------------------------------------------------------------------------------------
            If we use setValue function with child then the child would act as key and we would give value to it on the
            other hand if we want to make category then we will not use setvalue function with instead we will call one more child
            function
             */
         }
     });
     recdata.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             /*

             firebaseDatabase.getReference(regedit.getText().toString()).addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(DataSnapshot dataSnapshot) {
                     display.setText(dataSnapshot.getValue().toString());
                 }

                 @Override
                 public void onCancelled(DatabaseError databaseError) {

                 }
             });

             --------------------------------------------------------------------------------------------------------------
             Here is the simple code to get Value of any key first we have to get the reference of key then we have to extract the
             value associated with the key.
             */
         }
     });
    }
}
