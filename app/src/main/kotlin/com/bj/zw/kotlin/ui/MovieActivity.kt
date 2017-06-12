package com.bj.zw.kotlin.ui

import `interface`.onclickListener
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bj.zw.kotlin.MovieAdapter
import com.bj.zw.kotlinrecyclerview.R
import com.google.gson.Gson
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.callback.StringCallback
import okhttp3.Call
import widget.PullLoadMoreRecyclerView
import kotlinx.android.synthetic.main.activity_movie.*
import util.toast

class MovieActivity : AppCompatActivity(), PullLoadMoreRecyclerView.PullLoadMoreListener, onclickListener {
    var TAG:String = "MovieActivity"
    internal var mRecyclerViewAdapter:MovieAdapter? =null
    var count:Int=10
    var mlist:ArrayList<SubjectsBean> =ArrayList<SubjectsBean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        initView()
        getMovie(0,count)
    }

    fun initView(){
//        mRecyclerView=pullLoadMoreRecyclerView.recyclerView
        pullLoadMoreRecyclerView.setLinearLayout()
        //是否下拉刷新
        pullLoadMoreRecyclerView.pullRefreshEnable=true
        //是否上拉加载更多
        pullLoadMoreRecyclerView.pushRefreshEnable=true
        pullLoadMoreRecyclerView.setFooterViewText("正在加载...")
        pullLoadMoreRecyclerView.setRefreshing(true)//进入页面是否显示加载
        pullLoadMoreRecyclerView.setLinearLayout()

        pullLoadMoreRecyclerView.setOnPullLoadMoreListener(this)
        mRecyclerViewAdapter= MovieAdapter(mlist,this@MovieActivity)
        pullLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter)
        mRecyclerViewAdapter!!.setOnItemClickListener(this@MovieActivity)
    }

    private fun getMovie(start:Int,count:Int) {
         OkHttpUtils
                .post()
                .url("http://api.douban.com/v2/movie/top250?")
                .addParams("start",start.toString())
                .addParams("count",count.toString())
                .build()
                .execute(object : StringCallback() {
                    override fun onError(call: Call, e: Exception) {
                        Log.i(TAG,e.message.toString())
                        pullLoadMoreRecyclerView.setPullLoadMoreCompleted()
                    }

                    override fun onResponse(response: String) {
                        Log.i(TAG,response)
                        val result=Gson().fromJson(response,MovieModel::class.java)

                        mlist.addAll(result.subjects)
                        mRecyclerViewAdapter!!.notifyDataSetChanged()
                        pullLoadMoreRecyclerView.setPullLoadMoreCompleted()
                    }
                })

    }

    override fun onItemClick(position: Int, view: View) {
        toast("选中="+position)
        startActivity(Intent(this,MovieDetailActivity::class.java))
    }


    override fun onLoadMore() {
        count+=10
        getMovie(count-10,count)
    }

    override fun onRefresh() {
        mlist.clear()
        count=10
        getMovie(0,count)
    }
}
