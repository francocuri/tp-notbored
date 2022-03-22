package com.example.nobored.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.nobored.databinding.ActivityCategoriesBinding
import com.example.nobored.model.Activities
import com.example.nobored.model.ApiServices
import com.example.nobored.model.ResponseActivity
import com.example.nobored.model.RetrofitServiceBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCategoriesBinding
    private lateinit var adapter: CategoriesAdapter
    private var categories = Activities()

    private val participants = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = CategoriesAdapter(categories.listActivities, participants)
        binding.rvCategories.adapter = adapter
        getService()
    }

    private fun getService(){
        CoroutineScope(Dispatchers.IO).launch {
            val call =
                RetrofitServiceBuilder("https://www.boredapi.com/").buildService(ApiServices::class.java)
                    .getActivitiesNoBored("education")
            val activity: ResponseActivity? = call.body()

            runOnUiThread {
                if (call.isSuccessful) {
                    Toast.makeText(this@CategoriesActivity,activity?.activity,Toast.LENGTH_LONG).show()
                 }
            }

        }
    }


}