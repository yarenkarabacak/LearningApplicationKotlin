package com.example.learningapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learningapplication.databinding.FragmentCharacterDbBinding
import com.example.learningapplication.data_for_room.Character
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDbFragment : Fragment() {

    private var _binding: FragmentCharacterDbBinding? = null
    private val binding get() = _binding!!

    lateinit var characterList: LiveData<List<Character>>

    private val viewModel: CharacterDbViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterDbBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharListAdapter()
        binding.recyclerView.adapter = adapter

        characterList = viewModel.getAllCharacters()

        characterList.observe(this.viewLifecycleOwner) { chars ->
            chars.let {
                if (it.isEmpty()) {
                    binding.toolbarDb.title = "Nothing to show here"
                }
                else {
                    binding.toolbarDb.title = "Characters from database"
                }
                adapter.submitList(it)
            }
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
    }


}