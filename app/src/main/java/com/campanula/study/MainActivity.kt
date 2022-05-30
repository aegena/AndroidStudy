package com.campanula.study

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.annotation.UiThread
import androidx.annotation.WorkerThread
import androidx.appcompat.app.AppCompatActivity
import com.campanula.android.kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate:this thread id:${Thread.currentThread().id}")
        runThread()
        runOnUiThread {
            Log.d(TAG, "runOnUiThread:this thread id:${Thread.currentThread().id}")
        }
        workerThread()
    }

    private fun runThread() {
        Thread({
            Log.d(TAG, "runThread:this thread id:${Thread.currentThread().id}")
            uiThread()
        }).start()
    }


    @UiThread
    private fun uiThread() {
        Log.d(TAG, "uiThread:this thread id:${Thread.currentThread().id}")
        binding.mTextView.text = "annotation @UiThread from Thread"
        binding.mTextView.textSize = 33f
    }

    @WorkerThread
    private fun workerThread() {
        Log.d(TAG, "workerThread:this thread id:${Thread.currentThread().id}")
        binding.mTextView.text = "annotation @workerThread from Thread"
        binding.mTextView.textSize = 33f
        binding.mTextView.setTextColor(Color.parseColor("#FF0000"))
    }


}