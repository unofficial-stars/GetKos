package com.djinggoo.getkos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class PredictionActivity extends AppCompatActivity {

    private AutoCompleteTextView dropdownCityItems;
    private AutoCompleteTextView dropdownAreaItems;
    private AutoCompleteTextView dropdownBFItems;
    private AutoCompleteTextView dropdownSFItems;
    private AutoCompleteTextView dropdownFacilitiesItems;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        dropdownCityItems = findViewById(R.id.dropdown_city_items);
        dropdownAreaItems = findViewById(R.id.dropdown_area_items);
        dropdownBFItems = findViewById(R.id.dropdown_bf_items);
        dropdownFacilitiesItems = findViewById(R.id.dropdown_facilities_items);
        dropdownSFItems = findViewById(R.id.dropdown_sf_items);

        String[] cityItems = new String[]{
          "surabaya", "malang", "yogyakarta", "semarang"
        };
        String[] facilitiesItems = new String[]{
                "facilities 1", "facilities 2", "facilities 3", "facilities 4"
        };
        String[] bathroomsFacilitiesItems = new String[]{
                "bathroom fac 1", "bathroom fac 2", "bathroom fac 3", "bathroom fac 4"
        };
        String[] areaItems = new String[]{
                "area 1", "area 2", "area 3", "area 4"
        };
        String[] sharedFacilitiesItems = new String[]{
                "sf 1", "sf 2", "sf 3", "sf 4"
        };

        ArrayAdapter<String> adapterCityItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.city_items,
                cityItems
        );

        ArrayAdapter<String> adapterAreaItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.area_items,
                areaItems
        );

        ArrayAdapter<String> adapterFacilitesItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.facilities_items,
                facilitiesItems
        );

        ArrayAdapter<String> adapterBathroomsFacItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.bathroom_facilities_items,
                bathroomsFacilitiesItems
        );

        ArrayAdapter<String> adapterSharedFacItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.shared_facilities_items,
                sharedFacilitiesItems
        );

        dropdownCityItems.setAdapter(adapterCityItems);
        dropdownAreaItems.setAdapter(adapterAreaItems);
        dropdownFacilitiesItems.setAdapter(adapterFacilitesItems);
        dropdownBFItems.setAdapter(adapterBathroomsFacItems);
        dropdownSFItems.setAdapter(adapterSharedFacItems);

    }
}
