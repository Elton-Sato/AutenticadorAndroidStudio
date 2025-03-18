package com.example.autenticador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = findViewById<EditText>(R.id.usernameET)
        val password = findViewById<EditText>(R.id.passwordET)
        val botaoLogin = findViewById<Button>(R.id.loginBT)
        val botaoCadastro = findViewById<Button>(R.id.cadastroBT)

        val auth = FirebaseAuth.getInstance()


        botaoCadastro.setOnClickListener{
            auth.createUserWithEmailAndPassword(username.text.toString(), password.text.toString())
                .addOnSuccessListener{
                    Toast.makeText(applicationContext, "Cadastro feito com Sucesso!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(applicationContext, "Cadastro falhou.", Toast.LENGTH_SHORT).show()
                }
        }

        botaoLogin.setOnClickListener{
            auth.signInWithEmailAndPassword(username.text.toString(), password.text.toString())
                .addOnSuccessListener{
                    Toast.makeText(applicationContext, "Login feito com Sucesso!", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    intent.putExtra("usernameKey", auth.currentUser?.uid)
                    startActivity(intent)

                }
                .addOnFailureListener{
                    Toast.makeText(applicationContext, "Login falhou.", Toast.LENGTH_SHORT).show()
                }

        }


    }
}