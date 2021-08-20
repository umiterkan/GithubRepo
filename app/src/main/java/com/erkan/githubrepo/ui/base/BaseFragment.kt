package com.erkan.githubrepo.ui.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.erkan.githubrepo.BR


/**
 * Created by umiterkan on 1/2/2021
 */
abstract class BaseFragment<T : ViewDataBinding, VM : ViewModel> : Fragment() {

    abstract fun initUI()
    abstract fun observe()
    abstract fun fetch()

    abstract val layoutId: Int

    lateinit var binding: T

    abstract val viewModel: VM


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container!!, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observe()
        fetch()
    }


    open fun hideKeyboard(view: View?) {
        activity?.let { activity ->
            view?.let { view ->
                val imm =
                    activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}