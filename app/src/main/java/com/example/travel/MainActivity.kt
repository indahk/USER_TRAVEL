package com.example.travel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.travel.pku.Activity_ke1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val panggilpku: Button = findViewById(R.id.pku)
        panggilpku.setOnClickListener {
            val intent = Intent(this, Activity_ke1::class.java)
            startActivity(intent)
        }
        val panggilduri: Button = findViewById(R.id.duri)
        panggilduri.setOnClickListener {
            val intent = Intent(this, Activity_ke1::class.java)
            startActivity(intent)
        }
    }}