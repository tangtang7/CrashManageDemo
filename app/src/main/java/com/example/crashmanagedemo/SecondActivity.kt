package com.example.crashmanagedemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.crashmanagedemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    var button3 : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button3 = findViewById(R.id.button3)
        button3?.setOnClickListener {
            finish()
        }
    }
}