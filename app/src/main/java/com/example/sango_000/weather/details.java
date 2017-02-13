package com.example.sango_000.weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by sango_000 on 11-02-17.
 */
public class details {
    private String cod = null;
    private String main = null;

    private static ArrayList<details> det = new ArrayList<>();

    public static void parse(String json) throws JSONException {
        JSONArray jsonStudents = new JSONArray(json);

        for (int i=0; i<jsonStudents.length(); i++) {
            JSONObject jsonStudent = jsonStudents.getJSONObject(i);

            String codName = jsonStudent.getString("cod");

            if(codName.length() != 0)
                det.add(getCod(codName));
        }
    }

    details(String cod) {

        this.cod = cod;
    }

    private static details getCod(String codName) {

        return new details(codName);
    }

    public static String[] getCods() {
        String[] cods = new String[det.size()];
        for (int i=0; i<det.size(); i++) {
            cods[i] = det.get(i).cod;
        }

        return cods;
    }


}
