package com.danser.lambda_samples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
    }


    private fun setupViews() {
        etInput.addTextChangedListener { editable ->
            val value = editable?.toString() ?: ""
            val formattedValue = formatValue(value)
            tvFormattedText.text = formattedValue
        }
    }

    private fun formatValue(src: String): String = src
        .split(" ")
        .toSet()
        .sortedByDescending { it.length }
        .mapIndexed { idx, word -> "$idx. $word"}
        .joinToString("\n") { it.toLowerCase() }
}
