package com.example.covid_19.model;

public class Nepalidetails {

private String tested_positive;
    private String tested_negative;
    private String tested_total;
    private String in_isolation;
    private String quarantined;
    private String recovered;
    private String deaths;
    private String tested_rdt;
    private String url;

    public Nepalidetails(String tested_positive, String tested_negative, String tested_total, String in_isolation, String quarantined, String recovered, String deaths, String tested_rdt, String url) {
        this.tested_positive = tested_positive;
        this.tested_negative = tested_negative;
        this.tested_total = tested_total;
        this.in_isolation = in_isolation;
        this.quarantined = quarantined;
        this.recovered = recovered;
        this.deaths = deaths;
        this.tested_rdt = tested_rdt;
        this.url = url;
    }



    public String getTested_positive() {
        return tested_positive;
    }

    public void setTested_positive(String tested_positive) {
        this.tested_positive = tested_positive;
    }

    public String getTested_negative() {
        return tested_negative;
    }

    public void setTested_negative(String tested_negative) {
        this.tested_negative = tested_negative;
    }

    public String getTested_total() {
        return tested_total;
    }

    public void setTested_total(String tested_total) {
        this.tested_total = tested_total;
    }

    public String getIn_isolation() {
        return in_isolation;
    }

    public void setIn_isolation(String in_isolation) {
        this.in_isolation = in_isolation;
    }

    public String getQuarantined() {
        return quarantined;
    }

    public void setQuarantined(String quarantined) {
        this.quarantined = quarantined;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTested_rdt() {
        return tested_rdt;
    }

    public void setTested_rdt(String tested_rdt) {
        this.tested_rdt = tested_rdt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
