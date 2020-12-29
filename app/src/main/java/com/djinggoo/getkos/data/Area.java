package com.djinggoo.getkos.data;

public class Area {

    private String name;
    private Integer value;
    private String city;

    public Area() {
    }

    public Area(String name, Integer value, String city) {
        this.name = name;
        this.value = value;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"name\":\"" + name + "\",\n" +
                "\"value\":" + value + ",\n" +
                "\"kota\":\"" + city + "\"\n" +
                "}";
    }
}
