
package com.moringaschool.sassygal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

//    TextView btn;
//    EditText TextEmailAddress, TextPassword;
//    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        //binding the properties using butterknife
        ButterKnife.bind(this);

//        btn= findViewById(R.id.textView7);
//        TextEmailAddress= findViewById(R.id.editTextTextEmailAddress);
//        TextPassword= findViewById(R.id.editTextTextPassword);
//        btnLogin=findViewById(R.id.button4);
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                checkCredentials();

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ProductListActivity.class);
                startActivity(intent);
            }

        });

    }
    //Method to check the credentials for logging in
    private void checkCredentials() {
        String emailAddress = textEmailAddress.getText().toString();
        String password = textPassword.getText().toString();

    //if else statement to ensure right credentials are entered
        if (emailAddress.isEmpty()  || !emailAddress.contains("@")){
            showError("Email is not valid");

        }else if(password.isEmpty()  ||password.length()<3){
            showError("Password must be 3 characters");
        }else{
            //create a toast popup for the login method
            Toast.makeText(this, "Login method", Toast.LENGTH_SHORT).show();
        }
    }

    //method to show error
    private void showError( String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

    }

}