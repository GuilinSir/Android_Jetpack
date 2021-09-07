package com.guilin.aj

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.logging.Logger

/**
 *
 * [XXX]
 *
 * @author Guilin
 * @CreateTime 2021/9/7
 */
class MyObserver : LifecycleObserver {
    val TAG = "MyObserver"

    //观察者的方法可以接受一个参数LifecycleOwner，就可以用来获取当前状态、或者继续添加观察者。
    //若注解的是ON_ANY还可以接收Event，用于区分是哪个事件。
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun Any(owner: LifecycleOwner, event: Lifecycle.Event) {
        Log.d(
            TAG,
            " LifecycleObserver.onAny : owner =" + owner.javaClass.name + ",event.name = " + event.name
        )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(owner: LifecycleOwner) {
        Log.d(TAG, "LifecycleObserver.onCreate:owner=${owner.javaClass.name}")
        GlobalScope.launch {
            delay(5000)
            //回调后检查当前生命周期状态
            if (owner.lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED)) {
                Log.d(TAG, "LifecycleObserver.onCreate:协程线程id=${Thread.currentThread().id}")
            }
        }
    }

}