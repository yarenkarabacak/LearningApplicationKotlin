package com.example.learningapplication.ui

import android.content.Context import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapplication.R
import com.example.learningapplication.data.Characters
import com.example.learningapplication.databinding.CardCharactersBinding


class CharacterAdapter(var mContext: Context, var characterList: List<Characters>) :
    RecyclerView.Adapter<CharacterAdapter.CardHolder>() {

    var index = 0


    class CardHolder (binding: CardCharactersBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding : CardCharactersBinding
        init {
            this.binding = binding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardCharactersBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_characters, parent,  false)
        return CardHolder(binding)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {

        val character = characterList.get(position)
        val design = holder.binding
        design.characterObject = character

        var filmUrlList = mutableListOf<String>()


        design.cardViewToList.setOnClickListener {
            index = position

            filmUrlList.addAll(character.filmUrls)
            val list = filmUrlList.toTypedArray()

            val bundle = bundleOf("filmms" to list)
            Navigation.findNavController(it).navigate(R.id.chars_to_films,bundle)

        }
    }

}