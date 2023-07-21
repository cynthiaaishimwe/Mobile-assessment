package com.example.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contact_page.Home
import com.example.contact_page.databinding.ActivityMainActivity3loginBinding


class MainActivity3login : AppCompatActivity() {
//    lateinit var binding: ActivityMainActivity3loginBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding=ActivityMainActivity3loginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }
//    override fun onResume(){
//        super.onResume()
//        setContentView(binding.root)
//        binding.btnButton.setOnClickListener {
//            val intent=Intent(this,Home::class.java
//            )
//            startActivity(intent)
//        }
//        binding.tvSignUp.setOnClickListener {
//            val intent = Intent(
//                this, MainActivity2::class.java
//            )
//            startActivity(intent)
//        }
//    }

    lateinit var binding: ActivityMainActivity3loginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainActivity3loginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvSignUp.setOnClickListener {
            val intent = Intent(
                this, MainActivity2::class.java
            )
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btnButton.setOnClickListener {
            validateRegistration()
        }


    }


    fun validateRegistration() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        var error = false
        if (email.isBlank()) {
            binding.tvEmail.error = "Name required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Phonenumber required"
            error = true
        }
        if (!error) {
            val intent=Intent(this,Home::class.java)
            startActivity(intent)        }
    }
}

