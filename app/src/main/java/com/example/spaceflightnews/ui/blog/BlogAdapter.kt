package com.example.spaceflightnews.ui.blog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceflightnews.R
import com.example.spaceflightnews.data.Blog
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_post.view.*

class BlogAdapter : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    private var blog = emptyList<Blog>()

    fun updateBlog(blog: List<Blog>) {
        this.blog = blog
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: BlogViewHolder) {
        holder.itemView.setOnClickListener {
            BlogFragment.click(blog[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: BlogViewHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return BlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bind(blog[position])
    }

    override fun getItemCount() = blog.size

    class BlogViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(blog: Blog) = itemView.apply {
            articleTitle.text = blog.title
//            articleSite.text = blog.newsSite
//            articleBody.text = blog.summary
            articleDate.text = blog.dateTime.toString()
            Picasso.get().load(blog.imageUrl).into(articleImage)

        }
    }

}