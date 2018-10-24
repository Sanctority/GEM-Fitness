package gem.healthbump.controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import gem.healthbump.R;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText emailEditText, usernameEditText, passEditText, rePassEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        emailEditText = findViewById(R.id.emailS);
        usernameEditText = findViewById(R.id.usernameS);
        passEditText = findViewById(R.id.passwordS);
        rePassEditText = findViewById(R.id.repasswordS);

        findViewById(R.id.signUpBtn).setOnClickListener(this);

    }

    public void createAccount(){
        String email = emailEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        String password = passEditText.getText().toString().trim();
        String repassword = rePassEditText.getText().toString().trim();


    }
    
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signUpBtn:
            createAccount();
            break;
        }
    }
}
