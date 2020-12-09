package com.example.spaceflightnews.ui.article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spaceflightnews.R
import com.example.spaceflightnews.data.Article
import com.example.spaceflightnews.data.MainRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_article.*
import kotlinx.android.synthetic.main.fragment_article_all.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ArticleAllFragment : Fragment(), CoroutineScope {

    override val coroutineContext = Dispatchers.Main
    private val repository = MainRepository()
    private val adapter = ArticlesAdapter()
    private lateinit var mCurrentArticle: Article

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mCurrentArticle = arguments?.getSerializable("article") as Article
        return inflater.inflate(R.layout.fragment_article_all, container, false)
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        article_title.text = mCurrentArticle.title
        article_site.text = mCurrentArticle.newsSite
        article_body.text = mCurrentArticle.summary
        article_date.text = mCurrentArticle.dateTime.toString()
        Picasso.get().load(mCurrentArticle.imageUrl).into(article_image)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        articlesList?.adapter = adapter

        launch {
            repository.getArticles()?.let {
                adapter.updateArticles(it)
            }
        }
    }
}