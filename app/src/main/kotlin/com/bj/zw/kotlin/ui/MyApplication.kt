package com.bj.zw.kotlin.ui

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by admin on 2017/6/9.
 */
class MyApplication :Application(){


    override fun onCreate() {
        super.onCreate()

      Fresco.initialize(this)
    }
}