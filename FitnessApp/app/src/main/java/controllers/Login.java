package com.example.ku62245.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        mAuth = FirebaseAuth.getInstance();

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        final TextView setCreateAccount = (TextView) findViewById(R.id.createAccounttextView);

        setCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, createAccount.class);
                Login.this.startActivity(i);
            }
        });

        }
/*
    @Override
    public void onStart(){
        super.onStart();
        //Checks if user is signed in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        setContentView(R.layout.login_screen);
    }*/


}
