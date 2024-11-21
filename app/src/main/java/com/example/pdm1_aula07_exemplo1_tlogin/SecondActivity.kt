package com.example.pdm1_aula07_exemplo1_tlogin

import android.os.Bundle
import com.example.pdm1_aula07_exemplo1_tlogin.databinding.ActivitySecondBinding
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import android.app.AlertDialog

class SecondActivity : ComponentActivity() { // Destacar o uso de Activity()
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = "Usuário: ${intent.getStringExtra("email")}"
        val dataLogin = "Logado em: ${intent.getStringExtra("dataLogin")}"
        binding.textViewUsuario.text = usuario
        binding.textViewData.text = dataLogin

        onBackPressedDispatcher.addCallback(this, callback)
    }
    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            exibeConfirmacao()
        }
    }
    private fun exibeConfirmacao() {
        AlertDialog.Builder(this)
            .setTitle("Confirmação")
            .setMessage("Deseja realmente sair?")
            .setPositiveButton("Sim") { _, _ -> finish() }
            .setNegativeButton("Não", null)
            .show()
    }
}