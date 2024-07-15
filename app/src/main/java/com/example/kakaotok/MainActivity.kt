package com.example.kakaotok

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kakaotok.databinding.ActivityMainBinding
import com.example.yourapp.ChangActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.small.setOnClickListener {
            count = 1
            val intent = Intent(this, ChangActivity::class.java)
            startActivityForResult(intent, 1)  // startActivityForResult 사용
        }

        binding.nigar.setOnClickListener {
            count = 2
            val intent = Intent(this, ChangActivity::class.java)
            startActivityForResult(intent, 2)  // startActivityForResult 사용
        }

        binding.pig.setOnClickListener {
            count = 3
            val intent = Intent(this, ChangActivity::class.java)
            startActivityForResult(intent, 3)  // startActivityForResult 사용
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            val name = data.getStringExtra("name")
            val message = data.getStringExtra("statusMessage")
            if (name != null && message != null) {
                handleMessage(name, message)
            }
        }
    }

    private fun handleMessage(name: String, message: String) {
        val nigna = binding.niggarname
        val gayna = binding.pigname
        val smana = binding.smallname
        val smame = binding.smallmessage
        val nigme = binding.nigmessage
        val gayme = binding.pigmessage

        when (count) {
            1 -> {
                smana.text = name
                smame.text = message
            }
            2 -> {
                nigna.text = name
                nigme.text = message
            }
            3 -> {
                gayna.text = name
                gayme.text = message
            }
        }
    }
}
