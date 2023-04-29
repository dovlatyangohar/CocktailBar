package com.example.cocktailbar.ui.fragment.randomdrink


import com.example.cocktailbar.base.fragment.FragmentBaseNCMVVM
import com.example.cocktailbar.base.utils.viewBinding
import com.example.cocktailbar.databinding.FragmentRandomDrinkBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class RandomDrinkFragment : FragmentBaseNCMVVM<RandomDrinkViewModel, FragmentRandomDrinkBinding>() {
    override val viewModel: RandomDrinkViewModel by viewModel()
    override val binding: FragmentRandomDrinkBinding by viewBinding()

    override fun onView() {
        super.onView()
        
    }

    override fun onViewClick() {
        super.onViewClick()
    }

    override fun onEach() {
        super.onEach()
    }
}