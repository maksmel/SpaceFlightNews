package com.example.spaceflightnews.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spaceflightnews.R
import com.example.spaceflightnews.data.MainRepository
import kotlinx.android.synthetic.main.fragment_blog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class BlogFragment : Fragment(), CoroutineScope {

    override val coroutineContext = Dispatchers.Main
    private val repository = MainRepository()
    private val adapter = BlogAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        blogList.adapter = adapter


        launch {
            repository.getBlogs()?.let {
                adapter.updateBlog(it)
            }
        }
    }

}