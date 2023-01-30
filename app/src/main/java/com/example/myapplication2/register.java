package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity implements View.OnClickListener {

    Button btnToLogin, btnResume;
    EditText usernameRegister, passwordRegister, phone, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnToLogin = findViewById(R.id.btnToLogin);
        btnToLogin.setOnClickListener(this);

        btnResume = findViewById(R.id.btnResume);
        btnResume.setOnClickListener(this);

        usernameRegister = findViewById(R.id.usernameRegister);
        usernameRegister.setOnClickListener(this);

        passwordRegister = findViewById(R.id.passwordRegister);
        passwordRegister.setOnClickListener(this);

        phone = findViewById(R.id.phone);
        phone.setOnClickListener(this);

        email = findViewById(R.id.email);
        email.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if(view==btnToLogin)
        {
            Intent intent = new Intent(getApplicationContext(),login.class);
            startActivity(intent);
        }
        if(view==btnResume)
        {
            if (usernameRegister.getText().toString().equals("") || passwordRegister.getText().toString().equals("") || phone.getText().toString().equals("") || email.getText().toString().equals(""))
            {
                Toast.makeText(register.this, "empty", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    }
}
