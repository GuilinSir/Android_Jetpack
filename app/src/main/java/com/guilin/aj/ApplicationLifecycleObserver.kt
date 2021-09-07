package com.guilin.aj

import android.annotation.SuppressLint
import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 *
 * [XXX]
 *
 * @author Guilin
 * @CreateTime 2021/9/7
 */
class ApplicationLifecycleObserver:LifecycleObserver {
    val TAG = "ApplicationLifecycleObserver";

   // onActivityStarted()时 +1，onActivityStopped时 -1，以此判断前后台切换。

    @SuppressLint("LongLogTag")
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppFroeground(owner:LifecycleOwner){
        Log.e(TAG,"${owner.javaClass.simpleName}:app moved to foreground")

    }

    @SuppressLint("LongLogTag")
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackground(owner:LifecycleOwner){
        Log.e(TAG,"${owner.javaClass.simpleName}:app moved to background")

    }
}