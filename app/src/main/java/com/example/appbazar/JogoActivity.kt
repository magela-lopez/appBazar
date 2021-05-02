package com.example.appbazar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.appbazar.databinding.ActivityCaraCoroaBinding
import com.example.appbazar.databinding.ActivityJogoBinding
import java.util.Random

class JogoActivity : AppCompatActivity() {

    lateinit var moedaImagem: ImageView
    private lateinit var binding : ActivityJogoBinding
    lateinit var escolha : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityJogoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        moedaImagem = binding.imgQuestion

        var btn_Atras = binding.btnAtras

        var bundle :Bundle ?=intent.extras
        var num = bundle!!.getInt("numero")

        if(num.equals(1)){
            moedaImagem.setImageResource(R.drawable.cara)
            escolha = "cara"
        }else{
            moedaImagem.setImageResource(R.drawable.coroa)
            escolha = "coroa"
        }

        btn_Atras.setOnClickListener {
           atras()
        }
    }

    private fun atras(){
        //val intent= Intent(this,CaraCoroaActivity::class.java)
        finish()
    }
}