package com.example.pdm1_aula08_exemplo1_login

import android.os.Bundle
import com.example.pdm1_aula08_exemplo1_login.databinding.ActivitySecondBinding
import androidx.activity.OnBackPressedCallback
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTitle("Login IFPE")

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        return when (item.itemId) {
            R.id.option1 -> {
                Toast.makeText(this, "Clicou em Links", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.suboption1 -> {
                Toast.makeText(this, "Clicou em Portal IFPE", Toast.LENGTH_SHORT).show()
                val url = "https://portal.ifpe.edu.br/garanhuns/"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
                true
            }
            R.id.suboption2 -> {
                Toast.makeText(this, "Clicou em Kotlin", Toast.LENGTH_SHORT).show()
                val url = "https://kotlinlang.org/"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
                true
            }
            R.id.option2 -> {
                Toast.makeText(this, "Clicou em Compartilhar", Toast.LENGTH_SHORT).show()
                val mensagem = "Estudando Android com Prof. José Paulo!"
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, mensagem)
                startActivity(Intent.createChooser(intent, "Compartilhar via..."))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}