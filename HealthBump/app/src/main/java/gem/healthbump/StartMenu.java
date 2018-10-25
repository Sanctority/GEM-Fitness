package gem.healthbump;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class StartMenu extends AppCompatActivity implements View.OnClickListener {

    TextView textViewWelcome, textViewYourWorkouts, textViewDiets;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_menu);

        textViewWelcome = findViewById(R.id.textViewWelcome);
        textViewYourWorkouts = findViewById(R.id.textViewYourWorkouts);
        textViewDiets = findViewById(R.id.textViewDiets);
        mAuth = FirebaseAuth.getInstance();

    }

    public void getYourWorkouts(){

    }

    public void getDiets(){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.textViewYourWorkouts):
                getYourWorkouts();
                break;
            case (R.id.textViewDiets):
                getDiets();
                break;
        }
    }
}
