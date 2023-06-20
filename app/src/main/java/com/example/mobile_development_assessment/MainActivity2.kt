package com.example.mobile_development_assessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contact_page.R
import com.example.contact_page.databinding.ActivityMain2Binding
import com.example.contact_page.databinding.ActivityMainActivity3loginBinding
import com.example.contact_page.databinding.ActivityMainBinding


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btnbutton.setOnClickListener {
            val intent = Intent(
                this, ActivityMainActivity3loginBinding::class.java
            )
            startActivity(intent)
        }
    }
}

