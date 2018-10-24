package gem.healthbump;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    EditText editTextUsername, editTextEmail, editTextPass, editTextRePass;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        editTextEmail = findViewById(R.id.emailS);

        mAuth = FirebaseAuth.getInstance();


    }

    public void createUserAccount(){
        String email = editTextEmail.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();
        String passwordUser = editTextPass.getText().toString().trim();
        String rePass = editTextRePass.getText().toString().trim();

        if (email.isEmpty()){
            editTextEmail.setError("You forgot to enter your email address");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (username.isEmpty()){
            editTextUsername.setError("You forgot to enter your username");
            editTextUsername.requestFocus();
            return;
        }

        if (rePass.isEmpty()){
            editTextRePass.setError("Don't forget to re enter your password");
            editTextRePass.requestFocus();
            return;
        }

        if (passwordUser.isEmpty()){
            editTextPass.setError("Your forgot to enter your password");
            editTextPass.requestFocus();
            return;
        }

        if (!passwordUser.equals(rePass)){
            editTextPass.setError("The passwords do not match please re enter them");
            editTextPass.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, passwordUser)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        task.isSuccessful(){

                        }
                    }
                });



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signUpBtn:
                createUserAccount();
                break;
        }
    }
}
