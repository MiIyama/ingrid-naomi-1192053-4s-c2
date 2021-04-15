package br.com.iyama.petshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Tela2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        val cachorro = intent.getStringExtra("cachorro")
        val raca = intent.getStringExtra("raca")
        val indicadoCriancas = intent.getBooleanExtra("indicadoCriancas", false)

        val mensagem = " $cachorro - $raca - $indicadoCriancas"
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }





}