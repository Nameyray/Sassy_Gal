package com.moringaschool.sassygal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.moringaschool.sassygal.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductSearchActivity extends AppCompatActivity {

    //declaring properties in the product search class
    @BindView(R.id.button2)
    Button button;
    @BindView(R.id.google)
    Button google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_search);

        //Binding the properties using Butter knife
        ButterKnife.bind(this);

        //implicit intent to take one to google browser
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });

        //onclickListener method for the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(ProductSearchActivity.this, SearchBrandActivity.class);
                    startActivity(intent);
                }
        });

    }
//    //onclickListener method for the button
//        button.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//        Response response = MakeupClient.getClient().searchResponse(Response.class);
//        Call<Response> call = Response.getAllData();
//            call.enqueue(new Callback<Response>(){
//                @Override
//                public void onResponse(Call<Response> call, Response<Response> response) {
//
//                }
//
//                @Override
//                public void onFailure(Call<Response> call, Throwable t) {
//
//
//                }
//            }
//
//    });

}
