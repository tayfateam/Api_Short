package com.json;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WeatherReport {

    public static void main(String[] args) throws IOException {

        String apiKey = "afc1387bb4cc87d707e38e9ac478f034";
        String serviceAPI = "https://api.openweathermap.org/data/2.5/weather?q=";
        String location = "New York City";
        String units = "metric";
        String URI = serviceAPI + location + "&appid=" + apiKey + "&units=" + units;

        //System.out.println(URI);

        // Connection
        URL url = new URL(URI);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();


        //System.out.println(responseCode);

        // Check response code
        if (responseCode != 200) {
            System.out.println("Web Service Response Code: " + responseCode);
            System.exit(0);
        }




    }


}
