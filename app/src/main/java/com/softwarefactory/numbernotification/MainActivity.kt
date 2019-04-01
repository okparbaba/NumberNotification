package com.softwarefactory.numbernotification

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_layout.*

class MainActivity : AppCompatActivity() {
    private lateinit var mImageBtn: ImageButton
    private lateinit var mActivityTv: TextView
    private lateinit var mCountTv: TextView
    private lateinit var mCartIconMenuItem: MenuItem
    private  var mCount = 0
    private  var mContext: Context = this@MainActivity
    private lateinit var mMyTollbar: Toolbar
    private lateinit var mPlusBtn: Button
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMyTollbar = findViewById(R.id.myToolBar)
        setSupportActionBar(mMyTollbar)
        mMyTollbar.setTitleTextColor(-0x1)

        mPlusBtn = findViewById(R.id.plus_btn)
        mActivityTv = findViewById(R.id.activity_tv)

        mPlusBtn.setOnClickListener {
            count_tv_layout.visibility = View.VISIBLE
            doIncrement()
        }

        minus_btn.setOnClickListener { doDecrement() }
    }

    private fun doDecrement() {

            mActivityTv.text = mCount.toString()
            mCountTv.text = mCount.toString()
        if (mCount>0){
            mCount--
        }
        if (mCount<=0){
            count_tv_layout.visibility = View.GONE
        }
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