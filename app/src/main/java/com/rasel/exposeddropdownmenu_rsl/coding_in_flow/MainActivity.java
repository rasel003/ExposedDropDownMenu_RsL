package com.rasel.exposeddropdownmenu_rsl.coding_in_flow;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rasel.exposeddropdownmenu_rsl.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CountryItem> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillCountryList();

        AutoCompleteTextView editText = findViewById(R.id.actv);
        AutoCompleteCountryAdapter adapter = new AutoCompleteCountryAdapter(this, countryList);
        editText.setAdapter(adapter);
    }

    private void fillCountryList() {
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("Afghanistan", R.color.colorAccent));
        countryList.add(new CountryItem("Albania", R.color.colorAccent));
        countryList.add(new CountryItem("Algeria", R.color.colorAccent));
        countryList.add(new CountryItem("Andorra", R.color.colorAccent));
        countryList.add(new CountryItem("Angola", R.color.colorAccent));
    }
}
