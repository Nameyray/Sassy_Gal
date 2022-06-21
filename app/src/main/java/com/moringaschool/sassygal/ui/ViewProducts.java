package com.moringaschool.sassygal.ui;

import static com.moringaschool.sassygal.models.Constants.MAKEUP_BASE_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.moringaschool.sassygal.R;
import com.moringaschool.sassygal.adapters.RecyclerAdapter;
import com.moringaschool.sassygal.connection.MakeupClient;
import com.moringaschool.sassygal.interfaces.MakeupAPI;
import com.moringaschool.sassygal.models.Constants;
import com.moringaschool.sassygal.models.Response;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;


public class ViewProducts extends AppCompatActivity {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    public static final String TAG= ViewProducts.class.getSimpleName();

    MakeupAPI makeupAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);

        ButterKnife.bind(this);

        //call the API
        Response response = (Response) getIntent().getSerializableExtra("Product");
        makeupAPI = MakeupClient.getClient();

        Call<List<Response>> call = makeupAPI.searchResponse();
        call.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
              if(response.isSuccessful()){
                  RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getApplicationContext(), response.body());
                  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                  recycler.setLayoutManager(linearLayoutManager);
//                  recycler.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(this,R.anim.down_to_up_layout_animation));
                  recycler.setAdapter(recyclerAdapter);
              }
            }

            @Override
            public void onFailure(Call<List<Response>> call, Throwable t) {
                Log.e(TAG, "ERROR", t);
                Toast.makeText(ViewProducts.this, "oops!Something went wrong", Toast.LENGTH_LONG).show();


            }
        });
    }
}