package com.example.spaceflightnews.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceflightnews.R
import com.example.spaceflightnews.data.Blog
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_blog.view.*

class BlogAdapter : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    private var blog = emptyList<Blog>()

    fun updateBlog(blog: List<Blog>) {
        this.blog = blog
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_blog, parent, false)
        return BlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bind(blog[position])
        Picasso.get().load(blog[position].imageUrl).into(holder.itemView.blogImage)
    }

    override fun getItemCount() = blog.size

    class BlogViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(blog: Blog) = itemView.apply {
            blogTitle.text = blog.title
            blogSite.text = blog.newsSite
            blogBody.text = blog.summary
            blogDate.text = blog.dateTime.toString()

        }
    }

}