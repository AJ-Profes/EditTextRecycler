package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecylerview : RecyclerView
    private lateinit var newArrayList : ArrayList<Items>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        newRecylerview =findViewById(R.id.rv)
        newRecylerview.layoutManager = LinearLayoutManager(this)
        newRecylerview.setHasFixedSize(true)


        newArrayList = arrayListOf<Items>()
        getUserdata()
    }

    private fun getUserdata() {

        for(i in 1..100){

            val news = Items("Option " + i)
            newArrayList.add(news)

        }

        newRecylerview.adapter = MyAdapter(newArrayList)

        // This can solve the issue but it obsolete the whole pusrpose of using Recycler View
        //newRecylerview.setItemViewCacheSize(newArrayList.size);
    }
}