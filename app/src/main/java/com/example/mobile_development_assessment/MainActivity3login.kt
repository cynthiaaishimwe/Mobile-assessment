package com.example.mobile_development_assessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contact_page.R
import com.example.contact_page.databinding.ActivityMain2Binding
import com.example.contact_page.databinding.ActivityMainActivity3loginBinding
import com.example.contact_page.databinding.ActivityMainBinding


class MainActivity3login : AppCompatActivity() {
    lateinit var binding: ActivityMainActivity3loginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainActivity3loginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume(){
        super.onResume()
        setContentView(binding.root)
        binding.tvButton2.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java
            )
            startActivity(intent)
        }
    }






}