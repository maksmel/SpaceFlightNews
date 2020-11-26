package com.example.spaceflightnews.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spaceflightnews.R
import com.example.spaceflightnews.data.MainRepository
import kotlinx.android.synthetic.main.fragment_feed.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedFragment : Fragment(), CoroutineScope {

    override val coroutineContext = Dispatchers.Main
    private val repository = MainRepository()
    private val adapter = ArticlesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        articlesList.adapter = adapter

        launch {
            repository.getArticles()?.let {
                adapter.updateArticles(it)
            }
        }
    }
}