package com.example.nobored.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.nobored.databinding.ActivityDetailBinding
import com.example.nobored.model.ApiServices
import com.example.nobored.model.ResponseActivity
import com.example.nobored.model.RetrofitServiceBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var activityCategory: String
    private  var participants : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        activityCategory = intent.getStringExtra("activity").toString().lowercase()
        participants = intent.getIntExtra("participants",participants)

        getService()

    }


    private fun getService() {
        CoroutineScope(Dispatchers.IO).launch {
            val call =
                RetrofitServiceBuilder("https://www.boredapi.com/").buildService(ApiServices::class.java)
                    .getActivitiesNoBored(activityCategory, participants)
            val activity: ResponseActivity? = call.body()
            runOnUiThread {
                if (activity?.error?.contains("No activity found") != true) {
                    binding.activityText.text = activity?.activity
                    binding.tvTitleActivity.text =
                        activityCategory.replaceFirstChar { it.uppercase() }
                    binding.textParticipantsValue.text = activity?.participants.toString()
                    binding.textPriceValue.text = convertPrice(activity?.price)

                } else {
                    binding.activityText.text = activity.error
                }
            }

        }
    }

    private fun convertPrice(priceDouble: Double?): String {
        return when (priceDouble!!) {
            0.0 -> "Free"
            in 0.1..0.3 -> "Low"
            in 0.4..0.6 -> "Medium"
            else -> "High"
        }
    }
}

