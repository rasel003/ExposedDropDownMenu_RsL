package com.rasel.exposeddropdownmenu_rsl.coding_in_flow;

import androidx.annotation.NonNull;

public class CountryItem {
    private String countryName;
    private int flagImage;

    public CountryItem(String countryName, int flagImage) {
        this.countryName = countryName;
        this.flagImage = flagImage;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getFlagImage() {
        return flagImage;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
