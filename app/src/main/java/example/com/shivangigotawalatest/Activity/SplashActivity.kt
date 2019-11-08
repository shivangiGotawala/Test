package example.com.shivangigotawalatest.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView

import java.util.Timer
import java.util.TimerTask

import example.com.shivangigotawalatest.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val tvName = findViewById<TextView>(R.id.tv_name)
        val animBlink = AnimationUtils.loadAnimation(applicationContext,
                R.anim.blink)
        tvName.visibility = View.VISIBLE
        tvName.startAnimation(animBlink)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        }, 5000)
    }
}
