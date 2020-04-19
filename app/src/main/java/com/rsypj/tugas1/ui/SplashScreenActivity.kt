package com.rsypj.tugas1.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rsypj.tugas1.R
import java.lang.Exception

/**
 * Created by dhadotid on 19:53 | 2020-04-19.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class SplashScreenActivity: AppCompatActivity() {

    companion object {
        const val SPLASH_SCREEN_DURATION: Long = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        initCount()
    }

    private fun initCount(){
        val thread = Thread(Runnable {
            try {
                Thread.sleep(SPLASH_SCREEN_DURATION)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                finish()
            }
        })
        thread.start()
    }
}