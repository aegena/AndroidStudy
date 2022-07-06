package com.campanula.study

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.campanula.study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val composeToolbar = binding.composeToolbar
        composeToolbar.setRightClickListener { v ->
            Toast.makeText(MainActivity@ this, "right", Toast.LENGTH_SHORT).show()
        }
        binding.btnViewGroup.setOnClickListener { v ->
            startActivity(Intent(MainActivity@ this, SecondActivity::class.java))
        }
    }

}