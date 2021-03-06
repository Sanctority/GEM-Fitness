package gem.healthbump;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    EditText editTextUsername, editTextEmail, editTextPass, editTextRePass;
    ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        findViewById(R.id.signUpBtn).setOnClickListener(this);
        progressBar = findViewById(R.id.progressBarSignUp);

        editTextEmail = findViewById(R.id.emailS);
        editTextUsername = findViewById(R.id.usernameS);
        editTextPass = findViewById(R.id.passwordS);
        editTextRePass = findViewById(R.id.repasswordS);

        progressBar.setVisibility(View.GONE);

        mAuth = FirebaseAuth.getInstance();

    }

   /* @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }*/

    public void createUserAccount(){

        final String email = editTextEmail.getText().toString().trim();
        final String username = editTextUsername.getText().toString().trim();
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

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, passwordUser)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(username, email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()){
                                        Toast.makeText(SignUp.this, getString(R.string.account_created), Toast.LENGTH_LONG).show();
                                        Intent toStartMenu = new Intent(SignUp.this, StartMenu.class);
                                        SignUp.this.startActivity(toStartMenu);

                                    }else{
                                        Toast.makeText(SignUp.this, getString(R.string.account_error), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(getApplicationContext(), "Email already registered", Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
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
