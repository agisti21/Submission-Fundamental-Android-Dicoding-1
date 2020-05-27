package com.agisti.submissionfundamental1

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataAvatar: TypedArray
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

        supportActionBar!!.title = "Home"

        val listView: ListView = findViewById(R.id.list_item)
        adapter = UserAdapter(this) //this = context activity
        listView.adapter = adapter

        prepare() //inisialisasi setiap data dan memanggil aray d berkas string
        addItem() //memasukkan data ke arraylist biar bisa di proses adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            val intent = Intent(this@HomeActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_USER, users[position])

            this@HomeActivity.startActivity(intent)
            Toast.makeText(this@HomeActivity, users[position].name, Toast.LENGTH_SHORT).show()
        }
    }
    private fun prepare(){
        dataAvatar = resources.obtainTypedArray(R.array.data_avatar)
        dataName = resources.getStringArray(R.array.data_nama)
        dataUsername = resources.getStringArray(R.array.data_username)
        dataCompany = resources.getStringArray(R.array.data_company)
        dataLocation = resources.getStringArray(R.array.data_location)
        dataFollower = resources.getStringArray(R.array.data_follower)
        dataFollowing = resources.getStringArray(R.array.data_following)
        dataRepository = resources.getStringArray(R.array.data_repository)

    }
    private fun addItem() {
        for (position in dataName.indices) {
            val hero = User(
                dataAvatar.getResourceId(position, -1),
                dataName[position],
                dataUsername[position],
                dataCompany[position],
                dataLocation[position],
                dataFollower[position],
                dataFollowing[position],
                dataRepository[position]
            )
            users.add(hero)
        }
        adapter.users = users//untuk set data berulang kali
    }
}
