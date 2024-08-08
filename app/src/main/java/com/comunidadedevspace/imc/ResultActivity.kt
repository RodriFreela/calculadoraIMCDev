package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        val  classificacao: String = if (result <= 18.5f){
            "Magreza"
        } else if (result > 18.5f && <= 24.9f){
            "Normal"
        } else if (result > 24.9f && <= 29.9f){
            "Sobrepeso"
        } else if (result > 29.9f && <= 39.9f){
            "Obesidade"
        } else {
            "Obesidade Grave"
        }

        tvClassificacao.text = classificacao


       /* if (result <= 18.5){
            println("Seu imc mostra que você está na classificação Magreza")
        }
        else if (result > 18.5 && result <= 24.9){
            println("Seu imc mostra que você está na classificação Normal")
        }
        else if (result >= 25.0 && result <= 29.9){
            println("Seu imc mostra que você está na classificação Sobrepeso")
        }
        else if (result >= 30.0 && result <= 39.9){
            println("Seu imc mostra que você está na classificação Obesidade")
        }
        else
            println("Seu imc mostra que você está na classificação Obesidade Grave")
       */



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}