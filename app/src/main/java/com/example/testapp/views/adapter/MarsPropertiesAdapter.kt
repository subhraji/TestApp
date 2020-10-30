package com.example.testapp.views.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.helpers.inflate
import com.example.testapp.model.pojo.mars_property.MarsProperty
import kotlinx.android.synthetic.main.mars_property_layout.view.*

class MarsPropertiesAdapter(private val marsProperty: List<MarsProperty>): RecyclerView.Adapter<MarsPropertiesAdapter.MarsPropertiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPropertiesAdapter.MarsPropertiesViewHolder {
        return MarsPropertiesViewHolder(parent.inflate(R.layout.mars_property_layout))
    }

    override fun getItemCount(): Int {
        return marsProperty.size
    }

    inner class MarsPropertiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onBindViewHolder(holder: MarsPropertiesViewHolder, position: Int) {
        val marsProperty = marsProperty[position]

        holder.itemView.apply {
            property_id_tv.text = marsProperty.id.toString()
            property_price_tv.text = marsProperty.price.toString()
            property_type_tv.text = marsProperty.type.toString()
        }

    }
}