package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_bottom_nav_view_pager.*
import kotlinx.android.synthetic.main.activity_bottom_nav_view_pager.viewPager
import kotlinx.android.synthetic.main.activity_tab_nav_view_pager.*

class TabNavViewPagerActivity : AppCompatActivity() {

    var viewList = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_nav_view_pager)
        viewList.add(layoutInflater.inflate(R.layout.fragment_home, null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_favorite, null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_profile, null))

        viewPager.adapter = pagerAdapter()

        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)?.setText("Home")
        tabLayout.getTabAt(1)?.setText("Favorite")
        tabLayout.getTabAt(2)?.setText("Profile")
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_baseline_home_24)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_baseline_favorite_border_24)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_baseline_person_pin_24)

    }

    inner class pagerAdapter : PagerAdapter() {
        override fun isViewFromObject(view: View, `object`: Any) = view == `object`

        override fun getCount() = viewList.size

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var curView = viewList[position]
            viewPager.addView(curView)
            return curView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            viewPager.removeView(`object` as View)
        }

    }

}