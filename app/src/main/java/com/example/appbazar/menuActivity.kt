package com.example.appbazar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appbazar.databinding.ActivityMenuBinding

class menuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val btn_Calculadora = binding.btnCalc
        val btn_Convert = binding.btnConversor
        val btn_Jogo = binding.btnJogo

        btn_Calculadora.setOnClickListener{ abrirCalculadora() }

        btn_Convert.setOnClickListener { abrirConversor() }

        btn_Jogo.setOnClickListener { abrirJogo() }
    }

    private fun abrirCalculadora(){
        val intent = Intent(this,CalculadoraActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun abrirConversor(){
        val intent1 = Intent(this,ConversorActivity::class.java)
        startActivity(intent1)
        finish()
    }

    private fun abrirJogo(){
        val intent2 = Intent(this,CaraCoroaActivity::class.java)
        startActivity(intent2)
        finish()
    }
}