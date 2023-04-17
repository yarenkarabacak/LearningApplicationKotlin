package com.example.learningapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.learningapplication.R
import com.example.learningapplication.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.toolbarHome.title = "Home Page"

        goToCharactersFromApiPage()

        goToCharactersFromDbPage()

        chooseWhichPageToGo()

        return binding.root
    }

    private fun goToCharactersFromApiPage() {
        binding.buttonShow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.home_to_chars)
        }
    }

    private fun goToCharactersFromDbPage() {
        binding.buttonDbShow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.home_to_db_chars)
        }
    }

    private fun chooseWhichPageToGo() {
        viewModel.numberOfCharacters.observe(viewLifecycleOwner) {
            binding.buttonCheck.setOnClickListener {

                if (viewModel.numberOfCharacters.value == 0) {
                    Navigation.findNavController(it).navigate(R.id.home_to_chars)
                    Toast.makeText(requireContext(), "Characters shown from API", Toast.LENGTH_LONG).show()
                }
                else {
                    Navigation.findNavController(it).navigate(R.id.home_to_db_chars)
                    Toast.makeText(requireContext(), "Characters shown from Database", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}