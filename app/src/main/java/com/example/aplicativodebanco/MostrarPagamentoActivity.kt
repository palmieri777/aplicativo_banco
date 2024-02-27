package com.example.aplicativodebanco

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MostrarPagamentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_pagamento)
        setSupportActionBar(findViewById(R.id.toolpagar))
        val saldo = intent.getStringExtra("sSaldo")
        var nsaldo = saldo.toString().toDouble()
        val btpagar = findViewById<Button>(R.id.btpagar)
        val edtpagar = findViewById<EditText>(R.id.valorpagar)


        btpagar.setOnClickListener {
            val data = Intent()
            val edtpagar = findViewById<EditText>(R.id.valorpagar)
            val nvalor = edtpagar.text.toString().toDouble()
            nsaldo -= nvalor
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK,data)
            Toast.makeText(this, "Depósito realizado com sucesso", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "$nsaldo", Toast.LENGTH_SHORT).show()
            edtpagar.setText("".toString())
            finish()
        }

    }
}