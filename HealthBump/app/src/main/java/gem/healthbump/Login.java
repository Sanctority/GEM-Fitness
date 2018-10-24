package gem.healthbump;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    EditText editTextusername = (EditText) findViewById(R.id.editTextUsername);
    EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
    TextView textViewSingUp = (TextView) findViewById(R.id.textViewCreateAccount);
    Button loginBtn = findViewById(R.id.loginBtn);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        textViewSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, SignUp.class);
                Login.this.startActivity(i);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
