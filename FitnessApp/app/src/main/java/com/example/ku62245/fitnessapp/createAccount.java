package com.example.ku62245.fitnessapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class createAccount extends AppCompatActivity implements View.OnClickListener{

    private EditText email, name, surname, dob, height, weight;
    public Button createAccountBnt;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        dob = findViewById(R.id.dob);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);

        findViewById(R.id.createAccountBtn).setOnClickListener(this);



    }

    public void createUserAccount(){
        String emailAddress = email.getText().toString().trim();
        String nameUser = name.getText().toString().trim();
        String surnameUser = surname.getText().toString().trim();
        Integer heightUser = Integer.parseInt(height.getText().toString());
        Integer weightUser = Integer.parseInt(weight.getText().toString());

        if (emailAddress.isEmpty()){
            email.setError("You forgot to enter your email address");
            email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()){
            email.setError("Enter a valid email");
            email.requestFocus();
            return;
        }

        if (nameUser.isEmpty()){
            name.setError("You forgot to enter your name");
            name.requestFocus();
            return;
        }

        if (surnameUser.isEmpty()){
            surname.setError("Your forgot to enter your Surname");
            surname.requestFocus();
            return;
        }
            //comment
        if (heightUser < 30){
            height.setError("You forgot to enter your height or that height is too low");
            height.requestFocus();
            return;
        }

        if (weightUser < 20){
            height.setError("You forgot to enter your weight or that weight is too low");
            height.requestFocus();
            return;
        }
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.createAccountBtn:
                createUserAccount();
                break;
        }
    }

    }

