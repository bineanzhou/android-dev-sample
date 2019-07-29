package com.nsky.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * Created by zhoubin on 2019/7/29.
 **/
class BActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        this.findViewById<View>(R.id.btn_start_activityc).setOnClickListener {
            var intent = Intent(this@BActivity, CActivity::class.java)
            startActivity(intent)
        }
    }
}