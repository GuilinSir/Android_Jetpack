package com.guilin.aj

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

/**
 *
 * [XXX]
 *
 * @author Guilin
 * @CreateTime 2021/9/7
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserver())
    }
}