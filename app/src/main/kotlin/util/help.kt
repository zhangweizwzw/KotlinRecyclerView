package util

import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView

/**
 * 帮助类
 * Created by admin on 2017/6/12.
 */

/**
 * 吐司
 */
fun Context.toast(message:String, length : Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,length).show()
}

/**
 * fresco显示图片
 */
fun showimg(imageview:SimpleDraweeView,url:String,fatio:Float){
    val uri = Uri.parse(url)
    val controller = Fresco.newDraweeControllerBuilder()
            .setUri(uri)
            .setAutoPlayAnimations(true)
            .build()
    imageview.controller = controller
    imageview.aspectRatio=fatio
}