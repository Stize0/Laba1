package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var editTextSymbol: EditText
    private lateinit var buttonCheck: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextSymbol = findViewById(R.id.editTextSymbol)
        buttonCheck = findViewById(R.id.buttonCheck)

        buttonCheck.setOnClickListener {
            val input = editTextSymbol.text.toString()

            if (input.length != 1) {
                Toast.makeText(this, "Пожалуйста, введите один символ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val symbol = input[0]

            if (!symbol.isLowerCase() || !symbol.isLetter()) {
                Toast.makeText(this, "Не латинская строчная буква", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            when (symbol) {
                'a', 'e', 'i', 'o', 'u' -> {
                    Toast.makeText(this, "Это гласные буквы", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Возможно, это согласные буквы", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}