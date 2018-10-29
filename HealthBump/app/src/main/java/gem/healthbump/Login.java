package gem.healthbump;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity  implements View.OnClickListener {

    EditText editTextEmail, editTextPassword;
    TextView textViewSingUp;
    Button loginBtn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSingUp = (TextView) findViewById(R.id.textViewCreateAccount);
        loginBtn = findViewById(R.id.loginBtn);

        mAuth = FirebaseAuth.getInstance();

    }

    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        mAuth.signInWithEmailAndPassword(email, password){

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.textViewSignupMessage):
                Intent i = new Intent(Login.this, SignUp.class);
                Login.this.startActivity(i);
                break;
            case (R.id.loginBtn):
                userLogin();
                break;
        }
    }
}
