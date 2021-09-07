package com.guilin.aj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LifecycleDemoActivity : AppCompatActivity() {
    val TAG = "LifecycleDemoActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_demo)
        lifecycle.addObserver(MyObserver())
        Log.d(TAG, "onCreate:主线程id=${mainLooper.thread.id}")
        GlobalScope.launch {
            val result1 = GlobalScope.async {
                delay(1000)
                1
            }
            val result2 = GlobalScope.async {
                delay(4000)
                4
            }

            val result = result1.await() + result2.await()

            Log.d(TAG, "onCreate:协程线程id=${Thread.currentThread().id},result = $result")


        }
    }
}