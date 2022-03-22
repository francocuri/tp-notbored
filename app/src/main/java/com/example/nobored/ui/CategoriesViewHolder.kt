package com.example.nobored.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.nobored.databinding.ItemCategoryBinding

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemCategoryBinding.bind(view)


    fun bind(category: String) {
        binding.tvCategory.text = category
        itemView.setOnClickListener {
            Toast.makeText(binding.tvCategory.context, category, Toast.LENGTH_SHORT).show()
            val intent = Intent(itemView.context, DetailActivity::class.java)
            startActivity(itemView.context,intent, Bundle())
        }
    }

}