package com.example.appbazar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.appbazar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            abrirMenu()}, 2000)
    }

    private fun abrirMenu() {
        val intent = Intent(this,menuActivity::class.java)
        startActivity(intent)
        finish()
    }

}