package com.rasel.exposeddropdownmenu_rsl.zoftino_com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.rasel.exposeddropdownmenu_rsl.R;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private AutoCompleteTextView nameTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.autocompleteitem, getData());
        nameTV = findViewById(R.id.category);

        nameTV.setAdapter(adapter);
        nameTV.setOnItemClickListener(onItemClickListener);
    }
    private AdapterView.OnItemClickListener onItemClickListener =
            new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(SecondActivity.this, "Clicked item " + adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();

                    Log.d("rsl", "position: "+i+" row: "+l);
                }
            };


    private List<String> getData(){
        List<String> dataList = new ArrayList<String>();
        dataList.add("Fashion Men");
        dataList.add("Fashion Women");
        dataList.add("Baby");
        dataList.add("Kids");
        dataList.add("Electronics");
        dataList.add("Appliance");
        dataList.add("Travel");
        dataList.add("Bags");
        dataList.add("FootWear");
        dataList.add("Jewellery");
        dataList.add("Sports");
        dataList.add("Electrical");
        dataList.add("Sports Kids");
        return dataList;
    }
}
