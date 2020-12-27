package com.djinggoo.getkos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.djinggoo.getkos.adapter.HelpCenterAdapter;
import com.djinggoo.getkos.data.HelpCenter;

import java.util.ArrayList;
import java.util.List;

public class HelpCenterAcitivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<HelpCenter> helpCenters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);

        recyclerView = findViewById(R.id.recycle_view);

        initData();
        setRecycelView();
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
        helpCenters.add(new HelpCenter("Bagaimana cara melihat harga update terakhir harga kos ?", "Tanya ke mbah dukun!"));
        helpCenters.add(new HelpCenter("Bagaimana cara melihat fasilitas yang tersdia ?", "Udah ngopi aja. Kasihan isi kepalamu yang udah cenat-cenut"));
    }

}
