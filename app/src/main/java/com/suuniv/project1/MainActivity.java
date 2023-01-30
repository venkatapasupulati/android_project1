package com.suuniv.project1;

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

        Button easyButton = (Button) findViewById(R.id.easy);
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEasyActivity();
            }
        });

        Button mediumButton = (Button) findViewById(R.id.medium);
        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMediumActivity();
            }
        });

        Button hardButton = (Button) findViewById(R.id.hard);
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHardActivity();
            }
        });
    }


    public void openEasyActivity(){
        Intent intent = new Intent(this, EasyActivity.class);
        startActivity(intent);
    }

    public void openMediumActivity(){
        Intent intent = new Intent(this, MediumActivity.class);
        startActivity(intent);
    }

    public void openHardActivity(){
        Intent intent = new Intent(this, HardActivity.class);
        startActivity(intent);
    }
}