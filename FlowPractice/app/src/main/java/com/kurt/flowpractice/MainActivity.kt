package com.kurt.flowpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    //var count=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flow= flow<Int> {
            for(i in 1..100000000)
            {
                emit(i)
                delay(1000L)
               // count++

            }
        }
        GlobalScope.launch {
            flow.buffer().filter {
                it %2 ==0

            }.map {
                it*it
            }
                .collect {
                println(it)
               // println(count)
            }
        }
    }

}