package com.example.stargroupexercise.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.annotation.RequiresPermission
import androidx.fragment.app.Fragment
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

@Suppress("DEPRECATION")
@RequiresPermission(value = Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.isConnected(): Boolean {
    val connectivityManager = this
        .getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    connectivityManager?.let { it ->
        val netInfo = it.activeNetworkInfo
        netInfo?.let {
            if (it.isConnected) return true
        }
    }
    return false
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Button.onClicked() = callbackFlow<Unit> {
    setOnClickListener { offer(Unit) }
    awaitClose { setOnClickListener(null) }
}

fun View.debounceClick(debounceTime: Long = 1000L, action: () -> Unit) {
    setOnClickListener {
        when {
            tag != null && (tag as Long) > System.currentTimeMillis() -> return@setOnClickListener
            else -> {
                tag = System.currentTimeMillis() + debounceTime
                action()
            }
        }
    }
}