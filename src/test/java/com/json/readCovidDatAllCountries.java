package com.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class readCovidDatAllCountries {

    public static void main(String[] args) throws IOException, ParseException {

        // Data Provided
        URL url = new URL("https://api.covid19api.com/summary");

        // Make Connection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        // Get Response Code
        int responseCode = conn.getResponseCode();

        // If response code is not successful terminate the Java Code
        if (responseCode != 200) {
            System.out.println("Web Service Response Code: " + responseCode);
            System.exit(0);
        }

        // Read data from Web Service
        StringBuilder inline = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());

        // Get Data line by one
        while (scanner.hasNext())
            inline.append(scanner.nextLine());


        //Using the JSON simple library parse the string into a json object
        JSONParser parse = new JSONParser();
        JSONObject data_obj = (JSONObject) parse.parse(inline.toString());

        JSONArray countries = (JSONArray) data_obj.get("Countries");

        for (Object o : countries) {
            JSONObject country = (JSONObject) o;
            System.out.printf("%-35s : %,15d %n",country.get("Country"),(Long) country.get("TotalConfirmed"));
        }

        scanner.close();
    }


}
