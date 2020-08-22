package com.huanchengfly.tieba.post

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.ColorRes
import com.google.gson.Gson
import com.huanchengfly.tieba.post.utils.MD5Util

fun Float.dpToPx(): Int =
        (this * BaseApplication.ScreenInfo.DENSITY + 0.5f).toInt()

fun Float.spToPx(): Int =
        (this * BaseApplication.instance.resources.displayMetrics.scaledDensity + 0.5f).toInt()

fun Float.pxToDp(): Int =
        (this / BaseApplication.ScreenInfo.DENSITY + 0.5f).toInt()

fun Float.pxToSp(): Int =
        (this / BaseApplication.instance.resources.displayMetrics.scaledDensity + 0.5f).toInt()

fun Int.dpToPx(): Int = this.toFloat().dpToPx()

fun Int.spToPx(): Int = this.toFloat().spToPx()

fun Int.pxToDp(): Int = this.toFloat().pxToDp()

fun Int.pxToSp(): Int = this.toFloat().pxToSp()

fun Any.toJson(): String = Gson().toJson(this)

fun String.toMD5(): String = MD5Util.toMd5(this)

fun Context.getColorCompat(@ColorRes id: Int): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        resources.getColor(id, theme)
    } else {
        resources.getColor(id)
    }
}

inline fun <reified T : Activity> Activity.goToActivity() {
    startActivity(Intent(this, T::class.java))
}

fun Context.toastShort(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Context.toastShort(resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
}

inline fun <reified T : Activity> Activity.goToActivity(pre: (Intent) -> Intent) {
    startActivity(pre(Intent(this, T::class.java)))
}
