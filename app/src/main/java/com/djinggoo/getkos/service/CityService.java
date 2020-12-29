package com.djinggoo.getkos.service;

import android.content.res.AssetManager;

import com.djinggoo.getkos.data.City;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class CityService {

    private String CITY_JSONFILE_PATH = "data-city.json";

    public void readCity(AssetManager assetManager){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(assetManager.open(CITY_JSONFILE_PATH));
            List<City> cities = mapper.readValue(root.get("kota").toString(), new TypeReference<List<City>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
