package com.shzlabs.mycart.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.google.android.material.snackbar.Snackbar
import com.shzlabs.mycart.di.ViewModelFactory
import com.shzlabs.mycart.di.components.AppComponent
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel>: Fragment() {

    lateinit var rootView: View
    lateinit var viewModel: VM

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var glideRequestManager: RequestManager


    abstract fun getLayoutRes(): Int
    abstract fun getViewModelClass(): Class<VM>
    abstract fun injectDependency()
    abstract fun initViews()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(getLayoutRes(), container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(getViewModelClass())

        initViews()
        setupObservers()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectDependency()
    }

    open fun setupObservers() {
        viewModel.onError.observe(viewLifecycleOwner, Observer { showError(it) })
    }

    fun getDiComponent() : AppComponent {
        return (activity as BaseActivity).getDiComponent()
    }

    fun showError(msg: String) {
        Snackbar.make(rootView, msg, Snackbar.LENGTH_LONG).show()
    }

    fun getImageLoader(): RequestManager {
        return glideRequestManager
    }

}