package com.example.noteboxx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class LoginorregisterActivity extends AppCompatActivity {

    MaterialButton loginbutton;
    MaterialButton registerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginorregister);

        loginbutton = findViewById(R.id.login_btn);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginorregisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        registerbutton = findViewById(R.id.register_btn);

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginorregisterActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}