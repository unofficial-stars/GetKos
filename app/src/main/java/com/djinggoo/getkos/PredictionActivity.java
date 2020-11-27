package com.djinggoo.getkos;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.djinggoo.getkos.data.Dummy;
import com.djinggoo.getkos.utils.TFLite;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;
import java.util.List;

public class PredictionActivity extends AppCompatActivity implements DialogFacilities.DialogFacilitiesListener {

    private AutoCompleteTextView dropdownCityItems;
    private AutoCompleteTextView dropdownAreaItems;
    private AutoCompleteTextView dropdownTypeItems;

    private TextInputEditText resultTextInput;
    private TextView textFacilities;

    private Boolean isBathroomSelected = false;
    private Boolean isWifiSelected = false;
    private Boolean isAccessSelected = false;

    private TFLite tfLite;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        Button buttonSelectFacilities = findViewById(R.id.btn_select_facilities);
        Button buttonCalculate = findViewById(R.id.btn_calculate);
        dropdownCityItems = (AutoCompleteTextView) findViewById(R.id.dropdown_city_items);
        dropdownAreaItems = (AutoCompleteTextView) findViewById(R.id.dropdown_area_items);
        dropdownTypeItems = (AutoCompleteTextView) findViewById(R.id.dropdown_type_items);
        resultTextInput = findViewById(R.id.textinput_result);
        textFacilities = findViewById(R.id.text_facilities);

        buttonSelectFacilities.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogFacilities();

            }
        });

        buttonCalculate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> cities = Arrays.asList(Dummy.getCityItems());
                Integer cityValue = cities.indexOf(dropdownCityItems.getText().toString())+1;

                List<String> areas = Arrays.asList(Dummy.getAreaItems());
                Integer areaValue = areas.indexOf(dropdownAreaItems.getText().toString())+1;

                List<String> types = Arrays.asList(Dummy.getTypeItems());
                Integer typeValue = types.indexOf(dropdownTypeItems.getText().toString())+1;

                Float result = doInference(cityValue, areaValue, typeValue, isBathroomSelected, isWifiSelected, isAccessSelected);
                resultTextInput.setText(result.toString());
            }
        });

        ArrayAdapter<String> adapterCityItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.city_items,
                Dummy.getCityItems()
        );

        ArrayAdapter<String> adapterAreaItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.area_items,
                Dummy.getAreaItems()
        );

        ArrayAdapter<String> adapterTypeItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.type_kos_items,
                Dummy.getTypeItems()
        );

        dropdownCityItems.setAdapter(adapterCityItems);
        dropdownAreaItems.setAdapter(adapterAreaItems);
        dropdownTypeItems.setAdapter(adapterTypeItems);

        tfLite = new TFLite(getAssets());
    }

    public void openDialogFacilities(){
        DialogFacilities dialogFacilities = new DialogFacilities();
        dialogFacilities.show(getSupportFragmentManager(), "Dialog Facilities");
    }

    @Override
    public void applySelection(Float bathroomVal, Float wifiVal, Float accessVal) {
        String facilities = "Fasilitas : ";
        if (bathroomVal != 0) facilities += "Kamar Mandi Dalam, ";
        if (wifiVal != 0) facilities += "Wifi, ";
        if (accessVal != 0) facilities += "Akses 24 Jam ";

        textFacilities.setText(facilities);
    }

    private Float doInference(Integer cityValue, Integer areaValue, Integer typeValue, Boolean isBathroomSelected, Boolean isWifiSelected, Boolean isAccessSelected){
        if (cityValue == 0){
            Toast.makeText(getApplicationContext(), "Pilih Kota Yang Sesuai!", Toast.LENGTH_SHORT).show();
            return 0f;
        }
        if (areaValue == 0) {
            Toast.makeText(getApplicationContext(), "Pilih Area Yang Sesuai!", Toast.LENGTH_SHORT).show();
            return 0f;
        }
        if (typeValue == 0) {
            Toast.makeText(getApplicationContext(), "Pilih Tipe Kos Yang Sesuai", Toast.LENGTH_SHORT).show();
            return 0f;
        }

        Float city = Float.valueOf(cityValue);
        Float area = Float.valueOf(areaValue);
        Float type = Float.valueOf(typeValue);
        Float facilities = (float) ((isBathroomSelected ? 2 : 0) + (isWifiSelected ? 2 : 0) + (isAccessSelected ? 2 : 0));

        return tfLite.doInference(city, area, type, facilities);
    }

}
