package com.moringaschool.sassygal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.moringaschool.sassygal.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchBrandActivity extends AppCompatActivity implements View.OnClickListener{


    //declaring properties in the brand search class
    @BindView(R.id.search_button)
    Button search;
    @BindView(R.id.back_button)
    Button back;

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

        Intent intent = new Intent(SearchBrandActivity.this, ProductSearchActivity.class);
        startActivity(intent);

    }
}