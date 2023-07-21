package com.example.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.contact_page.Home
import com.example.contact_page.databinding.ActivityMain2Binding
import com.example.mobile_development_assessment.Model.RegisterRequest
import com.example.mobile_development_assessment.ViewModel.UserViewModels


class MainActivity2 : AppCompatActivity() {
//    lateinit var binding: ActivityMain2Binding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMain2Binding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }
//
//
//    override fun onResume() {
//        super.onResume()
//        setContentView(binding.root)
//        binding.tvbtn.setOnClickListener {
//            val intent = Intent(
//                this, ActivityMainBinding::class.java
//            )
//            startActivity(intent)
//        }
//
//    }






val userViewModel: UserViewModels by viewModels()
lateinit var binding: ActivityMain2Binding
 override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMain2Binding.inflate(layoutInflater)
    setContentView(binding.root)
}

override fun onResume() {
    super.onResume()
    binding.tvbtn.setOnClickListener {
        val intent = Intent(this, Home::class.java)
        startActivity(intent)
    }
    binding.tvbtn.setOnClickListener {
        clearErrors()
        validateSignUp()
    }
    userViewModel.regLiveData.observe( this, Observer { regResponse ->
        Toast.makeText(this, regResponse.message, Toast.LENGTH_LONG).show()
        startActivity(Intent(this, Home::class.java))
        binding.pbRegister.visibility = View.GONE
    })
    userViewModel.regLiveData.observe(this, Observer { err ->
        Toast.makeText(this, err.message, Toast.LENGTH_LONG).show()
        binding.pbRegister.visibility = View.GONE
    })
//    binding.tvbtn.setOnClickListener {
//        startActivity(Intent(this, Home::class.java))
//    }
}

fun validateSignUp() {
    val firstName = binding.etFirstName.text.toString()
    val lastName = binding.etNames.text.toString()
    val phoneNumber = binding.etPhoneNumber.text.toString()
    val email = binding.etEmailAddress.text.toString()
    val password = binding.etPassword.text.toString()
    val passwordConfirmation = binding.etPassword.text.toString()
    val confirm = binding.etPasswordConf.text.toString()
    var error = false

    if (firstName.isBlank()) {
        error = true
        binding.tilFirstName.error = "First name is required"
    }
    if (lastName.isBlank()) {
        binding.tvNames.error = "Last name is required"
        error = true
    }
    if (email.isBlank()) {
        binding.tilEmailAddress.error = "Email is required"
        error = true
    }
    if (password.isBlank()) {
        binding.tilPassword.error = "Password is required"
        error = true
    }
    if (phoneNumber.isBlank()) {
        binding.tilPhoneNumber.error = "Your phone number is required"
        error = true
    }
    if (passwordConfirmation.isBlank()) {
        binding.tilPaswordConf.error = "Your phone number is required"
        error = true
    }
    if (!error) {
        val registerRequest = RegisterRequest(
            FirstName = firstName,
            LastName = lastName,
            email = email,
            PhoneNumber = phoneNumber,
            PassWord = password,
        )
        userViewModel.registerUser(registerRequest)
        Toast.makeText(
            this, "Registration of $firstName" +
                    " was sucessful",
            Toast.LENGTH_LONG
        ).show()
        startActivity(Intent(this, Home::class.java))
    }
}

fun clearErrors() {
    binding.tilFirstName.error = null
    binding.tilFirstName
    binding.tilEmailAddress.error = null
    binding.tilPassword.error = null
    binding.tilPhoneNumber.error = null
    binding.tilPaswordConf.error = null
   }
}






