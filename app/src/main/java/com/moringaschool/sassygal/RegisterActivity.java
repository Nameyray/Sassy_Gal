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
    EditText TextPersonName2;
    @BindView(R.id.editTextTextEmailAddress)
    EditText TextEmailAddress;
    @BindView(R.id.editTextTextPassword)
    EditText TextPassword;
    @BindView(R.id.button3)
    Button btnRegister;
//    TextView btn;
//    private EditText TextPersonName2, TextEmailAddress, TextPassword;
//    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //binding the properties using butterknife
        ButterKnife.bind(this);

//        btn= findViewById(R.id.textView4);
//        TextPersonName2= findViewById(R.id.editTextTextPersonName2);
//        TextEmailAddress= findViewById(R.id.editTextTextEmailAddress);
//        TextPassword= findViewById(R.id.editTextTextPassword);
//        btnRegister=findViewById(R.id.button3);
//        btnRegister.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                checkCredentials();
//
//            }
//        });
//
//        //onclickListener method for the button
//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(RegisterActivity.this, ProductLIstActivity.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//
//    //method to check the register method credentials
//    private void checkCredentials() {
//        String textPersonName2= TextPersonName2.getText().toString();
//        String EmailAddress = TextEmailAddress.getText().toString();
//        String Password = TextPassword.getText().toString();
//
//        if (textPersonName2.isEmpty() || TextPersonName2.length()<3){
//            showError(TextPersonName2, "Your name is not valid");
//
//        }else if (EmailAddress.isEmpty()  || !EmailAddress.contains("@")){
//            showError(TextEmailAddress, "Email is not valid");
//
//        }else if(Password.isEmpty()  ||Password.length()<3){
//            showError(TextPassword, "Password must be 3 characters");
//        }else{
//
//            //create a toast popup for the register activity
//            Toast.makeText(this, "Registration method", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    //method to show error
//    private void showError(EditText input, String string) {
//        input.setError(string);
//        input.requestFocus();
//
//        }

    }

