package com.geekster.Chucknooris;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class ChucknoorisApplication {

	public static void main(String[] args) throws Exception {

		URL getUrl = new URL("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");


		int responseCode = connection.getResponseCode();

		if (responseCode == 200) {


			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder jsonResponseData = new StringBuilder();
			String readLine = null;


			while ((readLine = in.readLine()) != null) {
				jsonResponseData.append(readLine);
			}

			in.close();

			JSONObject masterData = new JSONObject(jsonResponseData.toString());

			System.out.println(masterData);

		}
	}
}
