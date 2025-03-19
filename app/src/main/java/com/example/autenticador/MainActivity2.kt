package com.example.autenticador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.autenticador.MainActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val uid = intent.getStringExtra("usernameKey")
        val textoTela = findViewById<TextView>(R.id.textoTV)
        val botaoVoltar = findViewById<Button>(R.id.voltar)
        val botaoReset = findViewById<Button>(R.id.reset)
        val botaoContador = findViewById<Button>(R.id.contador)
        var contagem = 0

        textoTela.setText(uid.toString())

        botaoVoltar.setOnClickListener {

            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(intent)

        }

        botaoReset.setOnClickListener{

            contagem = 0

            textoTela.setText("Olá Mundo!")
        }

        botaoContador.setOnClickListener {
            contagem++
            textoTela.setText(contagem.toString())
        }
    }

}