package com.maekandex.contactapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class createContact extends AppCompatActivity implements View.OnClickListener{


    EditText edname, edphone, edlocation, edweb;
   ImageView happyc, okay, angry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        edname = findViewById(R.id.edname);
        edphone = findViewById(R.id.edphone);
        edlocation = findViewById(R.id.edlocation);
        edweb = findViewById(R.id.ediweb);

        happyc = findViewById(R.id.happyc);
        okay = findViewById(R.id.okay);
        angry = findViewById(R.id.angry);

        happyc.setOnClickListener(this);
        okay.setOnClickListener(this);
        angry.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        if(edname.getText().toString().trim().isEmpty() || edphone.getText().toString().trim().isEmpty()
        || edlocation.getText().toString().trim().isEmpty() || edweb.getText().toString().trim().isEmpty()){

            Toast.makeText(this, "Ensure you fill the form", Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent();
            intent.putExtra("name", edname.getText().toString().trim());
            intent.putExtra("phone", edphone.getText().toString().trim());
            intent.putExtra("web", edweb.getText().toString().trim());
            intent.putExtra("location", edlocation.getText().toString().trim());

            if (view.getId() == R.id.happyc){

                intent.putExtra("mood", "Happy");

            } else if (view.getId() == R.id.okay) {

                intent.putExtra("mood", "Okay");

            }else {

                intent.putExtra("mood", "Sad");

            }
            setResult(RESULT_OK, intent);
            createContact.this.finish();
        }

    }
}