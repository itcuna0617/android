package com.songjang.carmanagement.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.songjang.carmanagement.R

class AddressAdapter(
    private val addresses: List<Address>,
    private val onClick: (Address) -> Unit
) : RecyclerView.Adapter<AddressAdapter.AddressViewHolder>() {

    inner class AddressViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val addressText: TextView = view.findViewById(R.id.placeAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_address, parent, false)
        return AddressViewHolder(view)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val address = addresses[position]
        holder.addressText.text = address.roadAddress ?: address.jibunAddress
        holder.itemView.setOnClickListener { onClick(address) }
    }

    override fun getItemCount(): Int = addresses.size
}