package com.erkan.githubrepo.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.erkan.githubrepo.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * Created by umiterkan on 1/5/2021
 */

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding: B

    @get:LayoutRes
    abstract val layoutIdRes: Int

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<B>(this, layoutIdRes)
        init()
    }

    fun alert(message: String?) {
        MaterialAlertDialogBuilder(this, R.style.AlertDialogTheme).apply {
            setMessage(message)
            setTitle(getString(R.string.info))
            setPositiveButton(getString(R.string.alert_info_ok_button), null)
            show()
        }
    }
}