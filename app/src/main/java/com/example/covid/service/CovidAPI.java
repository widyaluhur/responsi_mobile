package com.example.covid.service;

import com.example.covid.model.faskes.FaskesResponse;
import com.example.covid.model.kasus.KasusResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidAPI {
    String URL_BASE = "https://covid19-public.digitalservice.id/api/v1/";

    @GET("rekapitulasi_v2/jabar/harian")
    Call<KasusResponse> getCoronaCase();

    @GET("sebaran_v2/jabar/faskes")
    Call<FaskesResponse> getFaskes();

}
