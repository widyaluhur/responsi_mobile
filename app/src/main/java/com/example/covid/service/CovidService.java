package com.example.covid.service;

import com.example.covid.model.faskes.DataItem;
import com.example.covid.model.faskes.FaskesResponse;
import com.example.covid.model.kasus.ContentItem;
import com.example.covid.model.kasus.KasusResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CovidService {
    private Retrofit retrofit = null;

    public CovidAPI getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(CovidAPI.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CovidAPI.class);
    }

    public void getKasus(final CovidListener<List<ContentItem>> listener){
        getAPI().getCoronaCase().enqueue(new Callback<KasusResponse>() {
            @Override
            public void onResponse(Call<KasusResponse> call, Response<KasusResponse> response) {
                KasusResponse data = response.body();

                if (data != null && data.getData() != null){
                    listener.onSuccess(data.getData().getContent());
                }
            }

            @Override
            public void onFailure(Call<KasusResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    public void getFaskes(final CovidListener<List<DataItem>> listener){
        getAPI().getFaskes().enqueue(new Callback<FaskesResponse>() {
            @Override
            public void onResponse(Call<FaskesResponse> call, Response<FaskesResponse> response) {
                FaskesResponse data = response.body();

                if (data != null && data.getData() != null){
                    listener.onSuccess(data.getData());
                }
            }

            @Override
            public void onFailure(Call<FaskesResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
