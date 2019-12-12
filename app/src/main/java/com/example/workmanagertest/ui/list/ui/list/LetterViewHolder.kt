package com.example.workmanagertest.ui.list.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workmanagertest.R
import com.example.workmanagertest.data.Letter

class LetterViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.view_holder, parent, false)
) {

    private val nameView = itemView.findViewById<TextView>(R.id.name)
    private val contentView = itemView.findViewById<TextView>(R.id.content)
    private val idView = itemView.findViewById<TextView>(R.id.id)
    private val createdView = itemView.findViewById<TextView>(R.id.created)
    private val expiredView = itemView.findViewById<TextView>(R.id.expired)
    var letter: Letter? = null
    fun bindTo(letter: Letter?) {
        this.letter = letter
        nameView.text = letter?.subject
        contentView.text = letter?.content
        idView.text = letter?.id.toString()
        createdView.text = letter?.created.toString()
        expiredView.text = letter?.expired.toString()

    }
}