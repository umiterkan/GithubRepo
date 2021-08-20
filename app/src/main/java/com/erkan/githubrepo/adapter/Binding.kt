package com.erkan.githubrepo.adapter

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.erkan.githubrepo.R
import com.example.data.model.Repo
import com.squareup.picasso.Picasso

/**
 * Created by umiterkan on 1/3/2021
 */


class Binding {

    companion object {
        @BindingAdapter("setAdapter")
        @JvmStatic
        fun bindRecyclerViewAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
            view.adapter = adapter
        }

        @BindingAdapter("submitList")
        @JvmStatic
        fun submitList(view: RecyclerView, list: List<Repo>?) {
            val adapter = view.adapter as RepoAdapter
            adapter.submitList(list)
            if (list.isNullOrEmpty()) view.visibility = View.GONE else view.visibility =
                View.VISIBLE
        }


        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(view: ImageView, url: String?) {
            url?.let {
                Picasso.get().load(it).placeholder(android.R.drawable.ic_popup_sync).into(view)
            }
        }

        @BindingAdapter("loadStarIcon")
        @JvmStatic
        fun loadStarIcon(view: ImageView, repo: Repo?) {
            repo?.let {
                view.setImageDrawable(
                    if (repo.is_favorite) ContextCompat.getDrawable(
                        view.context,
                        R.drawable.ic_star_active
                    ) else ContextCompat.getDrawable(view.context, R.drawable.ic_star_passive)
                )
            }
        }
    }
}