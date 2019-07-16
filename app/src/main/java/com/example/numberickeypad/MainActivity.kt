package com.example.numberickeypad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import uz.anorsystem.customtextviewlibrary.DoubleTextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val custom = uz.anorsystem.customtextviewlibrary.Customs(bottoms as ConstraintLayout?)
        double_bottom_sheet.setOnClickListener {
            custom.setView(it as DoubleTextView?)
        }

        double_bottom_sheet2.setOnClickListener {
            custom.setView(it as DoubleTextView?)
        }
    }
}
