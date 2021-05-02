package com.example.appbazar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.appbazar.databinding.ActivityConversorBinding

class ConversorActivity : AppCompatActivity() {

    private lateinit var binding : ActivityConversorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConversorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val toolbar = binding.toolbarConversor
        if(toolbar != null){
            toolbar.title = "Conversão"
        }

        var txtChave = binding.txtChave
        var txtValor = binding.txtValor
        var btn_Peso =binding.btnPeso
        var btn_Real = binding.btnReal
        var btn_Limpar = binding.btnLimpa
        var btn_Voltar = binding.btnVolta

        btn_Limpar.setOnClickListener { limpar(txtValor) }
        btn_Voltar.setOnClickListener { voltar() }

        btn_Peso.setOnClickListener { calculoPeso(txtChave, txtValor) }
        btn_Real.setOnClickListener { calculoReal(txtChave, txtValor) }
    }

    private fun calculoPeso(txtChave: EditText, txtValor: EditText) {
        var resultado = binding.txtResultado

        var chave = txtChave.getText().toString().toDouble()
        var valor = txtValor.getText().toString().toDouble()

        var res = chave * valor

        resultado.setText("$" + res.toString())

    }
    private fun calculoReal(txtChave: EditText, txtValor: EditText) {
        var resultado = binding.txtResultado

        var chave = txtChave.getText().toString().toDouble()
        var valor = txtValor.getText().toString().toDouble()

        var res = valor / chave

        resultado.setText("R$" + res.toString())
    }

    private fun limpar(txtValor: EditText) {
        txtValor.setText("")
    }
    private fun voltar(){
        val intent = Intent(this,menuActivity::class.java)
        startActivity(intent)
        finish()
    }
}