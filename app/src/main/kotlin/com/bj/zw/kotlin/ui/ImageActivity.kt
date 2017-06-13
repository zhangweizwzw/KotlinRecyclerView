package com.bj.zw.kotlin.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.bj.zw.kotlinrecyclerview.R
import kotlinx.android.synthetic.main.activity_image.*
import util.showimg

class ImageActivity : AppCompatActivity() {
    var url:String=null!!
    var mlist:ArrayList<SubjectsBean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        initView()
    }

     fun initView() {
         url = intent.getStringExtra("url")
         mlist = MyApplication.alist//获取list

         showimg(sdv_iv,url,1.0f)
     }
}
