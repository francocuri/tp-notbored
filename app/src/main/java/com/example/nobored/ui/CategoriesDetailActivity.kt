package com.example.nobored.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
    private  var participants : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        activityCategory = intent.getStringExtra("activity").toString().lowercase()
        participants = intent.getIntExtra("participants",participants)

        val buttonTryAnother: Button = binding.bttnTryAnother

        getService()

        // buttonTryAnother press event would be the same as back press event
        buttonTryAnother.setOnClickListener {   this.onBackPressed() }

    }

    /**
     * getService builds an instance of Retrofit, send the request and set data to CategoriesDetail activity
     */
    private fun getService(): Unit {
        CoroutineScope(Dispatchers.IO).launch {
            val call =
                RetrofitServiceBuilder("https://www.boredapi.com/").buildService(ApiServices::class.java)
                    .getActivitiesNotBored(activityCategory, participants)
            val activity: ResponseActivity? = call.body()
            runOnUiThread {
                // We use this condition because service returns the same status even if no activity was found
                if (activity?.error?.contains("No activity found") != true) {
                    binding.activityText.text = activity?.activity
                    binding.tvTitleActivity.text =
                        activityCategory.replaceFirstChar { it.uppercase() }
                    binding.textParticipantsValue.text = activity?.participants.toString()
                    binding.textPriceValue.text = Utils.convertPrice(activity?.price)

                } else {
                    binding.activityText.text = activity.error
                }
            }

        }
    }
}



