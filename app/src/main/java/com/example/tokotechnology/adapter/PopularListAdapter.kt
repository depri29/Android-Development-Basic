package com.example.tokotechnology.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tokotechnology.R
import com.example.tokotechnology.activity.DetailActivity
import com.example.tokotechnology.model.Popular

class PopularListAdapter(val data:ArrayList<Popular>) :RecyclerView.Adapter<PopularListAdapter.PopularListViewHolder>(){
    class PopularListViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        val scoreText:TextView = view.findViewById(R.id.scoreText)
        val titleText:TextView = view.findViewById(R.id.titleText)
        val ivPicProd:ImageView = view.findViewById(R.id.ivpicProd)
        val priceText:TextView = view.findViewById(R.id.priceText)
        val commentText:TextView = view.findViewById(R.id.commentText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_pop_list,parent,false)

        return PopularListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularListViewHolder, position: Int) {
        val item = data.get(position)
        holder.titleText.text = item.title
        holder.scoreText.text = item.score.toString()
        holder.commentText.text = item.review.toString()
        Glide.with(holder.itemView.context)
            .load(item.picUrl)
            .into(holder.ivPicProd)
        holder.priceText.text = item.price.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra("object",item)
        }

    }

    override fun getItemCount(): Int = data.size
}

