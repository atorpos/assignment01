package org.assignment01.assignment01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.Gson;
import okhttp3.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataGather {

    public List<List<Object>> GetDataCURL() throws IOException {
        String url = "https://s.awoz.co/class/comp1011/temperature.json";
//        String jsobBody = "{}";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
//                    .post(RequestBody.create(MediaType.parse("application/json"), jsobBody))
                .build();

//        try (Response response = client.newCall(request).execute()) {
//
//            if(response.isSuccessful()) {
//                String responseBody = response.body().string();
//                return parseJsonResponse(responseBody);
//            } else {
//                throw new IOException("Unexpected HTTP response: " + response);
//            }
//        }

            Response response = client.newCall(request).execute();

            int statusCode = response.code();
            System.out.println("Response Code: " + statusCode);

            String responseBody = response.body().string();
            System.out.println("Response Body: " + responseBody);

            com.google.gson.JsonArray jsonArray = JsonParser.parseString(responseBody).getAsJsonArray();
            List<List<Object>> resultlist = new ArrayList<>();
            for (com.google.gson.JsonElement element: jsonArray){
                if(element.isJsonObject()) {
                    com.google.gson.JsonObject post = element.getAsJsonObject();
                    String StringDate = post.get("date").getAsString();
                    String StringAPM = post.get("section").getAsString();
                    int temperature = post.get("value").getAsInt();
//                    System.out.println("Date" + StringDate);
//                    System.out.println("Day or Night" + StringAPM);
//                    System.out.println("Temperature" + temperature);
                    resultlist.add(List.of(StringDate,StringAPM,temperature));
                }
            }
            return resultlist;
    }

    private static List<WeatherEntry> parseJsonResponse(String jsonResponse) {
        List<WeatherEntry> weatherEntries = new ArrayList<>();

        JsonArray jsonArray = JsonParser.parseString(jsonResponse).getAsJsonArray();
        for (JsonElement element : jsonArray) {
            if (element.isJsonObject()) {
                WeatherEntry entry = new Gson().fromJson(element, WeatherEntry.class);
                weatherEntries.add(entry);
            }
        }
        System.out.println(weatherEntries);

        return weatherEntries;
    }
}
