package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class resume extends AppCompatActivity implements View.OnClickListener {

    Button btnToApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        btnToApp=findViewById(R.id.btnToApp);
        btnToApp.setOnClickListener(this);
        }
    @Override
    public void onClick(View view) {

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
    }
}