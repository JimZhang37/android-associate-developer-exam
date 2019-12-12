package com.example.workmanagertest.ui.list.ui.list

import android.util.Log
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.workmanagertest.data.Letter

class ListAdapter : PagedListAdapter<Letter, LetterViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Letter>() {
            // Concert details may have changed if reloaded from the database,
            // but ID is fixed.
            override fun areItemsTheSame(
                oldLetter: Letter,
                newLetter: Letter
            ) = oldLetter.id == newLetter.id

            override fun areContentsTheSame(
                oldLetter: Letter,
                newLetter: Letter
            ) = oldLetter == newLetter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        Log.d("Create VH", "new VH")
        return LetterViewHolder(parent)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val letter: Letter? = getItem(position)
        Log.d("Bind VH", "binding VH")
        // Note that "concert" is a placeholder if it's null.
        holder.bindTo(letter)
    }
}