package com.example.testapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Button1 (Add)
        final Button btn1 = (Button) findViewById(R.id.button1);
        // Perform action on click
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Open Form Add
                Intent newActivity = new Intent(MainActivity.this,AddActivity.class);
                startActivity(newActivity);

            }
        });

        // Button2 (Show)
        final Button btn2 = (Button) findViewById(R.id.button2);
        // Perform action on click
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Open Form Show
                Intent newActivity = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(newActivity);

            }
        });

        // Button3 (Update)
        final Button btn3 = (Button) findViewById(R.id.button3);
        // Perform action on click
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Open Form ListUpdate
                Intent newActivity = new Intent(MainActivity.this,UpdateActivity.class);
                startActivity(newActivity);

            }
        });

        // Button4 (Delete)
        final Button btn4 = (Button) findViewById(R.id.button4);
        // Perform action on click
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Open Form ListDelete
                Intent newActivity = new Intent(MainActivity.this,DeleteActivity.class);
                startActivity(newActivity);

            }
        });

        // Button4 (Add Api)
        final Button btn5 = (Button) findViewById(R.id.button5);
        // Perform action on click
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Open Form ListDelete
                Intent newActivity = new Intent(MainActivity.this,AddApiActivity.class);
                startActivity(newActivity);

            }
        });
    }
}
