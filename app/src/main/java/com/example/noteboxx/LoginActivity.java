package com.example.noteboxx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {
    TextView toregister;
    ImageView homemain;

    TextView forgotpass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        forgotpass = findViewById(R.id.forgot_pass);
        homemain = findViewById(R.id.home);
        toregister = findViewById(R.id.toregisteracc);


        toregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });


        homemain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, LoginorregisterActivity.class);
                startActivity(intent);
                finish();
            }
        });



        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pototoy = new Intent(LoginActivity.this,ForgotpasswordActivity.class);
                startActivity(pototoy);

            }
        });




    }
}