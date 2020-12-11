package com.example.spaceflightnews.ui.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spaceflightnews.R
import com.example.spaceflightnews.data.Blog
import com.example.spaceflightnews.data.MainRepository
import com.example.spaceflightnews.ui.APP_ACTIVITY
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

    companion object {
        fun click(blog: Blog) {
            val bundle = Bundle()
            bundle.putSerializable("blog", blog)
            APP_ACTIVITY.navController.navigate(R.id.action_blogMainFragment_to_blogAllFragment, bundle)
        }
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