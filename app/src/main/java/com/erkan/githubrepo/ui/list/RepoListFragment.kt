package com.erkan.githubrepo.ui.list

import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.erkan.githubrepo.R
import com.erkan.githubrepo.adapter.RepoAdapter
import com.example.data.model.Repo
import com.erkan.githubrepo.databinding.FragmentRepoListBinding
import com.erkan.githubrepo.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RepoListFragment : BaseFragment<FragmentRepoListBinding, RepoListViewModel>(),
    RepoAdapter.RepoListener {

    override val layoutId: Int get() = R.layout.fragment_repo_list
    override val viewModel by viewModels<RepoListViewModel>()


    private lateinit var adapter: RepoAdapter

    override fun initUI() {
        adapter = RepoAdapter(this)
        binding.repoAdapter = adapter
        binding.btnSearch.setOnClickListener {
            hideKeyboard(binding.etSearch)
            viewModel.getRepoList(binding.etSearch.text.toString())
        }
        binding.etSearch.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboard(binding.etSearch)
                viewModel.getRepoList(binding.etSearch.text.toString())
                return@OnEditorActionListener true
            }
            false
        })
    }

    override fun observe() {}

    override fun fetch() {}

    override fun onRepoItemClick(repo: Repo) {
        findNavController().navigate(
            RepoListFragmentDirections.actionRepoListFragmentToRepoDetailFragment(
                repo,
                repo.name ?: getString(R.string.repo_detail_title)
            )
        )
    }

    override fun onRepoAddFavorite(repo: Repo, position: Int) {
        viewModel.processFavorite(repo)
        repo.is_favorite = !repo.is_favorite
        adapter.notifyItemChanged(position)
    }
}


