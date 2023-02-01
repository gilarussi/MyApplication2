package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {

    Button btnToReg, login;
    EditText emailLogin, passwordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        login.setOnClickListener(this);

        btnToReg = findViewById(R.id.btnToReg);
        btnToReg.setOnClickListener(this);

        emailLogin = findViewById(R.id.emailLogin);
        emailLogin.setOnClickListener(this);

        passwordLogin = findViewById(R.id.passwordLogin);
        passwordLogin.setOnClickListener(this);



    }
    @Override
    public void onClick (View view){
        if(view==btnToReg)
        {
            Intent intent = new Intent(getApplicationContext(),register.class);
            startActivity(intent);
        }
        if(view==login)
        {
            if (emailLogin.getText().toString().equals("") || passwordLogin.getText().toString().equals(""))
            {
                Toast.makeText(login.this, "empty", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    }
}