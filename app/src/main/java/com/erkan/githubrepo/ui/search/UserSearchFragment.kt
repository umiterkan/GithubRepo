package com.erkan.githubrepo.ui.search

import androidx.fragment.app.viewModels
import com.erkan.githubrepo.R
import com.erkan.githubrepo.databinding.FragmentUserSearchBinding
import com.erkan.githubrepo.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UserSearchFragment : BaseFragment<FragmentUserSearchBinding, UserSearchViewModel>() {


    override val layoutId: Int get() = R.layout.fragment_user_search
    override val viewModel by viewModels<UserSearchViewModel>()

    override fun initUI() {

    }

    override fun observe() {
    }

    override fun fetch() {
    }


}