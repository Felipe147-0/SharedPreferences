package com.example.sharedpreferencese1

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreferencese1.databinding.ActivityMainBinding
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    companion object{
        const val FILE_NAME =  "arquivo_dados"
        const val KEY_NAME = "update_time"
    }
   private lateinit var binding: ActivityMainBinding
   private lateinit var preferences: SharedPreferences

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE)
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    override fun onStop() {
        record()
        super.onStop()
    }

    private fun updateUI(){
        val str = preferences.getString(KEY_NAME, "vazio")
        binding.textLastUpdate.text = str
    }

    private fun record(){
        val str = LocalDateTime.now().toString()
        preferences.edit()
            .putString(KEY_NAME, str)
            
    }
}