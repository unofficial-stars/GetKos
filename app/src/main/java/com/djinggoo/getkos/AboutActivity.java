package com.djinggoo.getkos;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class AboutActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        drawerLayout = findViewById(R.id.drawer_layout_about);
        navigationView = findViewById(R.id.nav_view_about);
        toolbar = findViewById(R.id.toolbar_about);

//        Toolbar
        setSupportActionBar(toolbar);

//        navigation drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_about);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_prediction:
                Intent iPrediction = new Intent(AboutActivity.this, PredictionActivity.class);
                startActivity(iPrediction);
                finish();
                break;
            case R.id.nav_bookmark:
                break;
            case R.id.nav_help_center:
                Intent iHelpCenter = new Intent(AboutActivity.this, HelpCenterAcitivity.class);
                startActivity(iHelpCenter);
                finish();
                break;
            case R.id.nav_about:
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}
