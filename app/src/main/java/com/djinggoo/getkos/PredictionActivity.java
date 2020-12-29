package com.djinggoo.getkos;

import android.content.Intent;
import android.os.Bundle;
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


    /* please delete me if u finishing the problem */
    private ImageView imageViewFb;
    private ImageView imageViewInst;
    private ImageView imageViewTw;


    private TFLite tfLite;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        ArrayList<String> data = getIntent().getStringArrayListExtra("cities");

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

        imageViewFb = findViewById(R.id.ximg_facebook_icon);
        imageViewFb.setOnClickListener(view ->{
            Intent intent = new Intent(PredictionActivity.this, AboutActivity.class);
            startActivity(intent);
        });

        imageViewInst = findViewById(R.id.ximg_instagram_icon);
        imageViewInst.setOnClickListener(view -> {
            Intent intent = new Intent(PredictionActivity.this, HelpCenterAcitivity.class);
            startActivity(intent);
        });

        imageViewTw = findViewById(R.id.ximg_twitter_icon);
        imageViewTw.setOnClickListener(view -> {
            Intent intent = new Intent(PredictionActivity.this, BookmarkActivity.class);
            startActivity(intent);
        });

        buttonSelectFacilities.setOnClickListener(view -> openDialogFacilities());

        List<String> cities = Dummy.getCityItems();
        List<String> areas = Dummy.getAreaItems();
        List<String> types = Dummy.getTypeItems();

        buttonCalculate.setOnClickListener(view -> {

            Integer cityValue = cities.indexOf(dropdownCityItems.getText().toString())+1;
            Integer areaValue = areas.indexOf(dropdownAreaItems.getText().toString())+1;
            Integer typeValue = types.indexOf(dropdownTypeItems.getText().toString())+1;

            Integer inferenceVal = (int) Math.ceil(doInference(cityValue, areaValue, typeValue, isBathroomSelected, isWifiSelected, isAccessSelected));
            String result = "Rp. " + (inferenceVal.toString()) + " / month";

            resultTextInput.setText(result);

        });

        ArrayAdapter<String> adapterCityItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.city_items,
                cities
        );

        ArrayAdapter<String> adapterAreaItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.area_items,
                areas
        );

        ArrayAdapter<String> adapterTypeItems = new ArrayAdapter<>(
                PredictionActivity.this,
                R.layout.type_kos_items,
                types
        );

        dropdownCityItems.setAdapter(adapterCityItems);
        dropdownAreaItems.setAdapter(adapterAreaItems);
        dropdownTypeItems.setAdapter(adapterTypeItems);

//        Toolbar
        setSupportActionBar(toolbar);

//        navigation drawer menu
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setCheckedItem(R.id.nav_prediction);

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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_prediction:
                break;
            case R.id.nav_bookmark:
                Intent iBookmark = new Intent(PredictionActivity.this, BookmarkActivity.class);
                startActivity(iBookmark);
                break;
            case R.id.nav_help_center:
                Intent iHelpCenter = new Intent(PredictionActivity.this, HelpCenterAcitivity.class);
                startActivity(iHelpCenter);
                break;
            case R.id.nav_about:
                Intent iAbout = new Intent(PredictionActivity.this, AboutActivity.class);
                startActivity(iAbout);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
