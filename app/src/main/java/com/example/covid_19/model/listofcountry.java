package com.example.covid_19.model;

import java.util.ArrayList;
import java.util.List;

public class listofcountry {

    private String country;
    private String newCases;
    private String totalCases;
    private String totalRecovered;
    private String totalDeaths;
    private String activeCases;
    private countryInfo countryInfo;

    public listofcountry(String country, String newCases, String totalCases, String totalRecovered, String totalDeaths, String activeCases, com.example.covid_19.model.countryInfo countryInfo) {
        this.country = country;
        this.newCases = newCases;
        this.totalCases = totalCases;
        this.totalRecovered = totalRecovered;
        this.totalDeaths = totalDeaths;
        this.activeCases = activeCases;
        this.countryInfo = countryInfo;
    }

    public com.example.covid_19.model.countryInfo getCountryInfo() {
        return countryInfo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

}
