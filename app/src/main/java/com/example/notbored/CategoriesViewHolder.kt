package com.example.notbored

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.databinding.ItemCategoryBinding

class CategoriesViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val binding = ItemCategoryBinding.bind(view)

    fun bind(category: String){
        binding.tvCategory.text = category
    }
}