package com.example.progreso

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var customView: CustomView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customView = findViewById(R.id.custom_view)

        findViewById<Button>(R.id.button_reiniciar).setOnClickListener {
            customView.reiniciar()
        }

        findViewById<Button>(R.id.button_avanzar).setOnClickListener {
            customView.avanzar()
        }
    }
}
