package com.example.yourapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.example.kakaotok.MainActivity
import com.example.kakaotok.databinding.ActivityChangBinding

class ChangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.confirmBtn.setOnClickListener{
            val name = binding.realname.text.toString()
            val statusMessage = binding.message.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("name", name)
            resultIntent.putExtra("statusMessage",statusMessage)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
