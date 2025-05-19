package com.example.myapplicationtmppp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationtmppp.R
import com.example.myapplicationtmppp.ui.LoginActivity

class AdminActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        // Setăm titlul ferestrei
        supportActionBar?.title = "Panou Administrator"

        // Afișăm un mesaj de întâmpinare
        val welcomeText = findViewById<TextView>(R.id.adminWelcomeText)
        welcomeText.text = "Bine ai venit în zona de administrare!"

        // Buton de deconectare
        val logoutBtn = findViewById<Button>(R.id.logoutButton)
        logoutBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
