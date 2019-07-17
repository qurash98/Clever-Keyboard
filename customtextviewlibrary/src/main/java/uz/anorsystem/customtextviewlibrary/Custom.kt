package uz.anorsystem.customtextviewlibrary

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class Customs(bottom_sheet: ConstraintLayout?) {
    private val bSheet = bottom_sheet
    private lateinit var custom: DoubleTextView
    private var sheetBehavior: BottomSheetBehavior<View> = BottomSheetBehavior.from(bottom_sheet)
    private lateinit var header: TextView
    private lateinit var sub: TextView
    private var open = true
    private var first = true
    private var isClose = true
    private var oldS: Long = 0
    private var sum: Long = 0
    private var newS: Long = 0

    fun setView(dBottomSheet: DoubleTextView?) {
        if (dBottomSheet != null) {
            if (isClose) {
                custom = dBottomSheet
                init()
                showKeypad()
            } else {
                hideKeypad()
            }
        }
    }

    private fun init() {
        header = custom.getHeaderTextView()
        sub = custom.getSubTextView()
        initBottomSheet()
    }

    fun getResult(): String {
        return header.text.toString()
    }

    @SuppressLint("SetTextI18n")
    private fun initBottomSheet() {
        val onClickListener = View.OnClickListener { view ->
            if (first) {
                if (view != bSheet!!.getChildAt(13)) {
                    open = false
                    sub.visibility = View.VISIBLE
                    sub.text = "$oldS"
                }
                first = false
            }

            if (open) {
                if (view == bSheet!!.getChildAt(13)) {
                    oldS /= 10
                } else {
                    if (oldS < 1000000) {
                        if (view == bSheet.getChildAt(11)) {
                            oldS *= 100
                        } else {
                            oldS = oldS * 10 + (view as? TextView)?.text.toString().toLong()
                        }
                    }
                }
                header.text = "$oldS"
            } else {
                if (view == bSheet!!.getChildAt(13)) {
                    newS /= 10
                } else {
                    if (newS < 1000000) {
                        if (view == bSheet.getChildAt(11)) {
                            newS *= 100
                        } else {
                            newS = newS * 10 + (view as? TextView)?.text.toString().toLong()
                        }
                    }
                }
                header.text = "$newS"
                sum = newS + oldS
                sub.text = "$oldS + $newS = $sum"
            }
        }
        bSheet!!.getChildAt(0).setOnClickListener(onClickListener)
        bSheet.getChildAt(1).setOnClickListener(onClickListener)
        bSheet.getChildAt(2).setOnClickListener(onClickListener)
        bSheet.getChildAt(4).setOnClickListener(onClickListener)
        bSheet.getChildAt(5).setOnClickListener(onClickListener)
        bSheet.getChildAt(6).setOnClickListener(onClickListener)
        bSheet.getChildAt(8).setOnClickListener(onClickListener)
        bSheet.getChildAt(9).setOnClickListener(onClickListener)
        bSheet.getChildAt(10).setOnClickListener(onClickListener)
        bSheet.getChildAt(11).setOnClickListener(onClickListener)
        bSheet.getChildAt(12).setOnClickListener(onClickListener)
        bSheet.getChildAt(13).setOnClickListener(onClickListener)//remove
        bSheet.getChildAt(7).setOnClickListener {
            hideKeypad()
        }//next
        bSheet.getChildAt(3).setOnClickListener {
            hideKeypad()
        }

        bSheet.getChildAt(13).setOnLongClickListener {
            if (it == bSheet.getChildAt(13)) {
                if (open) {
                    oldS = 0
                    header.text = "$oldS"
                } else {
                    newS = 0
                    header.text = "$newS"
                }
                true
            } else {
                false
            }
        }
    }

    private fun showKeypad() {
        if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
//
            oldS = header.text.toString().toLong()
            isClose = false
            Log.d("RRR", "$oldS")
            sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    private fun hideKeypad() {
        if (open) {
            header.text = "$oldS"
        } else {
            sum = oldS + newS
            header.text = "$sum"
        }
        first = true
        open = true
        isClose = true
        oldS = 0
        newS = 0
        sum = 0
        sub.visibility = View.GONE
        sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

}