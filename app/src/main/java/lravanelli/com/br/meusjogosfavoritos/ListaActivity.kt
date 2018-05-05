package lravanelli.com.br.meusjogosfavoritos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lista.*
import lravanelli.com.br.meusjogosfavoritos.adapter.JogoAdapter
import lravanelli.com.br.meusjogosfavoritos.model.Jogo

class ListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        rvJogos.adapter = JogoAdapter(this, getJogos(), {



            val intentDetalhe = Intent(this, DetalheActivity::class.java)

            intentDetalhe.putExtra("jogo", it)

            startActivity(intentDetalhe)

        })
        rvJogos.layoutManager = LinearLayoutManager(this)

    }

    fun getJogos(): List<Jogo> {
        return listOf(
                Jogo(getString(R.string.titulo_gof_war),
                        getString(R.string.descricao_god_of_war),
                        2018,
                        R.drawable.godofwar,
                        R.drawable.godofwarbanner)
        )
    }
}
