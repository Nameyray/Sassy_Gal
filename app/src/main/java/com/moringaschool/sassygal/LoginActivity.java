
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
    EditText TextEmailAddress;
    @BindView(R.id.editTextTextPassword)
    EditText TextPassword;
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
        String EmailAddress = TextEmailAddress.getText().toString();
        String Password = TextPassword.getText().toString();

    //if else statement to ensure right credentials are entered
        if (EmailAddress.isEmpty()  || !EmailAddress.contains("@")){
            showError(TextEmailAddress, "Email is not valid");

        }else if(Password.isEmpty()  ||Password.length()<3){
            showError(TextPassword, "Password must be 3 characters");
        }else{
            //create a toast popup for the login method
            Toast.makeText(this, "Login method", Toast.LENGTH_SHORT).show();
        }
    }

    //method to show error
    private void showError(EditText input, String string) {
        input.setError(string);
        input.requestFocus();

    }

}