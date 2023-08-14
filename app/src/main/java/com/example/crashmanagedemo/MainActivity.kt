package com.example.crashmanagedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    var rootLayout : LinearLayout? = null
    var button1 : Button? = null
    var button2 : Button? = null
    var button3 : Button? = null
    var button4 : Button? = null
    var button5 : Button? = null
    var nullPointTest: String? = null
    var arrayList : ArrayList<Int>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootLayout = findViewById(R.id.root_layout)
        //Cockroach
        button1 = findViewById(R.id.button1)
        button1?.setOnClickListener {
            Log.e("whh","空指针异常测试" + nullPointTest!!.length)
        }

        button2 = findViewById(R.id.button2)
        button2?.setOnClickListener {
            arrayList = ArrayList<Int>();
            arrayList!!.add(1)
            arrayList!!.add(2)
            for(i in 0 until 3) {
                println(arrayList!!.get(i))
                Log.e("whh","数组下标越界异常测试")
            }
        }

        button3 = findViewById(R.id.button3)
        button3?.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
            val crashView = CrashView(applicationContext)
            rootLayout!!.addView(crashView)
            Log.e("whh","绘图异常测试")
        }


    }
}