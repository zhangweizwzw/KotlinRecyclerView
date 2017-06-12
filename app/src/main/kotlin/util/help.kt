package util

import android.content.Context
import android.widget.Toast

/**
 * Created by admin on 2017/6/12.
 */
fun Context.toast(message:String, length : Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,length).show()
}