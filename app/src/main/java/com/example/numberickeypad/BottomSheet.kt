package com.example.numberickeypad

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*
import java.lang.StringBuilder

class BottomSheet : Fragment(), View.OnClickListener {
    private lateinit var sheetBehavior: BottomSheetBehavior<View>
    private var content = StringBuilder()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
        click.setOnClickListener {
            showKeypad()
        }
    }

    override fun onClick(view: View?) {
        content.append(
            when (view) {
                one -> {
                    1
                }
                two -> {
                    2
                }
                three -> {
                    3
                }
                four -> {
                    4
                }
                five -> {
                    5
                }
                six -> {
                    6
                }
                seven -> {
                    7
                }
                eight -> {
                    8
                }
                nine -> {
                    9
                }
                zero -> {
                    0
                }
                double_zero -> {
                    "00"
                }
                remove -> {
                    if (content.isNotEmpty())
                        content.setLength(content.length - 1)
                    ""
                }
                else -> {
                    ""
                }
            }
        )
        Log.d("Mrx", "content = $content")
    }

    fun showKeypad() {
        if (sheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
            sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    fun hideKeypad() {
        if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    private fun initClickListener() {
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        zero.setOnClickListener(this)
        double_zero.setOnClickListener(this)
        remove.setOnClickListener(this)
    }
}