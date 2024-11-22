package com.example.pdm1_aula08_exemplo1_login

import android.os.Bundle
import com.example.pdm1_aula08_exemplo1_login.databinding.ActivitySecondBinding
import androidx.activity.OnBackPressedCallback
import android.app.AlertDialog
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}