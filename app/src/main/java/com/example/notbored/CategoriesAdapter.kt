package com.example.notbored

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(private var categories: List<String>, private val participants: Int) : RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CategoriesViewHolder(layoutInflater.inflate(R.layout.item_category, parent, false))
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val categoryAtPosition = categories[position]
        holder.bind(categoryAtPosition)

        holder.binding.itemCategory.setOnClickListener{
            println("${holder.binding.tvCategory.text} was selected. Participants = $participants")
            // TODO: Here goes the Activity transition
        }
    }

    override fun getItemCount() = categories.size

}