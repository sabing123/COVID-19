package com.example.covid_19;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class URL {

        public static final String base_url = "https://nepalcorona.info/api/v1/"; //localhost ip address


        public static Retrofit getInstance() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
        }

    }

