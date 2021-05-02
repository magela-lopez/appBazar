package com.example.appbazar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appbazar.databinding.ActivityCaraCoroaBinding
import java.util.*

class CaraCoroaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCaraCoroaBinding
    var contCara : Int = 0
    var contCoroa : Int = 0
    var acertos : Int = 0
    var erros : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCaraCoroaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val toolbar = binding.toolbarCaraCoroa
        if(toolbar != null){
            toolbar.title = "Cara ou Coroa?"
        }

        var btn_Cara = binding.btnCara
        var btn_Coroa = binding.btnCoroa
        var btn_Zerar = binding.btnLimpar
        var btn_Voltar = binding.btnVoltar

        btn_Cara.setOnClickListener {
            var randomInt = Random().nextInt(2)+1
            val intent = Intent(this,JogoActivity::class.java)
           intent.putExtra("numero", randomInt)
            startActivity(intent)
            val escolhas = "cara"
            ResultadoJogo(escolhas, randomInt)
        }

        btn_Coroa.setOnClickListener {
            var randomInt = Random().nextInt(2)+1
            val intent = Intent(this,JogoActivity::class.java)
            intent.putExtra("numero", randomInt)
            startActivity(intent)
            val escolhas = "coroa"
            ResultadoJogo(escolhas, randomInt)
        }

        btn_Zerar.setOnClickListener { Limpar() }
        btn_Voltar.setOnClickListener { Voltar() }
    }

    private fun ResultadoJogo(escolhas: String?, randomInt: Int) {

        var txt_cara = binding.txtContCara
        var txt_coroa = binding.txtContCoroa
        var txt_Acertos = binding.txtContAcertos
        var txt_Erros = binding.txtContErros

        if(randomInt.equals(1)){
            contCara++
            txt_cara.setText(contCara.toString())
        }else{
            contCoroa++
            txt_coroa.setText(contCoroa.toString())
        }

        if(escolhas.equals("cara") && randomInt.equals(1)){
            acertos ++
            txt_Acertos.setText(acertos.toString())
        }else if (escolhas.equals("coroa") && !randomInt.equals(1)){
            acertos ++
            txt_Acertos.setText(acertos.toString())
        }else{
            erros ++
            txt_Erros.setText(erros.toString())
        }
    }

    private fun Limpar() {

        var txt_cara = binding.txtContCara
        var txt_coroa = binding.txtContCoroa
        var txt_Acertos = binding.txtContAcertos
        var txt_Erros = binding.txtContErros
        contCara = 0
        contCoroa = 0
        acertos = 0
        erros = 0

        txt_cara.setText("")
        txt_coroa.setText("")
        txt_Acertos.setText("")
        txt_Erros.setText("")
    }

    private fun Voltar(){
        val intent = Intent(this,menuActivity::class.java)
        startActivity(intent)
        finish()
    }
}

