package com.djinggoo.getkos.utils;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonTools {

    private String CITY_JSONFILE_PATH = "src/main/assets/data-city.json";
    private String BOARDINGTYPE_JSONFILE_PATH = "src/main/assets/data-boarding.json";

    public static String fileToString(String path) throws IOException {
        File file = new File(path);
        StringBuilder stringBuilder = new StringBuilder();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        String response = stringBuilder.toString();

        return response;
    }

}
