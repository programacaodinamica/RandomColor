package br.com.programacaodinamica.randomcolor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.programacaodinamica.randomcolor.model.NamedColor

class ColorAdapter(private var items:List<NamedColor> = listOf()):
                    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemCount() = items.size

    fun setData(colors: List<NamedColor>){
        items = colors
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val card = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.colors_item, parent, false)
        return ColorViewHolder(card)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ColorViewHolder){
            val color = items[position]
            holder.colorCard.setCardBackgroundColor(color.id)
            holder.codeTextView.text = color.code
            holder.nameTextView.text = color.name
        }
    }

    class ColorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val colorCard: CardView = itemView.findViewById(R.id.color_card_item)
        val nameTextView: TextView = itemView.findViewById(R.id.color_name_textview)
        val codeTextView: TextView = itemView.findViewById(R.id.color_code_textview)
    }
}