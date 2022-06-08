
package com.moringaschool.sassygal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.sassygal.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    //declaring the properties to be used in the login activity
    @BindView(R.id.textView7)
    TextView btn;
    @BindView(R.id.editTextTextEmailAddress)
    EditText textEmailAddress;
    @BindView(R.id.editTextTextPassword)
    EditText textPassword;
    @BindView(R.id.button4)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        //Register if not registered
        TextView log = findViewById(R.id.textView7);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });


        ButterKnife.bind(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCredentials()) {
                    Intent intent = new Intent(LoginActivity.this, ProductSearchActivity.class);
                    startActivity(intent);
                }
            }

        });

    }
    //Method to check the credentials for logging in

    private boolean checkCredentials () {
        String emailAddress = textEmailAddress.getText().toString();
        String password = textPassword.getText().toString();
        boolean isCorrect = false;

        //if else statement to ensure right credentials are entered
        if (emailAddress.isEmpty() || !emailAddress.contains("@")) {
            showError("Email is not valid");

        } else if (password.isEmpty() || password.length() < 3) {
            showError("Password must be 3 characters");
        } else {
            //create a toast popup for the login method
            Toast.makeText(this, "Login method", Toast.LENGTH_SHORT).show();
            isCorrect = true;
        }
        return isCorrect;
    }

    //method to show error
    private void showError (String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

    }

}