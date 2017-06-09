package com.bj.zw.kotlin.ui

/**
 * Created by admin on 2017/6/8.
 */
//private var count: Int = 0
//private var start: Int = 0
//private var total: Int = 0
//private var title: String? = null

//private var rating: com.bj.zw.kotlin.ui.RatingBean? = null
//private var title: String? = null
//private var collect_count: Int = 0
//private var original_title: String? = null
//private var subtype: String? = null
//private var year: String? = null
//private var images: com.bj.zw.kotlin.ui.ImagesBean? = null
//private var alt: String? = null
//private var id: String? = null
//private var genres: List<String>? = null
//private var casts: List<com.bj.zw.kotlin.ui.CastsBean>? = null
//private var directors: List<com.bj.zw.kotlin.ui.DirectorsBean>? = null

data class MovieModel(val count: Int,val start: Int,val total: Int,val title: String,val subjects:ArrayList<com.bj.zw.kotlin.ui.SubjectsBean> )

data class SubjectsBean(val rating: com.bj.zw.kotlin.ui.RatingBean, val title: String, val collect_count: Int, val original_title: String, val subtype: String, val year: String, val images: com.bj.zw.kotlin.ui.ImagesBean, val alt: String, val id: String, val genres: List<String>, var casts: List<com.bj.zw.kotlin.ui.CastsBean>, val directors: List<com.bj.zw.kotlin.ui.DirectorsBean>)

data class RatingBean(val max:Int,val average: Double,val stars: String,val min: Int)

data class ImagesBean(val small: String,val large: String,val medium: String)

data class CastsBean(val alt: String, val avatars: com.bj.zw.kotlin.ui.AvatarsBean, val name: String, val id: String)

data class AvatarsBean(val small: String,val large: String,val medium: String)

data class DirectorsBean(var alt: String, val avatars: com.bj.zw.kotlin.ui.AvatarsBeanX, val name: String, val id: String)

data class AvatarsBeanX(val small: String,val large: String,val medium: String)

//private var small: String? = null
//private var large: String? = null
//private var medium: String? = null


//private var alt: String? = null
//private var avatars: com.bj.zw.kotlin.ui.AvatarsBeanX? = null
//private var name: String? = null
//private var id: String? = null

//private var small: String? = null
//private var large: String? = null
//private var medium: String? = null
//
//private var alt: String? = null
//private var avatars: com.bj.zw.kotlin.ui.AvatarsBean? = null
//private var name: String? = null
//private var id: String? = null

//var small: String? = null
//private var large: String? = null
//private var medium: String? = null

//var max: Int = 0
//private var average: Double = 0.toDouble()
//private var stars: String? = null
//private var min: Int = 0