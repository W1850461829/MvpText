package com.navy.http;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonUtil {
	/**
	 * @param jsonData
	 * @param rstList
	 * @param params
	 * @func hashmap追加字段
	 */
	public static void   JsonToHashMap(JSONObject jsonData, Map<String, Object> rstList, String... params) {
		try {
			for (Iterator<String> keyStr = jsonData.keys(); keyStr.hasNext();) {

				String key1 = keyStr.next().trim();
				if (jsonData.get(key1) instanceof JSONObject) {
					HashMap<String, Object> mapObj = new HashMap<String, Object>();
					JsonToHashMap((JSONObject) jsonData.get(key1), mapObj, params);
					rstList.put(key1, mapObj);
					continue;
				}
				if (jsonData.get(key1) instanceof JSONArray) {
					ArrayList<Object> arrayList = new ArrayList<Object>();

					JsonToHashMap((JSONArray) jsonData.get(key1), arrayList, params);
					rstList.put(key1, arrayList);
					continue;
				}
				JsonToHashMap(key1, jsonData.get(key1), rstList);
			}
			// 追加字段
			if (params != null && params.length == 2) {
				rstList.put(params[0], params[1]);
			}
			if (params != null && params.length == 4) {
				rstList.put(params[0], params[1]);
				rstList.put(params[2], params[3]);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	public static void JsonToHashMap(JSONArray jsonarray, List<Object> rstList, String... params) {
		try {
			for (int i = 0; i < jsonarray.length(); i++) {
				if (jsonarray.get(i) instanceof JSONObject) {

					HashMap<String, Object> mapObj = new HashMap<String, Object>();
					JsonToHashMap((JSONObject) jsonarray.get(i), mapObj, params);
					rstList.add(mapObj);
					continue;
				}
				JsonToArray(jsonarray.get(i), rstList);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	public static void JsonToArray(Object value, List<Object> rstList) {
       rstList.add(value);
	}

	public static void JsonToHashMap(String key, Object value, Map<String, Object> rstList) {

		rstList.put(key, value);
	}

	public static String getRaw(Context context, int RawId) {

		try {
			InputStream is = context.getResources().openRawResource(RawId);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			// StringBuffer线程安全；StringBuilder线程不安全
			StringBuffer sb = new StringBuffer();
			for (String str = null; (str = reader.readLine()) != null;) {
				sb.append(str);
			}
			return sb.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getAsset(Context context, String fileName) {

		try {
			InputStream is = context.getResources().getAssets().open(fileName);
			// StringBuffer线程安全；StringBuilder线程不安全
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuffer sb = new StringBuffer();
			for (String str = reader.readLine(); str != null;) {
				sb.append(str);
			}
			return sb.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
