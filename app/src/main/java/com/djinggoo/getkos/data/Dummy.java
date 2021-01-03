package com.djinggoo.getkos.data;

import java.util.Arrays;
import java.util.List;

public class Dummy {



    public static List<String> getAreaItems() {
        String[] data = new String[]{
                "Antapani", "Astanaanyar", "Babakan ciparay", "Bandung wetan", "Banjarsari", "Banyumanik", "Batu",
                "Bekasi selatan", "Blimbing", "Bojongloa kidul", "Buahbatu", "Cibeunying kaler", "Cibeunying kidul",
                "Cicendo", "Cilandak", "Coblong", "Danurejan", "Depok", "Dukuhpakis", "Duren sawit", "Gajahmungkur",
                "Gayamsari", "Gayungan", "Gedong tengen", "Genuk", "Godean", "Gondokusuman", "Gondomanan", "Grogol petamburan",
                "Gubeng", "Jatinangor", "Jetis", "Kebayoran baru", "Kelapa gading", "Kemayoran", "Kepanjen",
                "Kiaracondong", "Klojen", "Lengkong", "Lowokwaru", "Menteng", "Mergangsan", "Mlati", "Ngaglik",
                "Ngaliyan", "Ngampilan", "Ngemplak", "Pakualaman", "Palmerah","Pancoran", "Pasar minggu",
                "Pedurungan", "Regol", "Rungkut", "Sedati", "Semarang selatan", "Semarang tengah", "Semarang timur",
                "Semarang utara", "Senen", "Serpong", "Setiabudi", "Singosari", "Sukajadi", "Sukasari", "Sukolilo",
                "Sukun", "Tambaksari", "Tambora", "Tanah abang", "Tebet", "Tegalsari", "Tembalang", "Umbulharjo",
                "Ungaran barat", "Ungaran timur", "Waru", "Wiyung", "Wonokromo"

        };

        return Arrays.asList(data);
    }

    public static List<String> getBandungAreaItems() {
        String[] data = new String[]{
                "Antapani","Astanaanyar","Babakan ciparay","Bandung wetan","Bojongloa kidul",
                "Buahbatu","Cibeunying kaler","Cibeunying kidul","Cicendo","Coblong","Jatinangor",
                "Kiaracondong","Lengkong","Regol","Sukajadi","Sukasari"

        };
        return Arrays.asList(data);
    }

    public static List<String> getJogjaAreaItems() {
        String[] data = new String[]{
                "Banjarsari","Danurejan","Depok","Gedong tengen","Godean",
                "Gondokusuman","Gondomanan","Jetis","Mlati","Mergangsan","Ngaglik","Ngampilan",
                "Ngemplak","Pakualaman","Umbulharjo"
        };
        return Arrays.asList(data);
    }

    public static List<String> getSemarangAreaItems() {
        String[] data = new String[]{
                "Banyumanik","Gajahmungkur","Genuk","Kepanjen","Ngaliyan","Pedurungan",
                "Semarang selatan","Semarang tengah","Semarang timur","Semarang utara",
                "Tembalang","Ungaran barat","Ungaran timur","Gayamsari"
        };
        return Arrays.asList(data);
    }

    public static List<String> getjakartaAreaItems() {
        String[] data = new String[]{
                "Cilandak","Duren sawit","Grogol petamburan","Kebayoran baru","Kelapa gading",
                "Kemayoran","Menteng","Palmerah","Pancoran","Pasar minggu","Senen","Serpong",
                "Setiabudi","Tambora", "Bekasi selatan", "Tanah abang"
        };
        return Arrays.asList(data);
    }

    public static List<String> getSurabayaAreaItems() {
        String[] data = new String[]{
                "Dukuhpakis","Gayungan","Gubeng","Rungkut","Sedati","Sukolilo","Tambaksari",
                "Tegalsari","Waru","Wiyung","Wonokromo"
        };
        return Arrays.asList(data);
    }

    public static List<String> getMalangAreaItems() {
        String[] data = new String[]{
                "Batu","Blimbing","Kepanjen","Klojen","Lowokwaru","Singosari","Sukun"
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
