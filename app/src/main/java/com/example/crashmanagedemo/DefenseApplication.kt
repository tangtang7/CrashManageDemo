package com.example.crashmanagedemo

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import com.android.tony.defenselib.DefenseCrash
import com.android.tony.defenselib.handler.IExceptionHandler

class DefenseApplication : Application(), IExceptionHandler {
//    override fun onCreate() {
//        super.onCreate()
//        CrashHandler.getInstance().initHandler { t, e ->
//            Log.e("CrashHandler  ", "偶吼吼，抓到错误信息了" + t.name + e.toString())
//        }
//    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.e("whh","attachBaseContext")

        //初始化库
        DefenseCrash.initialize(this)
        DefenseCrash.install(this)
    }

    /**
     *  thread: 异常崩溃在的线程对象。
     *  throwable: 具体的异常对象。
     *  isSafeMode: 如果应用程序崩溃过,但是被捕获,那么这个值将会是true。即当主线程(Main Looper)已经被错误破坏不能够正常loop的时候,进入安全模式。
     *  isCrashInChoreographer: 如果崩溃发生在 OnMeasure/OnLayout/OnDraw 方法中,这将会导致程序白屏或黑屏亦或是一些 View 显示不成功。
     *                          当此值为 true 的时候,建议关闭或者重启当前的Activity。
     */
    override fun onCaughtException(
        thread: Thread?,
        throwable: Throwable?,
        isSafeMode: Boolean,
        isCrashInChoreographer: Boolean) {
        // 可以在本方法中抛出异常,抛出的异常将会被虚拟机(VM)捕获并且进程将被它关闭
        Log.e("whh", "Exceptionhandler - thread:${thread?.name} " +
                "exception:${throwable?.message} " +
                "isCrashInChoreographer:$isCrashInChoreographer " +
                "isSafeMode:$isSafeMode");
        throwable?.printStackTrace()

        if (isCrashInChoreographer) {
//            val intent = Intent(applicationContext, MainActivity::class.java)
//            startActivity(intent)
        }

        //上报异常到统计平台
//        FirebaseCrashlytics.getInstance().recordException(throwable);
    }

    override fun onTerminate() {
        super.onTerminate()
        DefenseCrash.unInstall()
    }
}