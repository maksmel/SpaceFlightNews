package com.example.spaceflightnews.ui.blog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spaceflightnews.R
import com.example.spaceflightnews.data.Blog
import com.example.spaceflightnews.data.MainRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_article_all.*
import kotlinx.android.synthetic.main.fragment_blog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class BlogAllFragment : Fragment(), CoroutineScope {

    override val coroutineContext = Dispatchers.Main
    private val repository = MainRepository()
    private val adapter = BlogAdapter()
    private lateinit var mCurrentBlog: Blog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mCurrentBlog = arguments?.getSerializable("blog") as Blog
        return inflater.inflate(R.layout.fragment_blog_all, container, false)
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        article_title.text = mCurrentBlog.title
        article_site.text = mCurrentBlog.newsSite
        article_body.text = mCurrentBlog.summary
        article_date.text = mCurrentBlog.dateTime.toString()
        Picasso.get().load(mCurrentBlog.imageUrl).into(article_image)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        blogList?.adapter = adapter

        launch {
            repository.getBlogs()?.let {
                adapter.updateBlog(it)
            }
        }
    }
}