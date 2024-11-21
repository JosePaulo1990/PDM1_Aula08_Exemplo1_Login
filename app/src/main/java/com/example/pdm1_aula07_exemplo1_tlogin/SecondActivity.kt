package com.example.pdm1_aula07_exemplo1_tlogin

import android.app.Activity
import android.os.Bundle
import com.example.pdm1_aula07_exemplo1_tlogin.databinding.ActivitySecondBinding

class SecondActivity : Activity() { // Destacar o uso de Activity()
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = "Usuário: ${intent.getStringExtra("email")}"
        val dataLogin = "Logado em: ${intent.getStringExtra("dataLogin")}"
        binding.textViewUsuario.text = usuario
        binding.textViewData.text = dataLogin
    }
}