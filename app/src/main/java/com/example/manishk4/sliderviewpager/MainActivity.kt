package com.example.manishk4.sliderviewpager

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast


class MainActivity : AppCompatActivity(), OnSliderItemClickListener {

    val TAG = MainActivity::class.java.simpleName
    lateinit var dotsLayout: LinearLayout
    lateinit var dots: Array<ImageView?>
    val layouts = arrayOf<Int>(R.layout.slide_one, R.layout.slide_two, R.layout.slide_three)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dotsLayout = findViewById(R.id.layoutDots)
        dotsLayout.orientation = LinearLayout.HORIZONTAL
        addBottomDots(0)

        val sliderViewPagerAdapter = SliderViewPagerAdapter(layouts)
        sliderViewPagerAdapter.setOnSliderItemClickListener(this)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = sliderViewPagerAdapter


        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(position: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(position: Int) {
                addBottomDots(position)
            }
        })
    }

    fun addBottomDots(currentPosition: Int) {
        Log.d(TAG, "addBottomDots $currentPosition")
        dotsLayout.removeAllViews()
        dots = arrayOfNulls<ImageView>(layouts.size)        // IMPORTANT - arrayOfNulls
        dots.forEachIndexed { index, imageView ->
            dots[index] = ImageView(this)
            if (index == currentPosition) {
                dots[index]!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dots_active))
            } else {
                dots[index]!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dots_default))
            }

            val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(8, 0, 8, 0)
            dotsLayout.addView(dots[index], layoutParams)
        }
    }

    override fun onSliderItemClick(slidePosition: Int, view: View) {
        Log.d(TAG, "onSliderItemClick -- Position : $slidePosition")
        if (slidePosition == 0) {
            view.findViewById<ImageView>(R.id.ivCall).setOnClickListener {
                Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show()
            }

            view.findViewById<ImageView>(R.id.iv_email).setOnClickListener {
                Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show()
            }

            view.findViewById<ImageView>(R.id.iv_add).setOnClickListener {
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show()
            }

            view.findViewById<ImageView>(R.id.iv_star).setOnClickListener {
                Toast.makeText(this, "Star", Toast.LENGTH_SHORT).show()
            }

        } else if (slidePosition == 1) {
            view.findViewById<ImageView>(R.id.iv_delete).setOnClickListener {
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
            }

            view.findViewById<ImageView>(R.id.iv_call_other).setOnClickListener {
                Toast.makeText(this, "Call Other", Toast.LENGTH_SHORT).show()
            }

            view.findViewById<ImageView>(R.id.iv_call_normal).setOnClickListener {
                Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show()
            }

            view.findViewById<ImageView>(R.id.iv_missed_call).setOnClickListener {
                Toast.makeText(this, "Missed Call", Toast.LENGTH_SHORT).show()
            }
        } else if (slidePosition == 2) {
            view.findViewById<ImageView>(R.id.iv_drop_down).setOnClickListener {
                Toast.makeText(this, "Drop Down", Toast.LENGTH_SHORT).show()
            }
        }
    }

}