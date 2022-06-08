package com.moringaschool.sassygal.ui;

import static com.moringaschool.sassygal.models.Constants.MAKEUP_BASE_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.moringaschool.sassygal.R;
import com.moringaschool.sassygal.connection.MakeupClient;
import com.moringaschool.sassygal.interfaces.MakeupAPI;
import com.moringaschool.sassygal.models.Constants;
import com.moringaschool.sassygal.models.Response;

import retrofit2.Call;
import retrofit2.Callback;


public class ViewProducts extends AppCompatActivity {
    MakeupAPI makeupAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);

        //call the API
        Response response = (Response) getIntent().getSerializableExtra("Product");
        makeAPI = MakeupClient.getClient();

        Call<Response> call = makeupAPI().searchResponse, Constants.MAKEUP_BASE_URL);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}