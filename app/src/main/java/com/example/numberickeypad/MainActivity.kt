package com.example.numberickeypad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val custom = Customs(bottom_sheet)
        double_bottom_sheet.setOnClickListener {
            custom.setView(it as DoubleTextView?)
        }

        double_bottom_sheet2.setOnClickListener {
            custom.setView(it as DoubleTextView?)
        }
    }
}
