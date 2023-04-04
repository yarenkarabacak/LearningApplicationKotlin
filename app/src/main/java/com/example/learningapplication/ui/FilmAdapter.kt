package com.example.learningapplication.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapplication.R
import com.example.learningapplication.data.Characters
import com.example.learningapplication.data.Films
import com.example.learningapplication.databinding.CardFilmsBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class FilmAdapter(var mContext: Context, var filmList: List<Films>) :
    RecyclerView.Adapter<FilmAdapter.CardHolder>() {

    class CardHolder (binding: CardFilmsBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding : CardFilmsBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardFilmsBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_films, parent,  false)
        return CardHolder(binding)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {

        val film = filmList.get(position)
        val design = holder.binding
        design.filmObject = film
    }

    }