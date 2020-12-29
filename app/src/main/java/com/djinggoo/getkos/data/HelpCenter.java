package com.djinggoo.getkos.data;

public class HelpCenter {

    private String Title;
    private String description;
    private Boolean expandable;

    public HelpCenter(String title, String description) {
        Title = title;
        this.description = description;
        this.expandable = false;
    }


    public Boolean getExpandable() {
        return expandable;
    }

    public void setExpandable(Boolean expandable) {
        this.expandable = expandable;
    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
