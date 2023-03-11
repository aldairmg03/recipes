package com.amg.recipes.presentation.master.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.amg.recipes.R
import com.amg.recipes.presentation.master.viewModel.MasterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MasterFragment : Fragment() {

    private val viewModel: MasterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_master, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRecipes()
    }

}