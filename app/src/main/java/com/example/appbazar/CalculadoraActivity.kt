package com.example.appbazar

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appbazar.databinding.ActivityCalculadoraBinding


class CalculadoraActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCalculadoraBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculadoraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val toolbar = binding.toolbarCalc
        if(toolbar != null){
            toolbar.title = "Calculadora"
        }

        var num1 =0.0
        var operador = ""
        var txtResultado =binding.txtResult

        var btn_Limpar = binding.btnLimpar
        var btn_Zero = binding.btn0
        var btn_Um = binding.btn1
        var btn_Dois = binding.btn2
        var btn_Tres = binding.btn3
        var btn_Quatro = binding.btn4
        var btn_Cinco = binding.btn5
        var btn_Seis = binding.btn6
        var btn_Sete = binding.btn7
        var btn_Oito = binding.btn8
        var btn_Nove = binding.btn9
        var btn_Ponto = binding.btnPonto
        var btn_Igual = binding.btnIgual
        var btn_Soma = binding.btnSoma
        var btn_Sub = binding.btnSubtracao
        var btn_Multi = binding.btnMult
        var btn_Divi = binding.btnDiv
        var btn_Voltar = binding.btnVoltar


        btn_Zero.setOnClickListener { txtResultado.setText(txtResultado.getText().toString() +"0") }
        btn_Um.setOnClickListener { txtResultado.setText(txtResultado.getText().toString() +"1") }
        btn_Dois.setOnClickListener { txtResultado.setText(txtResultado.getText().toString() +"2") }
        btn_Tres.setOnClickListener { txtResultado.setText(txtResultado.getText().toString() +"3") }
        btn_Quatro.setOnClickListener { txtResultado.setText(txtResultado.getText().toString() +"4")}
        btn_Cinco.setOnClickListener { txtResultado.setText(txtResultado.getText().toString() +"5") }
        btn_Seis.setOnClickListener { txtResultado.setText(txtResultado.getText().toString() +"6") }
        btn_Sete.setOnClickListener { txtResultado.setText(txtResultado.getText().toString() +"7") }
        btn_Oito.setOnClickListener { txtResultado.setText(txtResultado.getText().toString() +"8") }
        btn_Nove.setOnClickListener { txtResultado.setText(txtResultado.getText().toString() +"9") }
        btn_Ponto.setOnClickListener { txtResultado.setText(txtResultado.getText().toString() + ".") }

        btn_Soma.setOnClickListener {
            var num1Txt = txtResultado.getText().toString()
            num1 = num1Txt.toDouble()
            operador = "+"
            txtResultado.setText("")
        }
        btn_Sub.setOnClickListener {
            var num1Txt = txtResultado.getText().toString()
            num1 = num1Txt.toDouble()
            operador = "-"
            txtResultado.setText("")
        }
        btn_Divi.setOnClickListener {
            var num1Txt = txtResultado.getText().toString()
            num1 = num1Txt.toDouble()
            operador = "/"
            txtResultado.setText("")
        }
        btn_Multi.setOnClickListener {
            var num1Txt = txtResultado.getText().toString()
            num1 = num1Txt.toDouble()
            operador = "*"
            txtResultado.setText("")
        }

        btn_Igual.setOnClickListener { resultadoCalc(txtResultado, num1, operador) }
        btn_Limpar.setOnClickListener { limpar(txtResultado)}
        btn_Voltar.setOnClickListener { voltar() }

    }

    private fun resultadoCalc(txtResultado: TextView, num1: Double, operador: String) {
        var num2Txt = txtResultado.getText().toString()
        var num2 = num2Txt.toDouble()

        if (operador.equals("+")){
           var result = num1 + num2
            txtResultado.setText(result.toString())
        }
        if (operador.equals("-")){
            var result = num1 - num2
            txtResultado.setText(result.toString())
        }
        if (operador.equals("/")){
            var result = num1 / num2
            txtResultado.setText(result.toString())
        }
        if (operador.equals("*")){
            var result = num1 * num2
            txtResultado.setText(result.toString())
        }
    }

    private fun limpar(txtResultado: TextView) {
        txtResultado.setText("")
    }

    private fun voltar(){
        val intent = Intent(this,menuActivity::class.java)
        startActivity(intent)
        finish()
    }
}