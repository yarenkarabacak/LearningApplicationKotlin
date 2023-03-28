package com.example.learningapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapplication.R
import com.example.learningapplication.data_for_room.Character

import com.example.learningapplication.databinding.ItemCharDbBinding

class CharListAdapter(private val onItemClicked: (Character) -> Unit) :
    ListAdapter<Character, CharListAdapter.CharViewHolder>(DiffCallBack){

    class CharViewHolder (binding: ItemCharDbBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding : ItemCharDbBinding

        init {
            this.binding = binding
        }
        fun bind(char: Character) {
            binding.apply {
                charNameDb.text = char.charName
                charHeightDb.text = char.charHeight.toString()
                charMassDb.text = char.charMass.toString()
                charHairColorDb.text = char.charHair_color
                charSkinColorDb.text = char.charSkin_color
                charEyeColorDb.text = char.charEye_color
                charBirthYearDb.text = char.charBirth_year
                charGenderDb.text = char.charGender
            }
        }
    }

        /*class CharViewHolder(private var binding: ItemCharDbBinding):
            RecyclerView.ViewHolder(binding.root) {
                fun bind(char: Character) {
                    binding.apply {
                        charNameDb.text = char.charName
                        charHeightDb.text = char.charHeight.toString()
                        charMassDb.text = char.charMass.toString()
                        charHairColorDb.text = char.charHair_color
                        charSkinColorDb.text = char.charSkin_color
                        charEyeColorDb.text = char.charEye_color
                        charBirthYearDb.text = char.charBirth_year
                        charGenderDb.text = char.charGender
                    }
                }
            }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharViewHolder {
        return CharViewHolder(ItemCharDbBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CharViewHolder, position: Int) {
        val design = holder.binding
        val character = getItem(position)
        var filmUrlList = mutableListOf<String>()

        design.cardViewToListDb.setOnClickListener {
            println(character)
            filmUrlList.addAll(character.filmUrls)
            val list = filmUrlList.toTypedArray()

            val bundle = bundleOf("filmms" to list)
            Navigation.findNavController(it).navigate(R.id.chars_db_to_films,bundle)

        }
        holder.bind(character)


    }

    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.charName == newItem.charName
            }

        }
    }
}