package com.example.pdm1_aula07_exemplo1_tlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.pdm1_aula07_exemplo1_tlogin.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString().trim()
            val password = binding.editTextTextPassword.text.toString().trim()
            if (login(email, password)) {
                Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("email", email)
                intent.putExtra("dataLogin", Date().toString())
                startActivity(intent)
                finish()
            } else
                Toast.makeText(this, "E-mail ou senha incorretos!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun login(email: String, password: String): Boolean {
        return email == "jose.paulo@garanhuns.ifpe.edu.br" && password == "professor"
    }
}