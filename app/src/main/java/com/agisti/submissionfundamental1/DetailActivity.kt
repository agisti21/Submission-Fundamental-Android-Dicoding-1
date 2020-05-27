package com.agisti.submissionfundamental1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_USER = "extra_user"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.title = "Detail"

      val user : User? = intent.getParcelableExtra(EXTRA_USER)

        if (user != null) {
            txt_name.text = user.name
            txt_username.text = user.username
            txt_company.text = user.company
            txt_location.text = user.location
            txt_follower.text = user.follower
            txt_following.text = user.following
            txt_repository.text = user.repository
            img_photo.setImageResource(user.avatar)
        }

    }
}
