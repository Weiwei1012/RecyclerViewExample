package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class BallAdapter(val ballList: List<Balls>): RecyclerView.Adapter<BallAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ballImage: ImageView = view.findViewById(R.id.imageView)
        val ballName: TextView = view.findViewById(R.id.textView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_layout, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {  //onClick 
            Toast.makeText(parent.context, ballList[viewHolder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }
    //populate data items on the view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ball = ballList[position]  //position at the data set 
        holder.ballImage.setImageResource(ball.imageId)
        holder.ballName.text = ball.name
    }
    //get the number of total items
    override fun getItemCount(): Int {
        return ballList.size
    }
}