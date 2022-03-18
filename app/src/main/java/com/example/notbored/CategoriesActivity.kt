package com.example.notbored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notbored.databinding.ActivityCategoriesBinding

class CategoriesActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCategoriesBinding

    private lateinit var adapter: CategoriesAdapter
    private var categories = listOf("Education", "Recreational", "Social", "Diy", "Charity",
        "Cooking", "Relaxation", "Music", "Busywork") // mutableListOf<String>()

    private val participants = 1 // TODO: Replace with intent parameter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = CategoriesAdapter(categories, participants)
        binding.rvCategories.adapter = adapter
    }


}