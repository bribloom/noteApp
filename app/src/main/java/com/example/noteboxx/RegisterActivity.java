package com.example.noteboxx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    TextView gologin;
    ImageView homemaintwo;
    FirebaseAuth firebaseAuth;
    MaterialButton registerbutton;
    EditText name, emailaddress, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        firebaseAuth=FirebaseAuth.getInstance();

        name = findViewById(R.id.mname);
        emailaddress = findViewById(R.id.email_address);
        password = findViewById(R.id.password);
        homemaintwo = findViewById(R.id.home);
        gologin = findViewById(R.id.gologinacc);
        registerbutton = findViewById(R.id.mregister);


        gologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        homemaintwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginorregisterActivity.class);
                startActivity(intent);
                finish();
            }
        });


        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vname=name.getText().toString().trim();
                String vpassword=password.getText().toString().trim();
                String vemailaddress=emailaddress.getText().toString().trim();


                if (vpassword.isEmpty() || vemailaddress.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"ALL FIELDS ARE REQUIRED",Toast.LENGTH_SHORT).show();
                }
                else if (vpassword.length()<7)
                {
                    Toast.makeText(getApplicationContext(),"PASSWORD SHOULD GREATER THAN 7 DIGITS",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //register the user to firebase
                    firebaseAuth.createUserWithEmailAndPassword(vemailaddress,vpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"REGISTRATION SUCCESSFUL",Toast.LENGTH_SHORT).show();
                                sendEmailVerifcication();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"FAILED TO SEND VERIFICATION EMAIL",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }

            }
        });

    }
    private void sendEmailVerifcication()
    {
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if (firebaseUser!=null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(),"VERIFICATION EMAIL IS SENT, VERIFY AND LOGIN AGAIN",Toast.LENGTH_SHORT).show();
                    firebaseAuth.signOut();
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                }

            });
        }

    }
}