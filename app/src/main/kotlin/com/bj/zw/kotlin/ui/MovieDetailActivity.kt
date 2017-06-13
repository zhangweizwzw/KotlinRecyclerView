package com.bj.zw.kotlin.ui

import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_movie_detail.*
import com.bj.zw.kotlinrecyclerview.R
import com.facebook.drawee.view.SimpleDraweeView
import util.showimg


class MovieDetailActivity : AppCompatActivity(){
    var mlist:ArrayList<SubjectsBean>? = null
    var position:Int? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)


        initView()

    }
    fun initView(){
        position=intent.getIntExtra("position",0)

        mlist=MyApplication.alist//获取list

        println(mlist!![position!!].casts[0].avatars.large)

        //循环加入控件
        for (cast in mlist!![position!!].casts) {
            println(cast.name+"---->"+cast.avatars.medium)

            val tv:TextView= TextView(this)
            tv.text=cast.name
            lin1.addView(tv)
            val sdv:SimpleDraweeView= SimpleDraweeView(this)
            showimg(sdv,cast.avatars.medium,1.0f)//设置图片
            lin1.addView(sdv)
        }
    }

}
