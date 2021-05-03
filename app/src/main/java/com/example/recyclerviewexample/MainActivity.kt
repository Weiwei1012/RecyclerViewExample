package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // data source
    private val ballList = ArrayList<Balls>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup our initial data
        initBallList()

        //configure the recyclerView
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = BallAdapter(ballList) //pass by reference 
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))  //add a divider line
    }

    private fun initBallList(){
        ballList.add(Balls("Baseball",R.drawable.baseball))
        ballList.add(Balls("Basketball",R.drawable.basketball))
        ballList.add(Balls("Football",R.drawable.football))
        ballList.add(Balls("Other",R.drawable.other))
    }
}