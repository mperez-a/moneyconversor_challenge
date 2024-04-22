package com.moneyconversorchallenge.apiusage;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeApi {
    private static String API_KEY = "/134349369ac792bd4b7c8eab/";

    public static double conversor(String fromCurrency, String toCurrency, double amountToConvert) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting().create();

        try {
            String uri_direction = "https://v6.exchangerate-api.com/v6" + API_KEY + "latest/" + fromCurrency;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri_direction))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            double exchangeRate = conversionRates.get(toCurrency).getAsDouble();

            return (Conversor.moneyConversor(amountToConvert, exchangeRate));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
