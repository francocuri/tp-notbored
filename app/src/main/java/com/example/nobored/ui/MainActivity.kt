package com.example.nobored.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import com.example.nobored.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonStart = binding.bttnStart
        val tvTerms = binding.tvTermsAndConditions

        disableOrEnableButton()
        buttonStart.setOnClickListener { initNextActivity() }
        tvTerms.setOnClickListener { showTermsAndConditions() }
    }

    /**
     * initNextActivity sets 'participants' parameter to be used on getActivitiesNotBored() or getRandomActivity()
     */
    private fun initNextActivity() {

        val etParticipants = binding.etParticipants
        val numOfParticipants = etParticipants.text.toString()
        val participants = if (!numOfParticipants.isBlank()) numOfParticipants.toInt() else 0
        if (participants > 0) {
            val intent = Intent(this, CategoriesActivity::class.java).apply {
                putExtra("participants", participants)
            }
            startActivity(intent)
        } else {
            Snackbar.make(binding.root, "Please enter a valid number", Snackbar.LENGTH_LONG).show()
            binding.bttnStart.isEnabled = false
        }
    }

    private fun showTermsAndConditions() {
        val intent = Intent(this, TermsActivity::class.java)
        startActivity(intent)
    }


    /**
     * disableOrEnableButton enables start button when input is greater than zero
     */
    private fun disableOrEnableButton() {

        binding.etParticipants.addTextChangedListener {
            binding.bttnStart.isEnabled = !(it.toString().contains("0"))
        }
    }

}