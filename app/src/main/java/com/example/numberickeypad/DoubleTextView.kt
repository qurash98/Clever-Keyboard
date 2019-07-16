package com.example.numberickeypad

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.double_custom_content.view.*

class DoubleTextView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.double_custom_content, this, true)
        attrs?.let {
            val styledAttr = context?.obtainStyledAttributes(it, R.styleable.DoubleText)
            styledAttr!!.recycle()
        }
    }

    fun getHeaderTextView() = header_text
    fun getSubTextView() = sub_text
}