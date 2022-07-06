package com.campanula.study

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.campanula.study.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    companion object {
        const val TAG = "SecondActivity"
    }

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}