package controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import models.User;

public class createAccount extends AppCompatActivity implements View.OnClickListener{

    private EditText email, usernameText, password, rePassword;

    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        email = findViewById(R.id.emailEditText);
        usernameText = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passEditText);
        rePassword = findViewById(R.id.rePassEditText);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.createAccountBtn).setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null){
            //User already logged in handle
        }
    }

    public void createUserAccount(){
        final String emailAddress = email.getText().toString().trim();
        final String username = usernameText.getText().toString().trim();
        String passwordUser = password.getText().toString().trim();
        String rePass = rePassword.getText().toString().trim();

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

        if (username.isEmpty()){
            usernameText.setError("You forgot to enter your username");
            usernameText.requestFocus();
            return;
        }

        if (rePass.isEmpty()){
            rePassword.setError("Don't forget to re enter your password");
            rePassword.requestFocus();
            return;
        }

        if (passwordUser.isEmpty()){
            password.setError("Your forgot to enter your password");
            password.requestFocus();
            return;
        }

        if (!passwordUser.equals(rePass)){
            password.setError("The passwords do not match please re enter them");
            password.requestFocus();
        }

        mAuth.createUserWithEmailAndPassword(emailAddress, passwordUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //Store additional information of User
                    User user = new User();
                    user.setUsername(username);
                    user.setEmail(emailAddress);

                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(createAccount.this.getString(R.string.registrationSuccess), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(createAccount.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

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

