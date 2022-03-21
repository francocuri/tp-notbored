package com.example.nobored

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.nobored.databinding.ItemCategoryBinding

class CategoriesViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val binding = ItemCategoryBinding.bind(view)

    fun bind(category: String){
        binding.tvCategory.text = category
    }
}