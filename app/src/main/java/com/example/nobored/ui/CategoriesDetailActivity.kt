package com.example.nobored.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.isVisible
import com.example.nobored.Utils
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
    private var participants: Int = 0
    private var random = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        activityCategory = intent.getStringExtra("activity").toString().lowercase()
        participants = intent.getIntExtra("participants", participants)

        random = intent.getBooleanExtra("isRandom", false)

        val buttonTryAnother: Button = binding.bttnTryAnother
        val tvCategory = binding.textCategory
        tvCategory.isVisible = false
        getService(random)

        // buttonTryAnother press event would be the same as back press event
        buttonTryAnother.setOnClickListener {
            if (random) getService(random) else this.onBackPressed()
        }
    }

    /**
     * getService builds an instance of Retrofit, send the request and set data to CategoriesDetail activity
     */
    private fun getService(random: Boolean): Unit {
        var activity: ResponseActivity? = null
        CoroutineScope(Dispatchers.IO).launch {
            activity = if (random) {
                val call =
                    RetrofitServiceBuilder("https://www.boredapi.com/").buildService(ApiServices::class.java)
                        .getRandomActivity(participants)
                call.body()
            } else {
                val call =
                    RetrofitServiceBuilder("https://www.boredapi.com/").buildService(ApiServices::class.java)
                        .getActivitiesNotBored(activityCategory, participants)
                call.body()
            }
            runOnUiThread {
                // We use this condition because service returns the same status even if no activity was found
                val textCat = binding.textCategory
                if (random) {
                    textCat.isVisible = true
                    activityCategory = "Random"
                }
                binding.tvTitleActivity.text = activityCategory.replaceFirstChar { it.uppercase() }
                if (activity?.error?.contains("No activity found") != true) {
                    textCat.text = activity?.type
                    binding.activityText.text = activity?.activity
                    binding.textParticipantsValue.text = activity?.participants.toString()
                    binding.textPriceValue.text = Utils.convertPrice(activity?.price)
                } else {
                    binding.activityText.text = activity?.error
                }
            }

        }
    }
}



