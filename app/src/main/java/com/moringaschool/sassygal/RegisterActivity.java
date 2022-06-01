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

public class RegisterActivity extends AppCompatActivity {

    //declaring the properties in Register activity
    @BindView(R.id.textView4)
    TextView btn;
    @BindView(R.id.editTextTextPersonName2)
    EditText textPersonName2;
    @BindView(R.id.editTextTextEmailAddress)
    EditText textEmailAddress;
    @BindView(R.id.editTextTextPassword)
    EditText textPassword;
    @BindView(R.id.button3)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //binding the properties using butterknife
        ButterKnife.bind(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
      

        //onclickListener method for the button
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkCredentials()){
                    Intent intent = new Intent(RegisterActivity.this, ProductListActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    //method to check the register method credentials
    private boolean checkCredentials() {
        String personName2 = textPersonName2.getText().toString();
        String emailAddress = textEmailAddress.getText().toString();
        String password = textPassword.getText().toString();
        boolean isCorrect = false;

        if (personName2.isEmpty()  || !personName2.contains("@")){
            showError("Name is not valid");

        }else if (emailAddress.isEmpty()  || !emailAddress.contains("@")){
                showError("Email is not valid");

        }else if(password.isEmpty()  ||password.length()<3){
            showError("Password must be 3 characters");
        }else{
            //create a toast popup for the Register method
            Toast.makeText(this, "Register method", Toast.LENGTH_SHORT).show();
            isCorrect = true;
        }
        return isCorrect;
    }



    //method to show error
    private void showError( String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();


    }


}

