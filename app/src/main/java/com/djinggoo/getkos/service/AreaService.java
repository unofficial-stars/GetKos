package com.djinggoo.getkos.service;

import android.content.res.AssetManager;

import com.djinggoo.getkos.data.Area;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AreaService {

    private String AREA_JSONFILE_PATH = "data-area.json";

    public void readArea(AssetManager assetManager) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(assetManager.open(AREA_JSONFILE_PATH));
            List<Area> areas = mapper.readValue(root.get("area").toString(), new TypeReference<List<Area>>() {});
            for (Area area : areas) System.out.println(area.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
