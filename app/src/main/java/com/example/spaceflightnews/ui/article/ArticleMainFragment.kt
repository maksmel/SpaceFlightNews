package com.example.spaceflightnews.ui.article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spaceflightnews.R
import com.example.spaceflightnews.data.Article
import com.example.spaceflightnews.data.MainRepository
import com.example.spaceflightnews.ui.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_article.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleMainFragment : Fragment(), CoroutineScope {

    override val coroutineContext = Dispatchers.Main
    private val repository = MainRepository()
    private val adapter = ArticlesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    companion object {
        fun click(article: Article) {
            val bundle = Bundle()
            bundle.putSerializable("article", article)
            APP_ACTIVITY.navController.navigate(R.id.action_feedFragment_to_articleAllFragment, bundle)
        }
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