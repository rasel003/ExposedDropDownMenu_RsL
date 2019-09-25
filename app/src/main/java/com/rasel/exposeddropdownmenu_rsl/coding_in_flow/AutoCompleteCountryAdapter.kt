package com.rasel.exposeddropdownmenu_rsl.coding_in_flow

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView

import com.rasel.exposeddropdownmenu_rsl.R
import java.util.*

class AutoCompleteCountryAdapter(context: Context, countryList: List<CountryItem>) : ArrayAdapter<CountryItem>(context, 0, countryList) {
    private val countryListFull: List<CountryItem>

    init {
        countryListFull = ArrayList(countryList)
    }

    private val countryFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {

            val results = FilterResults()

            val suggestions = ArrayList<CountryItem>()

            if (constraint == null || constraint.length == 0) {
                suggestions.addAll(countryListFull)
            } else {
                val filterPattern = constraint.toString().toLowerCase(Locale.ENGLISH).trim { it <= ' ' }

                for (item in countryListFull) {
                    if (item.countryName.toLowerCase(Locale.ENGLISH).contains(filterPattern)) {
                        suggestions.add(item)
                    }
                }
            }

            results.values = suggestions
            results.count = suggestions.size

            return results
        }

       /* override fun publishResults(constraint: CharSequence, results: FilterResults) {
            clear()
           // addAll(results.values as List<*>)

            addAll(results.values as List<*>)

            notifyDataSetChanged()
        }*/

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) = when {
            results?.count ?: -1 > 0 -> notifyDataSetChanged()
            else -> notifyDataSetInvalidated()
        }

        override fun convertResultToString(resultValue: Any): CharSequence {
            return (resultValue as CountryItem).countryName
        }
    }
    override fun getFilter(): Filter {
        return countryFilter
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var _convertView = convertView
        if (_convertView == null) {
            _convertView = LayoutInflater.from(context).inflate(R.layout.country_autocomplete_row, parent, false)
        }

        val textViewName = _convertView!!.findViewById<TextView>(R.id.text_view_name)
        val imageViewFlag = _convertView.findViewById<ImageView>(R.id.image_view_flag)

        val countryItem = getItem(position)

        if (countryItem != null) {
            textViewName.text = countryItem.countryName
            imageViewFlag.setImageResource(countryItem.flagImage)
        }

        return _convertView
    }
}
