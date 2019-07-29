package com.nsky.sample

import android.os.Bundle
import android.os.Looper
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.nsky.sample.thread.WorkThread
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        this.findViewById<View>(R.id.btn_start_workthread).setOnClickListener {
            startWorkThread()
        }

        this.findViewById<View>(R.id.btn_quit_workthread).setOnClickListener {
            quitWorkThread()
        }
    }

    var workThread:WorkThread?=null

    private fun startWorkThread(){
        workThread = WorkThread()
        workThread?.start()
        Log.d(TAG, "WorkThread getMainLooper:" + Looper.getMainLooper() + " myLooper:" + Looper.myLooper())
        window.decorView.postDelayed(Runnable {
            workThread?.handler?.sendEmptyMessage(1001)
        }, 1000)

    }
    private fun quitWorkThread(){

        workThread?.quit()
        workThread=null
    }

}
