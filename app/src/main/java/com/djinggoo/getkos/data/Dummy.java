package com.djinggoo.getkos.data;

import java.util.Arrays;
import java.util.List;

public class Dummy {



    public static List<String> getAreaItems() {
        String[] data = new String[]{
                "antapani", "astanaanyar", "babakan ciparay", "bandung wetan", "banjarsari", "banyumanik", "batu",
                "bekasi selatan", "blimbing", "bojongloa kidul", "buahbatu", "cibeunying kaler", "cibeunying kidul",
                "cicendo", "cilandak", "coblong", "danurejan", "depok", "dukuhpakis", "duren sawit", "gajahmungkur",
                "gayamsari", "gayungan", "gedong tengen", "genuk", "godean", "gondokusuman", "gondomanan", "grogol petamburan",
                "gubeng", "jatinangor", "jetis", "kebayoran baru", "kelapa gading", "kemayoran", "kepanjen",
                "kiaracondong", "klojen", "lengkong", "lowokwaru", "menteng", "mergangsan", "mlati", "ngaglik",
                "ngaliyan", "ngampilan", "ngemplak", "pakualaman", "palmerah","pancoran", "pasar minggu",
                "pedurungan", "regol", "rungkut", "sedati", "semarang selatan", "semarang tengah", "semarang timur",
                "semarang utara", "senen", "serpong", "setiabudi", "singosari", "sukajadi", "sukasari", "sukolilo",
                "sukun", "tambaksari", "tambora", "tanah abang", "tebet", "tegalsari", "tembalang", "umbulharjo",
                "ungaran barat", "ungaran timur", "waru", "wiyung", "wonokromo"

        };

        return Arrays.asList(data);
    }

    public static List<String> getBandungAreaItems() {
        String[] data = new String[]{
                "antapani","astanaanyar","babakan ciparay","bandung wetan","bojongloa kidul",
                "buahbatu","cibeunying kaler","cibeunying kidul","cicendo","coblong","jatinangor",
                "kiaracondong","lengkong","regol","sukajadi","sukasari"

        };
        return Arrays.asList(data);
    }

    public static List<String> getJogjaAreaItems() {
        String[] data = new String[]{
                "banjarsari","bekasi selatan","danurejan","depok","gedong tengen","godean",
                "gondokusuman","gondomanan","jetis","mlati","mergangsan","ngaglik","ngampilan",
                "ngemplak","pakualaman","umbulharjo"
        };
        return Arrays.asList(data);
    }

    public static List<String> getSemarangAreaItems() {
        String[] data = new String[]{
                "banyumanik","gajahmungkur","genuk","kepanjen","ngaliyan","pedurungan",
                "semarang selatan","semarang tengah","semarang timur","semarang utara",
                "tembalang","ungaran barat","ungaran timur","gayamsari"
        };
        return Arrays.asList(data);
    }

    public static List<String> getjakartaAreaItems() {
        String[] data = new String[]{
                "cilandak","duren sawit","grogol petamburan","kebayoran baru","kelapa gading",
                "kemayoran","menteng","palmerah","pancoran","pasar minggu","senen","serpong",
                "setiabudi","tambora","tanah abang"
        };
        return Arrays.asList(data);
    }

    public static List<String> getSurabayaAreaItems() {
        String[] data = new String[]{
                "dukuhpakis","gayungan","gubeng","rungkut","sedati","sukolilo","tambaksari",
                "tegalsari","waru","wiyung","wonokromo"
        };
        return Arrays.asList(data);
    }

    public static List<String> getMalangAreaItems() {
        String[] data = new String[]{
                "batu","blimbing","kepanjen","klojen","lowokwaru","singosari","sukun"
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
