package com.traxxiontech.savebox.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import java.util.concurrent.TimeUnit;

public class ApiClient {
    private static final String OMEGATECH_BASE_URL = "https://omegatech-api.dixonomega.tech/";
    private static final String DAVIDCYRIL_BASE_URL = "https://apis.davidcyril.name.ng/";
    
    private static Retrofit omegaTechRetrofit;
    private static Retrofit davidCyrilRetrofit;

    public static Retrofit getOmegaTechInstance() {
        if (omegaTechRetrofit == null) {
            omegaTechRetrofit = new Retrofit.Builder()
                    .baseUrl(OMEGATECH_BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return omegaTechRetrofit;
    }

    public static Retrofit getDavidCyrilInstance() {
        if (davidCyrilRetrofit == null) {
            davidCyrilRetrofit = new Retrofit.Builder()
                    .baseUrl(DAVIDCYRIL_BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return davidCyrilRetrofit;
    }

    private static OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public static ApiService getOmegaTechService() {
        return getOmegaTechInstance().create(ApiService.class);
    }

    public static ApiService getDavidCyrilService() {
        return getDavidCyrilInstance().create(ApiService.class);
    }
}