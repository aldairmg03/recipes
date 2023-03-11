package com.amg.recipes.presentation.detail.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.amg.recipes.R
import com.amg.recipes.constants.RecipesConstants
import com.amg.recipes.databinding.FragmentDetailBinding
import com.amg.recipes.extensions.parcelable
import com.amg.recipes.presentation.detail.view.adapter.FoodPairingAdapter
import com.amg.recipes.presentation.master.dto.RecipeDTO
import com.amg.recipes.utils.autoCleared
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class DetailFragment : Fragment() {

    private var binding by autoCleared<FragmentDetailBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        setupToolbar()
        val recipe: RecipeDTO? = arguments?.parcelable(RecipesConstants.BUNDLE_RECIPES)
        recipe?.let {
            setBeerDetail(it)
        } ?: findNavController()
    }

    private fun initListeners() {
        binding.contentDetail.tvSeeMap.setOnClickListener {
            // TODO show map
        }
    }

    private fun setupToolbar() {
        binding.beerDetailToolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.beerDetailToolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setBeerDetail(recipe: RecipeDTO) {

        with(recipe) {
            setupRecyclerView(foodPairing)
            binding.beerDetailToolbar.title = name

            binding.contentDetail.tvDetailTagline.text =
                getString(R.string.label_tag_line, tagLine, firstBrewed)
            binding.contentDetail.tvDetailDescription.text = description

            Glide.with(binding.root)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivDetailBeer)
        }
    }

    private fun setupRecyclerView(foodPairing: List<String>) {
        val adapter = FoodPairingAdapter(foodPairing)
        binding.contentDetail.rvFoodPairing.adapter = adapter
    }


}