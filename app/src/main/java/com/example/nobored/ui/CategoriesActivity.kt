package com.example.nobored.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nobored.databinding.ActivityCategoriesBinding
import com.example.nobored.model.Activities

class CategoriesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCategoriesBinding
    private lateinit var adapter: CategoriesAdapter
    private var activities = Activities()

    private var participants = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        participants = intent.getIntExtra("participants",participants)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = CategoriesAdapter(activities.listActivities, participants)
        binding.rvCategories.adapter = adapter
    }




}