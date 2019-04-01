package com.softwarefactory.numbernotification

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    internal var mImageBtn: ImageButton
    internal var mActivityTv: TextView
    internal var mCountTv: TextView
    internal var mCartIconMenuItem: MenuItem
    internal var mCount = 0
    internal var mContext: Context = this@MainActivity
    internal var mMyTollbar: Toolbar
    internal var mPlusBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMyTollbar = findViewById(R.id.myToolBar)
        setSupportActionBar(mMyTollbar)
        mMyTollbar.setTitleTextColor(-0x1)

        mPlusBtn = findViewById(R.id.plus_btn)
        mActivityTv = findViewById(R.id.activity_tv)

        mPlusBtn.setOnClickListener { doIncrement() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        mCartIconMenuItem = menu.findItem(R.id.cart_count_menu_item)

        val actionView = mCartIconMenuItem.actionView

        if (actionView != null) {
            mCountTv = actionView.findViewById(R.id.count_tv_layout)
            mImageBtn = actionView.findViewById(R.id.image_btn_layout)
        }

        mImageBtn.setOnClickListener { Toast.makeText(mContext, "Image Button is Clicked!", Toast.LENGTH_LONG).show() }

        return super.onCreateOptionsMenu(menu)
    }

    private fun doIncrement() {
        mCount++
        mCountTv.text = mCount.toString()
        mActivityTv.text = mCount.toString()
    }
}