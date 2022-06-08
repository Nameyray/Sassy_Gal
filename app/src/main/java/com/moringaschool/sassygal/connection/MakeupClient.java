package com.moringaschool.sassygal.connection;

import com.moringaschool.sassygal.models.Constants;
import com.moringaschool.sassygal.interfaces.MakeupAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MakeupClient {
    private static Retrofit retrofit = null;

    public static MakeupAPI getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.MAKEUP_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(MakeupAPI.class);
    }
}
