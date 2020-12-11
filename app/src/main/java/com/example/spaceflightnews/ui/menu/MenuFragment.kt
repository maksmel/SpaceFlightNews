package com.example.spaceflightnews.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spaceflightnews.R
import com.example.spaceflightnews.ui.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_article.*
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onStart() {
        super.onStart()
        btnArticle.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_menuFragment_to_articleMainFragment)
        }

        btnBlog.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_menuFragment_to_blogMainFragment)
        }
    }
}