package com.intrast.depi_g1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.intrast.depi_g1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        binding.viewModel = viewModel

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Create observer to update team A score on screen:
        val scoreA_Observer = Observer<Int> { newValue ->
            binding.teamAScore.text = newValue.toString()
        }

        viewModel.scoreA.observe(this, scoreA_Observer)

        val scoreB_Observer = Observer<Int> { newValue ->
            binding.teamBScore.text = newValue.toString()
        }

        viewModel.scoreB.observe(this, scoreB_Observer)



    }
}