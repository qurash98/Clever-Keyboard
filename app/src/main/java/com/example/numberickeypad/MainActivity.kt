package com.example.numberickeypad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import kotlinx.android.synthetic.main.content_main.*
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var sheetBehavior: BottomSheetBehavior<View>

    private var content = StringBuilder()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = text

        initBottomSheet()

        btn_bottom_sheet.setOnClickListener {
            if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                hideKeypad()
            } else {
                showKeypad()
            }
        }

    }

    fun showKeypad() {
        sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    fun hideKeypad() {
        if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    private fun initBottomSheet() {
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        val onClickListener = View.OnClickListener { view ->
            content.append(
                if (view == remove) {
                    if (content.isNotEmpty())
                        content.setLength(content.length - 1)
                    ""
                } else {
                    (view as? TextView)?.text
                }
            )
            Log.d("Mrx", "content = $content")
            calcView.text = content
        }
        one.setOnClickListener(onClickListener)
        two.setOnClickListener(onClickListener)
        three.setOnClickListener(onClickListener)
        four.setOnClickListener(onClickListener)
        five.setOnClickListener(onClickListener)
        six.setOnClickListener(onClickListener)
        seven.setOnClickListener(onClickListener)
        eight.setOnClickListener(onClickListener)
        nine.setOnClickListener(onClickListener)
        zero.setOnClickListener(onClickListener)
        double_zero.setOnClickListener(onClickListener)
        remove.setOnClickListener(onClickListener)
        remove.setOnLongClickListener { view ->
            if (view == remove) {
                if (content.isNotEmpty()) {
                    content.setLength(0)
                    calcView.text = content
                }
                true
            } else {
                false
            }
        }
    }

}
