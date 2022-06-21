package com.moringaschool.sassygal.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.sassygal.R;

import java.util.HashMap;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {
   public static  final  String TAG = CreateAccountActivity.class.getSimpleName();
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    //declaring the properties in Register activity
    @BindView(R.id.textView4)
    TextView btn;
    @BindView(R.id.editTextTextPersonName2)
    EditText textPersonName2;
    @BindView(R.id.editTextTextEmailAddress)
    EditText textEmailAddress;
    @BindView(R.id.editTextTextPassword)
    EditText textPassword;
    @BindView(R.id.editTextTextPassword2)
    EditText textConfirmPassword;
    @BindView(R.id.button3)
    Button btnRegister;
    @BindView(R.id.button5)
    Button btnData;
    @BindView(R.id.firebaseProgressBar)
    ProgressBar mSignInProgressBar;
    @BindView(R.id.loadingTextView)
    TextView mLoadingSignUp;
    private String mName;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        //binding the properties using butterknife
        ButterKnife.bind(this);

       //getInstance of firebaseAuth object
        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(this);
        btn.setOnClickListener(this);
        btnData.setOnClickListener(this);
        createAuthStateListener();

    }

    @Override
    public void onClick(View view) {
        String name = textPersonName2.getText().toString();
        String email = textEmailAddress.getText().toString();
        String password = textPassword.getText().toString();

        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("name", name);
        userMap.put("email", email);
        userMap.put("password", password);

        root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(CreateAccountActivity.this, "Your credentials are saved", Toast.LENGTH_SHORT).show();
            }
        });

        if (view == btn){
            Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        if (view == btnRegister){
            createNewUser();
            Intent intent = new Intent(CreateAccountActivity.this, WelcomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        if (view == btnData){
            Intent intent = new Intent(CreateAccountActivity.this, ShowDataActivity.class);
        }

    }

    private void createNewUser(){
        //fetch contents of the registering form
        final String name = textPersonName2.getText().toString().trim();
        final String email = textEmailAddress.getText().toString().trim();
        String password = textPassword.getText().toString().trim();
        String confirmPassword = textConfirmPassword.getText().toString().trim();
        mName = textPersonName2.getText().toString().trim();

       //ensure the credentials are correct before creating an account to firebase
        boolean validEmail = isValidEmail(email);
        boolean validName = isValidName(name);
        boolean validPassword = isValidPassword(password, confirmPassword);
        boolean validmName = isValidName(mName);

        if (!validEmail || !validName || !validPassword) return;

        showProgressBar();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        hideProgressBar();

                        if (task.isSuccessful()) {
                            Log.d(TAG, "Authentication successful");
                            //new firebase user successfully created
                            createFirebaseUserProfile(Objects.requireNonNull(task.getResult().getUser()));
                        } else {
                            Toast.makeText(CreateAccountActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }

                });
    }


    //listening for user authentication
    private void createAuthStateListener(){
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(CreateAccountActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    //validate a name is entered
    private boolean isValidName(String name){
        if(name.equals("")){
            textPersonName2.setError("Please enter your name");
            return false;
        }
        return true;
    }

    //check the email address if it is valid
    private boolean isValidEmail(String email) {
        boolean isGoodEmail = (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if(!isGoodEmail){
          textEmailAddress.setError("Please enter a valid email address");
            return false;
        }
        return isGoodEmail;
    }

    //check the passwords do match
    private boolean isValidPassword(String password, String confirmPassword){
        if(password.length() < 6){
            textPassword.setError("Please create a password containing at least 6 characters");
            return false;
        } else if (!password.equals(confirmPassword)){
            textConfirmPassword.setError("Passwords do not match");
            return false;
        }
        return true;
    }

    private void showProgressBar() {
        mSignInProgressBar.setVisibility(View.VISIBLE);
        mLoadingSignUp.setVisibility(View.VISIBLE);
        mLoadingSignUp.setText("Sign Up process in Progress");
    }

    private void hideProgressBar() {
        mSignInProgressBar.setVisibility(View.GONE);
        mLoadingSignUp.setVisibility(View.GONE);
    }

   //setting the users name
    private void createFirebaseUserProfile(final FirebaseUser user){
        UserProfileChangeRequest addProfileName = new UserProfileChangeRequest.Builder()
                .setDisplayName(mName)
                .build();

        user.updateProfile(addProfileName)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, Objects.requireNonNull(user.getDisplayName()));
                            Toast.makeText(CreateAccountActivity.this, "The display name has been set",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}