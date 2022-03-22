package com.example.nobored.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nobored.databinding.ActivityCategoriesBinding
import com.example.nobored.model.Activities
import com.example.nobored.model.ApiServices
import com.example.nobored.model.RetrofitServiceBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCategoriesBinding

    private lateinit var adapter: CategoriesAdapter
    private var categories = listOf(
        "Education", "Recreational", "Social", "Diy", "Charity",
        "Cooking", "Relaxation", "Music", "Busywork")


    private val participants = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = CategoriesAdapter(categories, participants)
        binding.rvCategories.adapter = adapter
     //   getService()
    }

    private fun getService(){
        CoroutineScope(Dispatchers.IO).launch {
            val call =
                RetrofitServiceBuilder("http://www.boredapi.com/api/activity").buildService(ApiServices::class.java)
                    .getActivitiesNoBored()
            val type: Activities? = call.body()

            runOnUiThread {
                if (call.isSuccessful) {

                }
            }

        }
    }


}