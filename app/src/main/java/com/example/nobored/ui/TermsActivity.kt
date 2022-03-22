package com.example.nobored.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nobored.databinding.ActivityTermsBinding

class TermsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTermsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonBack = binding.buttonBack

        buttonBack.setOnClickListener {
            this.onBackPressed()
        }

    }
}