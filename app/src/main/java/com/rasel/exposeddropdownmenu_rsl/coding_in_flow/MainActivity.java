package com.rasel.exposeddropdownmenu_rsl.coding_in_flow;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

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

        editText.setOnItemClickListener(onItemClickListener);
    }
    private AdapterView.OnItemClickListener onItemClickListener =
            new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(MainActivity.this, "Clicked item " + adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();

                    CountryItem countryItem = (CountryItem) adapterView.getItemAtPosition(i);

                    Log.d("rsl", "value : "+countryItem.getCountryName());

                    Log.d("rsl", "view: "+adapterView.getItemAtPosition(i).toString());
                    Log.d("rsl", "position: "+i+" row: "+l);
                }
            };

    private void fillCountryList() {
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("Afghanistan", R.color.colorAccent));
        countryList.add(new CountryItem("Albania", R.color.colorAccent));
        countryList.add(new CountryItem("Algeria", R.color.colorAccent));
        countryList.add(new CountryItem("Andorra", R.color.colorAccent));
        countryList.add(new CountryItem("Angola", R.color.colorAccent));
    }
}
