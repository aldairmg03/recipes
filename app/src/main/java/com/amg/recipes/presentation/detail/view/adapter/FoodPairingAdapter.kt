package com.amg.recipes.presentation.detail.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amg.recipes.databinding.ItemFoodPairingBinding

class FoodPairingAdapter(private val items: List<String>) :
    RecyclerView.Adapter<FoodPairingAdapter.FoodPairingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodPairingViewHolder {
        val binding =
            ItemFoodPairingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodPairingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodPairingViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.count()

    inner class FoodPairingViewHolder(
        private val itemFoodPairingBinding: ItemFoodPairingBinding
    ) : RecyclerView.ViewHolder(itemFoodPairingBinding.root) {
        fun bind(item: String) {
            itemFoodPairingBinding.tvFoodPairing.text = item
        }
    }

}