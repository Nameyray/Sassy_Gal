package com.moringaschool.sassygal.interfaces;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MakeupAPI {
    @GET("http://makeup-api.herokuapp.com/api/v1/products.json")
    Call<Response> searchProduct(@Query("brand") String brand,
                                 @Query("product_type")String product_type);


}
