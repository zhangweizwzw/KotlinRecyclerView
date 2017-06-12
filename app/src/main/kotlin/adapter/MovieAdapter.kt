package com.bj.zw.kotlin

import `interface`.onclickListener
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bj.zw.kotlin.ui.SubjectsBean
import com.bj.zw.kotlinrecyclerview.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*

/**
 * Created by Masx Developer on 5/20/17.
 * https://masx-dev.blogspot.com
 */

internal class MovieAdapter(val arrayList: ArrayList<SubjectsBean>, private val context: Context) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    var mItemClickListener: onclickListener? = null


    fun setOnItemClickListener(listener: onclickListener) {
        this.mItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder = ViewHolder(
            LayoutInflater.from(parent?.context).inflate(R.layout.recycler_view_item , parent , false)
    )

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(items: SubjectsBean) {
            itemView.title.text = items.title
            itemView.zhuyan.text="主演："+items.casts.get(0).name
            itemView.fresco.setImageURI(items.casts.get(0).avatars.large)

            itemView.rela_large.setOnClickListener(View.OnClickListener {
                if(mItemClickListener!=null){
                    mItemClickListener!!.onItemClick(adapterPosition,itemView.rela_large)
                }
            })
        }
    }



}