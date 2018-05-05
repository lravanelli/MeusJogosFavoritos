package lravanelli.com.br.meusjogosfavoritos.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.meu_jogo_item.view.*
import lravanelli.com.br.meusjogosfavoritos.R
import lravanelli.com.br.meusjogosfavoritos.model.Jogo

class JogoAdapter(
        val context: Context,
        val jogos: List<Jogo>,
        val listener: (Jogo) -> Unit,
        val listenerDelete: (Jogo) -> Unit) : RecyclerView.Adapter<JogoAdapter.JogoViewHolder>() {

    override fun getItemCount(): Int {

        return jogos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): JogoViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.meu_jogo_item, parent, false)
        return JogoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JogoViewHolder?, position: Int) {

        val jogo = jogos[position]

        holder?.let {
            holder.bindView(jogo, listener, listenerDelete)
        }
    }

    class  JogoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(jogo: Jogo, listener: (Jogo) -> Unit, listenerDelete: (Jogo) -> Unit) = with(itemView) {

            tvTitulo.text = jogo.titulo
            tvLancamento.setText(context.getString(R.string.lancamento, jogo.anoLancamento))
            tvDescricao.text = jogo.descricao
            ivFoto.setImageDrawable(ContextCompat.getDrawable(context, jogo.fotoId))

            ivDelete.setOnClickListener{
                listenerDelete(jogo)
            }

            setOnClickListener { listener(jogo) }
        }
    }
}