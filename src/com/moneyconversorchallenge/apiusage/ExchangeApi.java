package com.moneyconversorchallenge.apiusage;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeApiCall {
    private static String URI_DIRECTION = "https://v6.exchangerate-api.com/v6/134349369ac792bd4b7c8eab/latest/";

    public double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URI_DIRECTION + fromCurrency))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);

            JsonObject convertionRates = jsonResponse.getAsJsonObject("conversion_rates");

            return convertionRates.get(toCurrency).getAsDouble();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
