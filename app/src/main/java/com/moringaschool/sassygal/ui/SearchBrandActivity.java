package com.moringaschool.sassygal.ui;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.sassygal.R;
import com.moringaschool.sassygal.adapters.FirebaseSassyGalViewHolder;
import com.moringaschool.sassygal.models.Constants;
import com.moringaschool.sassygal.models.Response;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchBrandActivity extends AppCompatActivity implements View.OnClickListener{


    //declaring properties in the brand search class
    @BindView(R.id.search_button)
    Button search;
    @BindView(R.id.fav)
    Button favourite;
    private DatabaseReference mProductReference;
    private FirebaseRecyclerAdapter<Response, FirebaseSassyGalViewHolder> mFirebaseAdapter;


    private FirebaseDatabase db = FirebaseDatabase.getInstance();
//    private DatabaseReference root = db.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_brand);

        //Binding the properties using Butter knife
        ButterKnife.bind(this);


        //onclickListener method for the search button
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SearchBrandActivity.this, ViewProducts.class);
                startActivity(intent);
        }
        });

    }

    @Override
    public void onClick(View v) {

    }

        }

