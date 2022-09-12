package com.maekandex.contactapp;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    ImageView location, web, happy,phone ;
    Button button;
    TextView tv;

    final private int create_contact = 1;
    String name = "", number = "", website = "", mylocation = "", mood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location = findViewById(R.id.location);
        web = findViewById(R.id.web);
        happy = findViewById(R.id.happy);
        phone = findViewById(R.id.phone);
        button = findViewById(R.id.button);
        tv = findViewById(R.id.tv);


        web.setVisibility(View.GONE);
        location.setVisibility(View.GONE);
        happy.setVisibility(View.GONE);
        phone.setVisibility(View.GONE);
        tv.setVisibility(View.GONE);







        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q" + mylocation));
                startActivity(intent);

            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + website));
                startActivity(intent);

            }
        });



        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                startActivity(intent);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(MainActivity.this, com.maekandex.contactapp.createContact.class);
              startActivityForResult(intent, create_contact);

//               Intent i = new Intent(getApplicationContext(), createContact.class);
//               startActivity(i);

            }
        });

        tv.setText(name);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == create_contact){
            if(resultCode == RESULT_OK){

                web.setVisibility(View.VISIBLE);
                location.setVisibility(View.VISIBLE);
                happy.setVisibility(View.VISIBLE);
                phone.setVisibility(View.VISIBLE);
                tv.setVisibility(View.VISIBLE);



                name = data.getStringExtra("name");
                number = data.getStringExtra("phone");
                website = data.getStringExtra("web");
                mylocation = data.getStringExtra("location");
                mood = data.getStringExtra("mood");
                tv.setText(name);



                if(mood.equals("happy")){
                    happy.setImageResource(R.drawable.happy);
                } else if (mood.equals("okay")) {
                    happy.setImageResource(R.drawable.okay);


                } else {
                    happy.setImageResource(R.drawable.angry);
                }



            }
        }else {
            Toast.makeText(this, "No data was passed", Toast.LENGTH_SHORT).show();
        }


    }
}