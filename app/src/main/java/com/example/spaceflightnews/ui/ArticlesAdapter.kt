package com.example.spaceflightnews.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceflightnews.R
import com.example.spaceflightnews.data.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_post.view.*

class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    private var articles = emptyList<Article>()

    fun updateArticles(articles: List<Article>) {
        this.articles = articles
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
        Picasso.get().load(articles[position].imageUrl).into(holder.itemView.articleImage)
    }

    override fun getItemCount() = articles.size

    class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(article: Article) = itemView.apply {
            articleTitle.text = article.title
            articleSite.text = article.newsSite
            articleBody.text = article.summary
            articleDate.text = article.dateTime.toString()

        }
    }

}