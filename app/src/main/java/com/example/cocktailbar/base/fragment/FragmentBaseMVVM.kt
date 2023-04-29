package com.example.cocktailbar.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.cocktailbar.base.utils.observeInLifecycle
import com.example.cocktailbar.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

abstract class FragmentBaseMVVM<ViewModel : BaseViewModel, ViewBind : ViewBinding> :
    Fragment() {

    abstract val viewModel: ViewModel
    abstract val binding: ViewBind


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onEach()
        onView()
        onViewClick()

    }

    protected open fun onView() {}

    protected open fun onViewClick() {}

    protected open fun onEach() {}

    protected inline fun <reified T> onEach(flow: Flow<T>, crossinline action: (T) -> Unit) =
        view?.run {
            if (!this@FragmentBaseMVVM.isAdded) return@run
            flow.onEach { action(it ?: return@onEach) }.observeInLifecycle(viewLifecycleOwner)
        }

    protected open fun toast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()

    }

}