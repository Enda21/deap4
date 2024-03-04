package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {

	public static Object getJsonStringValueByKey(JSONObject json, String key) {
		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;
		if (!exists) {
			keys = json.keys();

			while (keys.hasNext()) {
				nextKeys = (String) keys.next();
				try {
					if (json.get(nextKeys) instanceof JSONObject) {
						if (exists == false) {
							getJsonStringValueByKey(json.getJSONObject(nextKeys), key);
						}
					} else if (json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for (int i = 0; i < jsonarray.length(); i++) {
							String jsonarrayString = jsonarray.get(i).toString();
							JSONObject innerJSOn = new JSONObject(jsonarrayString);
							if (exists == false) {
								getJsonStringValueByKey(innerJSOn, key);
							}
						}
					}
				} catch (Exception e) {
				}
			}
		}

		else {
			System.out.println("json get value:" + json.get(key));

			/*
			 * //json.getDouble(key); if(json.get(key) instanceof Long||json.get(key)
			 * instanceof Double||json.get(key) instanceof String||json.get(key) instanceof
			 * Integer) { System.out.println("json get value double :"+json.get(key)); }
			 */
			return json.get(key);

		}
		return "";
	}

	public static Object getNestedJsonStringValueByKey(JSONObject json, String key) {
		Object jsonObject = null;
		String[] keys = key.trim().split("\\.");
		for (String s : keys) {
			try {
				jsonObject = getJsonStringValueByKey(json, s.trim());
				System.out.println("Key: " + s + "\n Value: " + jsonObject);
				json = (JSONObject) jsonObject;
			} catch (Exception e) {
				if (e.getMessage().contains("org.json.JSONArray cannot be cast to org.json.JSONObject")) {
				}
			}
		}
		return jsonObject;
	}

	public static List<HashMap<String, Object>> getJsonArrayValueAsListOfMap(Object json) {
		List<HashMap<String, Object>> listOfMap = new ArrayList<HashMap<String, Object>>();
		JSONArray jArray = new JSONArray(json.toString());
		for (int i = 0; i < jArray.length(); i++) {
			HashMap<String, Object> hMap = new HashMap<String, Object>();
			hMap.clear();
			Iterator<String> keysItr = ((JSONObject) jArray.get(i)).keys();
			while (keysItr.hasNext()) {
				String key = keysItr.next();
				Object value = ((JSONObject) jArray.get(i)).get(key);
				hMap.put(key, value);
				// System.out.println("Key: "+key+" Value: "+value);
			}
			listOfMap.add(hMap);
		}
		return listOfMap;
	}

	public static void readJsonFile(String fPath) throws ParseException {
		JSONParser parser = new JSONParser();

		try {

			SuiteConstants.jsonString = parser.parse(new FileReader(fPath));
			System.out.println("Json File read" + SuiteConstants.jsonString);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (ParseException e) {

			e.printStackTrace();
		} finally {
			if (SuiteConstants.jsonString == null) {
				System.out.println("Failed to read '" + fPath + "' JSON file");
			}

		}

	}

	public static void main(String[] args) {
		// String inputJson =
		// "{\"fid\":\"0001\",\"ftype\":\"donut\",\"fname\":\"Cake\",\"fppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"},{\"id\":\"1002\",\"type\":\"Chocolate\"},{\"id\":\"1003\",\"type\":\"Blueberry\"},{\"id\":\"1004\",\"type\":\"Devil's
		// Food\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5005\",\"type\":\"Sugar\"},{\"id\":\"5007\",\"type\":\"Powdered
		// Sugar\"},{\"id\":\"5006\",\"type\":\"Chocolate with
		// Sprinkles\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]}";
		JSONObject json = new JSONObject(SuiteConstants.jsonString);
		Object gopani = getNestedJsonStringValueByKey(json, "SurveyEvidenceChecklistComplete");
		System.out.println("SurveyEvidenceChecklistComplete:" + gopani);
		gopani = getNestedJsonStringValueByKey(json, "Dwelling.DwellingID");
		System.out.println("Dwelling.DwellingID:" + gopani);
		System.out.println("List of :" + getJsonArrayValueAsListOfMap(gopani));

	}
}