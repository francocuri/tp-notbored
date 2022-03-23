package com.example.nobored.ui

import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.nobored.databinding.ItemCategoryBinding

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemCategoryBinding.bind(view)


    fun bind(category: String, participants : Int) {
        binding.tvCategory.text = category
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, CategoriesDetailActivity::class.java)
            intent.putExtra("activity", binding.tvCategory.text)
            intent.putExtra("participants", participants)
            startActivity(itemView.context, intent, null)
        }
    }


}

