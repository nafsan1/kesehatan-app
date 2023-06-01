package com.example.vascomm.helper

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView

class CustomScrollView(context: Context, attrs: AttributeSet) : ScrollView(context, attrs) {

    var canScroll = true

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return if (canScroll) {
            super.onInterceptTouchEvent(ev)
        } else false
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return if (canScroll) {
            super.onTouchEvent(ev)
        } else false
    }


}