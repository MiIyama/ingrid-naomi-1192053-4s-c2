package br.com.iyama.petshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun compra(view: View) {
        val tela2 = Intent(this, Tela2::class.java)


        tela2.putExtra("cachorro", "Dalmata")
        tela2.putExtra("raca", "Cartwright")
        tela2.putExtra("indicadoCriancas", true)

        startActivity(tela2)
        val layoutLista: LinearLayout = findViewById(R.id.layout_lista)
        val apiCachorro = ConexaoApi.criar()

        apiCachorro.get(id).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                val tvDescricao: TextView = findViewById(R.id.tv_descricao)
                val cachorro = response.body()
                if (cachorro != null) {
                    tvDescricao.text =
                        "Id: ${cachorro.id} - raca: ${cachorro.raca} - precoMedio: ${cachorro.precoMedio}- indicadoCriancas: ${cachorro.indicadoCriancas}"
                } else {
                    tvDescricao.text = "Id não encontrado!!!"
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Erro: ${t.message!!}", Toast.LENGTH_SHORT).show()

            }
        })
    }


}
}
