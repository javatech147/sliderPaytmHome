package com.example.manishk4.sliderviewpager

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SliderViewPagerAdapter(val layouts: Array<Int>) : PagerAdapter() {

    val TAG = SliderViewPagerAdapter::class.java.simpleName
    private lateinit var onSliderItemClickListener: OnSliderItemClickListener

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(container.context)
        val view: View = layoutInflater.inflate(layouts[position], container, false)
        container.addView(view)
        // Callback for navigation handling
        onSliderItemClickListener.onSliderItemClick(position, view)
        return view
    }


    override fun isViewFromObject(view: View, any: Any): Boolean {
        return view == any
    }

    override fun getCount(): Int {
        return layouts.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view: View = `object` as View
        container.removeView(view)
    }

    fun setOnSliderItemClickListener(onSliderItemClickListener: OnSliderItemClickListener) {
        this.onSliderItemClickListener = onSliderItemClickListener
    }
}