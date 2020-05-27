package com.agisti.submissionfundamental1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
        val loading = 2000

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            if (supportActionBar != null) {
                supportActionBar!!.title = " "
            }
            Handler().postDelayed({
                val home = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(home)
                finish()
            }, loading.toLong())
        }
    }

