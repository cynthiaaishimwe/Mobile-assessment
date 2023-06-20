package com.example.mobile_development_assessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contact_page.R
import com.example.contact_page.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
}
      override fun onResume(){
        super.onResume()
        setContentView(binding.root)
        binding.tvbtn.setOnClickListener {
            val intent=Intent(this,MainActivity3login::class.java
            )
            startActivity(intent)
        }
    }






}