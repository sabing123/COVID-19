package com.example.covid_19.API;
import com.example.covid_19.Response.JSONResponse;
import com.example.covid_19.model.Nepalidetails;
import com.example.covid_19.model.listofcountry;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LOC {
    @GET("data/world")
    Call<List<listofcountry>> getList();

    @GET("news")
    Call<JSONResponse> getJSON();

    @GET("data/nepal")
    Call<Nepalidetails> getnepal();

}
