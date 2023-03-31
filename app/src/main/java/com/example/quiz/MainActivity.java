package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView quiz;
    TextView choose;
    Button java,c_lan,python;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quiz=findViewById(R.id.quiz);
        choose=findViewById(R.id.choose);
        java= findViewById(R.id.java);
        c_lan=findViewById(R.id.c_lan);
        python=findViewById(R.id.python);

        java.setOnClickListener(view -> {
            Intent it=new Intent(MainActivity.this,secondActivity.class);
            startActivity(it);

        });

        c_lan.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,thirdActivity.class);
            startActivity(intent);
        });

        python.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,fourthActivity.class);
            startActivity(intent);
        });
    }
}