package com.cogitator.kotlincoroutines

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_out.text = text_out.text.toString() + "\nLaunch coroutine example"
        var str = ""
        str += "\nLaunch coroutine example"
        print(str)

        launch {
            // launch new coroutine in background and continue
            delay(10000L) // non-blocking delay for 1 second (default time unit is ms)
            text_out.text = text_out.text.toString() + "\nWorld!" // print after delay
            str += "\nWorld!"
            print(str)
        }
        text_out.text = text_out.text.toString() + "\nHello," // main thread continues while coroutine is delayed
        Thread.sleep(20000L) // block main thread for 2 seconds to keep JVM alive
        str += "\nHello,"
        print(str)
    }
}
