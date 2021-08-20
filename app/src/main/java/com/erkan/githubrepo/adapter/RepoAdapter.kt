package com.erkan.githubrepo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.Repo
import com.erkan.githubrepo.databinding.ItemRepoBinding

/**
 * Created by umiterkan on 1/3/2021
 */

class RepoAdapter(val listener: RepoListener) :
    ListAdapter<Repo, RecyclerView.ViewHolder>(Companion) {

    class RepoViewHolder(val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root)

    companion object : DiffUtil.ItemCallback<Repo>() {
        override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean =
            oldItem === newItem
        override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean =
            oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(layoutInflater)
        return RepoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, index: Int) {
        val currentRepo = getItem(index)
        val repoHolder = holder as RepoViewHolder
        repoHolder.binding.apply {
            data = currentRepo
            position=index
            myListener = listener
        }
        repoHolder.binding.executePendingBindings()
    }

    interface RepoListener {
        fun onRepoItemClick(repo: Repo)
        fun onRepoAddFavorite(repo: Repo,position: Int)
    }


}