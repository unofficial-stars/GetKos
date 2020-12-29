package com.djinggoo.getkos;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class BookmarkActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        drawerLayout = findViewById(R.id.drawer_layout_about);
        navigationView = findViewById(R.id.nav_view_about);
        toolbar = findViewById(R.id.toolbar_about);


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
                Intent iPredict = new Intent(BookmarkActivity.this, PredictionActivity.class);
                startActivity(iPredict);
                break;
            case R.id.nav_bookmark:
                Intent iBookmark = new Intent(BookmarkActivity.this, BookmarkActivity.class);
                startActivity(iBookmark);
                break;
            case R.id.nav_help_center:
                Intent iHelpCenter = new Intent(BookmarkActivity.this, HelpCenterAcitivity.class);
                startActivity(iHelpCenter);
                break;
            case R.id.nav_about:
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
