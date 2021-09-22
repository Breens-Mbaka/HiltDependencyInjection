package com.example.hiltdependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //field injection
    @Inject
    lateinit var someClass: SomeClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(someClass.doAThing())
        println(someClass.doSomeOtherThing())
    }
}

class SomeClass
@Inject
constructor(
    private val anotherClass: AnotherClass
) {
    fun doAThing(): String {
        return "Hello world"
    }

    fun doSomeOtherThing(): String {
        return anotherClass.anotherThing()
    }
}

class  AnotherClass
@Inject
constructor() {
    fun anotherThing(): String {
        return "I did something!"
    }
}
