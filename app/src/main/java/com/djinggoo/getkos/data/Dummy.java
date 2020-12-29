package com.djinggoo.getkos.data;

import java.util.Arrays;
import java.util.List;

public class Dummy {


    public static List<String> getAreaItems(){
     String[] data = new String[]{
                "arcamanik", "babakan ciparay", "bandung kidul", "bandung wetan", "bantul",
                "banyumanik", "batu", "batununggal", "blimbing", "bojongloa kidul", "buahbatu",
                "cibeunying kaler", "cicendo", "cidadap", "cilandak", "coblong", "depok",
                "dukuhpakis", "duren sawit", "gajahmungkur", "gambir", "gayungan", "gedong tengen",
                "genuk", "godean", "gondokusuman", "gondomanan", "grogol petamburan", "gubeng",
                "gunung anyar", "jatinangor", "jetis", "karang pilang", "kelapa gading", "kepanjen",
                "klojen", "koja", "lengkong", "lowokwaru", "mantrijeron", "mergangsan", "mlati",
                "mulyorejo", "ngaglik", "ngaliyan", "ngemplak", "pakualaman", "palmerah", "pedurungan",
                "regol", "rungkut", "sawah besar", "sedati", "semarang barat", "semarang selatan",
                "semarang tengah", "semarang timur", "semarang utara", "senen", "serpong", "setiabudi",
                "singosari", "sukajadi", "sukolilo", "sukun", "tambaksari", "tanah abang", "tanjung priok",
                "tebet", "tegalrejo", "tegalsari", "tembalang", "umbulharjo", "waru", "wiyung", "wonocolo", "wonokromo"
        };

     return Arrays.asList(data);
    }

    public static List<String> getTypeItems(){
        String[] data = new String[]{
                "Campur", "Putra", "Putri"
        };

        return Arrays.asList(data);
    }

    public static List<String> getCityItems(){
        String[] data = new String[]{
                "Bandung", "Jakarta", "Yogyakarta", "Malang", "Semarang", "Surabaya"
        };

        return Arrays.asList(data);
    }

}
