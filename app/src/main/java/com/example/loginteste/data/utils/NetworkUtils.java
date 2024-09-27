package com.example.loginteste.data.utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkUtils {
    private static final String url = "https://es.eva.inf.br/eva/mobileWS";

    public static Request getGetRequest(String path) {
        String completeUrl = url + "/" + path;

        return new Request.Builder()
                .url(completeUrl)
                .build();
    }

    public static Request getPostRequest(String path, RequestBody formBody) {
        String completeUrl = url + "/" + path;

        return new Request.Builder()
                .url(completeUrl)
                .post(formBody)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

    }
}