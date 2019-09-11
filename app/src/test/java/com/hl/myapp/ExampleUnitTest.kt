package com.hl.myapp

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testCoroutine() {

        GlobalScope.launch {

            //未执行
            println("current thread is ${Thread.currentThread()}")

        }
        println("current thread is ${Thread.currentThread()}")
    }


}
