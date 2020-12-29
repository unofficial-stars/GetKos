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
import androidx.recyclerview.widget.RecyclerView;

import com.djinggoo.getkos.adapter.HelpCenterAdapter;
import com.djinggoo.getkos.data.HelpCenter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HelpCenterAcitivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    List<HelpCenter> helpCenters;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);

        recyclerView = findViewById(R.id.recycle_view);
        drawerLayout = findViewById(R.id.drawer_layout_helpcenter);
        navigationView = findViewById(R.id.nav_view_helpcenter);
        toolbar = findViewById(R.id.toolbar_helpcenter);

        initData();
        setRecycelView();

        //        navigation drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_help_center);

    }

    private void setRecycelView(){
        HelpCenterAdapter helpCenterAdapter = new HelpCenterAdapter(helpCenters);
        recyclerView.setAdapter(helpCenterAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData(){
        helpCenters = new ArrayList<>();
        helpCenters.add(new HelpCenter(
                "Bagaimana cara memprediksi harga di GetKos ?",
                "1. Pada halaman utama GetKos (prediction) masukan kota, area, dan fasilitas yang diinginkan.\n\n" +
                        "2. Pilih tombol \"Predict\" untuk mengetahui harga yang paling baik, sesuai dengan daerah dan fasilitas keinginan anda."));
//        helpCenters.add(new HelpCenter("Bagaimana cara melihat harga update terakhir harga kos ?", "Tanya ke mbah dukun!"));
//        helpCenters.add(new HelpCenter("Bagaimana cara melihat fasilitas yang tersdia ?", "Udah ngopi aja. Kasihan isi kepalamu yang udah cenat-cenut"));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_prediction:
                Intent iPrediction = new Intent(HelpCenterAcitivity.this, PredictionActivity.class);
                startActivity(iPrediction);
                break;
            case R.id.nav_bookmark:
                Intent iBookmark = new Intent(HelpCenterAcitivity.this, BookmarkActivity.class);
                startActivity(iBookmark);
                break;
            case R.id.nav_help_center:
                break;
            case R.id.nav_about:
                Intent iAbout = new Intent(HelpCenterAcitivity.this, AboutActivity.class);
                startActivity(iAbout);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
