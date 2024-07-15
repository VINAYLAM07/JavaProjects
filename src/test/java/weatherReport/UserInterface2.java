package weatherReport;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UserInterface2{
public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
        String city;
        do {
            System.out.println("========================");
            System.out.println("Enter City Name (No to exit) :");
            city = sc.nextLine();
            if (city.equalsIgnoreCase("No")) {
                System.out.println("Thank You for Using Our Application :)");
                break;
            }

            JSONObject cityLocationData = getLocationData(city);
            if (cityLocationData != null) {
                double latitude = ((Number) cityLocationData.get("latitude")).doubleValue();
                double longitude = ((Number) cityLocationData.get("longitude")).doubleValue();
                displayWeatherData(latitude, longitude);
            } else {
                System.out.println("Could not find location data for " + city);
            }
        } while (!city.equalsIgnoreCase("No"));
    } catch (Exception e) {
        System.err.println("An error occurred: " + e.getMessage());
        e.printStackTrace();
    }
}

public static JSONObject getLocationData(String city) {
    city = city.replaceAll(" ", "+");
    String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" + city
            + "&count=1&language=en&format=json";
    try {
        HttpURLConnection apiConnection = fetchApiResponse(urlString);

        if (apiConnection.getResponseCode() != 200) {
            System.out.println("Error: Couldn't connect to API. Response code: " + apiConnection.getResponseCode());
            return null;
        }

        String jsonResponse = readApiResponse(apiConnection);

        JSONParser parser = new JSONParser();
        JSONObject resultJsonObj = (JSONObject) parser.parse(jsonResponse);

        JSONArray cpLocationData = (JSONArray) resultJsonObj.get("results");
        return cpLocationData.isEmpty() ? null : (JSONObject) cpLocationData.get(0);

    } catch (IOException | ParseException e) {
        System.err.println("Error processing location data: " + e.getMessage());
        e.printStackTrace();
    }

    return null;
}
public static void displayWeatherData(double longitude, double latitude) {
	try {
	String weatherUrl = "https://api.open-meteo.com/v1/forecast?latitude="+latitude+"&longitude="+longitude+"&current=temperature_2m,precipitation,wind_speed_10m";
	HttpURLConnection apiConnection = fetchApiResponse(weatherUrl);
	
	if(apiConnection.getResponseCode() != 200) {
			System.out.println("Error : Coudn't connect to API");
			return;
	}
	String jsonResponse = readApiResponse(apiConnection);
	JSONParser parser = new JSONParser();
	JSONObject jsonobject =(JSONObject)parser.parse(jsonResponse);
	JSONObject currentWeatherJson = (JSONObject) jsonobject.get("current");
	System.out.println("Current Time: "+currentWeatherJson.get("time"));
	System.out.println("Temperature: "+currentWeatherJson.get("temperature_2m"));
	System.out.println("Precipitation: "+currentWeatherJson.get("precipitation"));
	System.out.println("Weather Description: "+currentWeatherJson.get("wind_speed_10m"));
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static HttpURLConnection fetchApiResponse(String Url) {

	try {
		URL url = new URL(Url);
		HttpURLConnection hcnt = (HttpsURLConnection) url.openConnection();
		hcnt.setRequestMethod("GET");
		return hcnt;

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

public static String readApiResponse(HttpURLConnection apiConnection) {

	try {
		StringBuilder resultJson = new StringBuilder();

		Scanner sc = new Scanner(apiConnection.getInputStream());
		while (sc.hasNext()) {
			resultJson.append(sc.nextLine());
		}

		sc.close();
		return resultJson.toString();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return null;

}
}
