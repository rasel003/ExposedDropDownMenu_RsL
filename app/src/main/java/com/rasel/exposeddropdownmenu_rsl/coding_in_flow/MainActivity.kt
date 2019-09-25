package com.rasel.exposeddropdownmenu_rsl.coding_in_flow

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AutoCompleteTextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.rasel.exposeddropdownmenu_rsl.R

import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var countryList: MutableList<CountryItem>? = null
    private val onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
        Toast.makeText(this@MainActivity, "Clicked item " + adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show()

        val countryItem = adapterView.getItemAtPosition(i) as CountryItem

        Log.d("rsl", "value : " + countryItem.countryName)

        Log.d("rsl", "view: " + adapterView.getItemAtPosition(i).toString())
        Log.d("rsl", "position: $i row: $l")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillCountryList()

        val editText = findViewById<AutoCompleteTextView>(R.id.actv)
        val adapter = AutoCompleteCountryAdapter(this, countryList!!)
        editText.setAdapter(adapter)

        editText.onItemClickListener = onItemClickListener
    }

    private fun fillCountryList() {
        countryList = ArrayList()
        countryList!!.add(CountryItem("Afghanistan", R.color.colorAccent))
        countryList!!.add(CountryItem("Albania", R.color.colorAccent))
        countryList!!.add(CountryItem("Algeria", R.color.colorAccent))
        countryList!!.add(CountryItem("Andorra", R.color.colorAccent))
        countryList!!.add(CountryItem("Angola", R.color.colorAccent))
    }
}
