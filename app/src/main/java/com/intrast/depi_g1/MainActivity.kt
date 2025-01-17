package com.intrast.depi_g1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.intrast.depi_g1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var teamAScore = 0
    var teamBScore = 0
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.teamAScore.text = teamAScore.toString() //set start score for team A
        binding.teamBScore.text = teamBScore.toString() //set start score for team A

        binding.increaseTeamAScore.setOnClickListener {
            teamAScore++
            binding.teamAScore.text = teamAScore.toString()
        }

        binding.decreaseTeamAScore.setOnClickListener {
            teamAScore--
            binding.teamAScore.text = teamAScore.toString()

        }

        binding.increaseTeamBScore.setOnClickListener {
            teamBScore++
            binding.teamBScore.text = teamBScore.toString()

        }

        binding.decreaseTeamBScore.setOnClickListener {
            teamBScore--
            binding.teamBScore.text = teamBScore.toString()
        }

    }
}