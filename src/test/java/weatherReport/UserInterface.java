package weatherReport;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
class fontColour{
	protected static String RESET = "\u001B[0m";
    protected static String RED = "\u001B[31m";
    protected static String GREEN = "\u001B[32m";
    protected static String YELLOW = "\u001B[33m";
}
public class UserInterface extends fontColour{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Scanner sc = new Scanner(System.in);
			String city;
			do {
				System.out.println("===================================");
				System.out.println("Enter City Name (No to exit) :");
				city = sc.nextLine();
				if (city.equalsIgnoreCase("No")) {
					System.out.println(RED+"Thank You for Using Our Application :)"+RESET);
					break;
				}
			JSONObject cityLocationData = (JSONObject) getLocationData(city);
			double latitude = (Double)cityLocationData.get("latitude");
			double longitude = (Double)cityLocationData.get("longitude");
			displayWeatherData(latitude,longitude);	
			System.out.println(RED+"Thank You for Using Our Application :) "+RESET);
			} while (!city.equalsIgnoreCase("No"));
			
		} catch (Exception e) {
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
				System.out.println("Error Couldn't connect to Api");
				return null;
			}

			String Jsonresponse = readApiResponse(apiConnection);

			JSONParser parser = new JSONParser();
			JSONObject resultJsonObj = (JSONObject) parser.parse(Jsonresponse);

			JSONArray cpLocationData = (JSONArray) resultJsonObj.get("results");
			return (JSONObject) cpLocationData.get(0);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	public static void displayWeatherData(double longitude, double latitude) {
		try {
//		String weatherUrl = "https://api.open-meteo.com/v1/forecast?latitude="+latitude+"&longitude="+latitude+"&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m";
		String weatherUrl = "https://api.open-meteo.com/v1/forecast?latitude="+latitude+"&longitude="+longitude+"&current=temperature_2m,relative_humidity_2m,wind_speed_10m";
		HttpURLConnection apiConnection = fetchApiResponse(weatherUrl);
		
		if(apiConnection.getResponseCode() != 200) {
				System.out.println("Error : Coudn't connect to API");
				return;
		}
		String jsonResponse = readApiResponse(apiConnection);
		JSONParser parser = new JSONParser();
		JSONObject jsonobject =(JSONObject)parser.parse(jsonResponse);
		JSONObject currentWeatherJson = (JSONObject) jsonobject.get("current");
		System.out.println(GREEN+"Current Time: "+YELLOW+currentWeatherJson.get("time")+RESET);
		System.out.println(GREEN+"Temperature (c): "+YELLOW+currentWeatherJson.get("temperature_2m")+RESET);
		System.out.println(GREEN+"Humidity (%): "+YELLOW+currentWeatherJson.get("relative_humidity_2m")+RESET);
		System.out.println(GREEN+"Wind Speed (km/h): "+YELLOW+currentWeatherJson.get("wind_speed_10m")+RESET);
		
		} catch (Exception e) {
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
