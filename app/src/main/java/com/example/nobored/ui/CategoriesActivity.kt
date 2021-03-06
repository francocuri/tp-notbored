package com.example.nobored.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.nobored.databinding.ActivityCategoriesBinding
import com.example.nobored.model.Categories

class CategoriesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCategoriesBinding
    private lateinit var adapter: CategoriesAdapter
    private var categories = Categories()

    private var participants = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        participants = intent.getIntExtra("participants",participants)
        setContentView(binding.root)
        initRecyclerView()

        val randomButton = binding.ivRandom

        /**
         * We set participants parameter to be used on getRandomActivity
         */
        randomButton.setOnClickListener {
            val intent = Intent(this, CategoriesDetailActivity::class.java)
            intent.putExtra("participants", participants)
            intent.putExtra("isRandom", true)
            ContextCompat.startActivity(this, intent, null)
        }
    }

    private fun initRecyclerView() {
        adapter = CategoriesAdapter(categories.listActivities, participants)
        binding.rvCategories.adapter = adapter
    }




}