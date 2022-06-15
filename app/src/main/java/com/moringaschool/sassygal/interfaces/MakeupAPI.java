package com.moringaschool.sassygal.interfaces;

import com.moringaschool.sassygal.models.Response;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MakeupAPI {
    @GET("products.json")
    Call<List<Response>> searchResponse();

}
