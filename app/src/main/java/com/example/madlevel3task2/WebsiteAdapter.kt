package com.example.madlevel3task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_website.view.*

class WebsiteAdapter(private val Websites: List<Website>, val clickListener: (Website) -> Unit) :
    RecyclerView.Adapter<WebsiteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_website, parent, false)
        )

    }


    override fun getItemCount(): Int {
        return Websites.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(Websites[position], clickListener)


    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(website: Website, clickListener: (Website) -> Unit) {
            itemView.tvTitle.text = website.TitleText
            itemView.tvURL.text = website.URLtext
            itemView.setOnClickListener { clickListener(website) }
        }
    }
}


