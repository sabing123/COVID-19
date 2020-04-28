package com.example.covid_19.model;

public class AndroidVersion {

    private String title;
    private String source;
    private String summary;
private String url;

    public AndroidVersion(String title, String source, String summary, String url) {
        this.title = title;
        this.source = source;
        this.summary = summary;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
