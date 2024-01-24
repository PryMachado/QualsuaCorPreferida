package com.consultarcep.qualsuacorpreferida

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.consultarcep.qualsuacorpreferida.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var cor = ""

    companion object {
        const val ARQUIVO_PREFERENCIAS = "ArquivoPreferencias"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.cor1.setOnClickListener {
            cor = "#BA9804"
            salvar(cor)
        }
        binding.cor2.setOnClickListener {
            cor = "#C10000"
            salvar(cor)
        }
        binding.cor3.setOnClickListener {
            cor = "#FF000000"
            salvar(cor)
        }
        binding.cor4.setOnClickListener {
            cor = "#05559C"
            salvar(cor)
        }
        binding.cor5.setOnClickListener {
            cor = "#DF2C6D"
            salvar(cor)
        }
        binding.cor6.setOnClickListener {
            cor = "#064A43"
            salvar(cor)
        }
    }

    private fun salvar(cor: String) {

        binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))

        binding.btTrocarCorFundo.setOnClickListener { view ->

            val preferencias = getSharedPreferences(ARQUIVO_PREFERENCIAS, MODE_PRIVATE)
            val editor = preferencias.edit()
            editor.putString("cor", cor)
            editor.apply()

            snackbar(view)
        }
    }

    private fun snackbar(view: View) {

        val snackbar =
            Snackbar.make(view, "Cor de Fundo Alterada com Sucesso!", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK") {

        }
        snackbar.setActionTextColor(Color.BLUE)
        snackbar.setBackgroundTint(Color.WHITE)
        snackbar.setTextColor(Color.BLACK)
        snackbar.show()
    }

    override fun onResume() {
        super.onResume()

        val preferencias = getSharedPreferences(ARQUIVO_PREFERENCIAS, MODE_PRIVATE)
        val cor = preferencias.getString("cor", "")

        if (cor!!.isNotEmpty()) {
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))

        }
    }
}