package com.erkan.githubrepo.ui.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.erkan.githubrepo.R
import com.erkan.githubrepo.databinding.FragmentRepoDetailBinding
import com.erkan.githubrepo.ui.base.BaseFragment

/**
 * Created by umiterkan on 1/3/2021
 */

class RepoDetailFragment : BaseFragment<FragmentRepoDetailBinding, RepoDetailViewModel>() {

    override val viewModel by viewModels<RepoDetailViewModel>()
    private val args: RepoDetailFragmentArgs by navArgs()
    override val layoutId: Int get() = R.layout.fragment_repo_detail


    override fun initUI() {
        binding.data=args.repo
    }

    override fun observe() {
    }

    override fun fetch() {
    }




}