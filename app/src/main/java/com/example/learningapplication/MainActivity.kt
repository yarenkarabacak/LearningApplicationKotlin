package com.example.learningapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.learningapplication.ui.CharactersFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlin.concurrent.fixedRateTimer

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}