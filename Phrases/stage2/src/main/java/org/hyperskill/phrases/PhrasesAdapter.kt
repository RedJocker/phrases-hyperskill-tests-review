package org.hyperskill.phrases

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhrasesAdapter(val phrases: MutableList<Phrase>) : RecyclerView.Adapter<PhrasesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhrasesViewHolder {
        return PhrasesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_phrase, parent, false))
    }

    override fun onBindViewHolder(holder: PhrasesViewHolder, position: Int) {
        var phrase = phrases[position]

        holder.phrase.text = phrase.phrase
        holder.delete.setOnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                phrases.removeAt(position)
                notifyItemRemoved(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return phrases.size
    }
}

class PhrasesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val phrase = view.findViewById<TextView>(R.id.phraseTextView)
    val delete = view.findViewById<TextView>(R.id.deleteTextView)
}