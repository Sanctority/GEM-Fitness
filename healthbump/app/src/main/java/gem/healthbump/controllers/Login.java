package gem.healthbump.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import gem.healthbump.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        EditText username = (EditText) findViewById(R.id.editTextUsername);
        EditText passoword = (EditText) findViewById(R.id.editTextPassword);
        TextView editTextCreateAccount = (TextView) findViewById(R.id.editTextCreateAccount);

        editTextCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, SignUp.class);
                Login.this.startActivity(i);
            }
        });


    }
}
