package com.djinggoo.getkos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.djinggoo.getkos.data.Dummy;
import com.djinggoo.getkos.utils.TFLite;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class PredictionActivity extends AppCompatActivity
        implements DialogFacilities.DialogFacilitiesListener, NavigationView.OnNavigationItemSelectedListener {

    private AutoCompleteTextView dropdownCityItems;
    private AutoCompleteTextView dropdownAreaItems;
    private AutoCompleteTextView dropdownTypeItems;

    private TextInputEditText resultTextInput;
    private TextView textFacilities;

    private Boolean isBathroomSelected = false;
    private Boolean isWifiSelected = false;
    private Boolean isAccessSelected = false;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    private TFLite tfLite;

    ArrayAdapter<String> adapterAreaItems = null;
    List<String> dynamicAreas;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        Button buttonSelectFacilities = findViewById(R.id.btn_select_facilities);
        Button buttonCalculate = findViewById(R.id.btn_calculate);
        dropdownCityItems = findViewById(R.id.dropdown_city_items);
        dropdownAreaItems = findViewById(R.id.dropdown_area_items);
        dropdownTypeItems = findViewById(R.id.dropdown_type_items);
        resultTextInput = findViewById(R.id.textinput_result);
        textFacilities = findViewById(R.id.text_facilities);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        buttonSelectFacilities.setOnClickListener(view -> openDialogFacilities());

        List<String> cities = Dummy.getCityItems();
        List<String> areas = Dummy.getAreaItems();
        List<String> types = Dummy.getTypeItems();
        buttonCalculate.setOnClickListener(view -> {

            Integer cityValue = cities.indexOf(dropdownCityItems.getText().toString()) + 1;
            Integer areaValue = areas.indexOf(dropdownAreaItems.getText().toString()) + 1;
            Integer typeValue = types.indexOf(dropdownTypeItems.getText().toString()) + 1;

            Integer inferenceVal = (int) Math.ceil(doInference(cityValue, areaValue, typeValue, isBathroomSelected, isWifiSelected, isAccessSelected));
            Integer hundredRoundUp = 0;
            if (inferenceVal != 0) hundredRoundUp = (100 - (inferenceVal % 100)) + inferenceVal;

            String result = "Rp. " + (hundredRoundUp.toString()) + " / month";
            resultTextInput.setText(result);

        });

        ArrayAdapter<String> adapterCityItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.city_items,
                cities
        );

        ArrayAdapter<String> adapterTypeItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.type_kos_items,
                types
        );

        dropdownCityItems.setAdapter(adapterCityItems);
        dropdownCityItems.setOnFocusChangeListener((view, b) -> {
            if (!view.hasFocus()) {
                dropdownAreaItems.setText("");
                String city = dropdownCityItems.getText().toString();
                if (!Dummy.getCityItems().contains(city)) {
                    Toast.makeText(getApplicationContext(), "Pilih Kota Yang Sesuai!", Toast.LENGTH_SHORT).show();
                    dynamicAreas = new ArrayList<>();
                } else {
                    if (city.equalsIgnoreCase("bandung"))
                        dynamicAreas = Dummy.getBandungAreaItems();
                    else if (city.equalsIgnoreCase("yogyakarta"))
                        dynamicAreas = Dummy.getJogjaAreaItems();
                    else if (city.equalsIgnoreCase("jakarta"))
                        dynamicAreas = Dummy.getjakartaAreaItems();
                    else if (city.equalsIgnoreCase("malang"))
                        dynamicAreas = Dummy.getMalangAreaItems();
                    else if (city.equalsIgnoreCase("semarang"))
                        dynamicAreas = Dummy.getSemarangAreaItems();
                    else if (city.equalsIgnoreCase("surabaya"))
                        dynamicAreas = Dummy.getSurabayaAreaItems();
                }
                adapterAreaItems = new ArrayAdapter<>(PredictionActivity.this, R.layout.area_items, dynamicAreas);
                dropdownAreaItems.setAdapter(adapterAreaItems);
            }
        });


        dropdownTypeItems.setAdapter(adapterTypeItems);

//        Toolbar
        setSupportActionBar(toolbar);

//        navigation drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_prediction);

        tfLite = new TFLite(getAssets());
    }

    public void openDialogFacilities() {
        DialogFacilities dialogFacilities = new DialogFacilities();
        dialogFacilities.show(getSupportFragmentManager(), "Dialog Facilities");
    }

    @Override
    public void applySelection(Float bathroomVal, Float wifiVal, Float accessVal) {
        String facilities = "Facilities : ";
        if (bathroomVal != 0) {
            facilities += "Bathroom inside";
            if ((wifiVal != 0) || (accessVal != 0)) facilities += ", ";
        }
        if (wifiVal != 0) {
            facilities += "Wifi";
            if ((accessVal != 0)) facilities += ", ";
        }
        if (accessVal != 0) {
            facilities += "24 hour access";
        }

        textFacilities.setText(facilities + ".");
    }

    private Float doInference(Integer cityValue, Integer areaValue, Integer typeValue, Boolean isBathroomSelected, Boolean isWifiSelected, Boolean isAccessSelected) {
        if (cityValue == 0) {
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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_prediction:
                break;
            case R.id.nav_bookmark:
                Intent iBookmark = new Intent(PredictionActivity.this, BookmarkActivity.class);
                startActivity(iBookmark);
                break;
            case R.id.nav_help_center:
                Intent iHelpCenter = new Intent(PredictionActivity.this, HelpCenterAcitivity.class);
                startActivity(iHelpCenter);
                onResume();
                break;
            case R.id.nav_about:
                Intent iAbout = new Intent(PredictionActivity.this, AboutActivity.class);
                startActivity(iAbout);
                onResume();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "ON RESUME");

        navigationView.setCheckedItem(R.id.nav_prediction);
//        navigationView.chec

    }
}
