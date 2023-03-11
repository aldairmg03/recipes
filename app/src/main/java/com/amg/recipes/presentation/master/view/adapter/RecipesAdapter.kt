package com.amg.recipes.presentation.master.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amg.recipes.databinding.ItemRecipesBinding
import com.amg.recipes.presentation.master.dto.RecipeDTO
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class RecipesAdapter(
    private var onItemClicked: (recipe: RecipeDTO) -> Unit
) : ListAdapter<RecipeDTO, RecipesAdapter.RecipesViewHolder>(DiffCallbacks) {

    companion object DiffCallbacks : DiffUtil.ItemCallback<RecipeDTO>() {
        override fun areItemsTheSame(oldItem: RecipeDTO, newItem: RecipeDTO): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RecipeDTO, newItem: RecipeDTO): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemRecipesBinding.inflate(inflate, parent, false)
        return RecipesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val recipe = getItem(position)
        holder.bind(recipe)
    }

    inner class RecipesViewHolder(
        private val itemBinding: ItemRecipesBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: RecipeDTO) {
            itemBinding.tvName.text = item.name
            itemBinding.tvTagline.text = item.tagLine

            item.imageUrl.let {
                Glide.with(itemBinding.root)
                    .load(it)
                    .transform(CenterInside())
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(itemBinding.ivBeer)
            }

            itemBinding.root.setOnClickListener {
                onItemClicked(item)
            }
        }
    }

}