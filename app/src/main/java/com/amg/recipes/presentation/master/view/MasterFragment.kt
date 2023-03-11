package com.amg.recipes.presentation.master.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.amg.recipes.databinding.FragmentMasterBinding
import com.amg.recipes.presentation.master.dto.RecipeDTO
import com.amg.recipes.presentation.master.view.adapter.RecipesAdapter
import com.amg.recipes.presentation.master.viewModel.MasterViewModel
import com.amg.recipes.utils.autoCleared
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MasterFragment : Fragment() {

    private val masterViewModel: MasterViewModel by viewModels()
    private var binding by autoCleared<FragmentMasterBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMasterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        initListeners()
        initObservers()
        getRecipes()
    }

    private fun setupView() {

    }

    private fun initListeners() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            getRecipes()
        }
    }

    private fun getRecipes() {
        masterViewModel.getRecipes()
    }

    private fun initObservers() {
        with(masterViewModel) {
            onShowMessage.observe(viewLifecycleOwner) { message ->
                showMessage(message)
            }

            onShowLoading.observe(viewLifecycleOwner) { isShow ->
                showLoading(isShow)
            }
            onRecipesCatalog.observe(viewLifecycleOwner) { recipes ->
                showRecipes(recipes)
            }
        }
    }

    private fun showRecipes(recipes: List<RecipeDTO>) {
        val recipesAdapter = RecipesAdapter { recipe ->
            // TODO navigate to detail
        }
        binding.rvBeer.adapter = recipesAdapter
        recipesAdapter.submitList(recipes)
    }

    private fun showMessage(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun showLoading(isShow: Boolean) {
        with(binding) {
            swipeRefreshLayout.isRefreshing = isShow
        }
    }

}