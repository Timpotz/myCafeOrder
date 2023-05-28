package com.timpot.myorderappv1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderedItemsAdapter(private val orderedItems: List<Food>) :
    RecyclerView.Adapter<OrderedItemsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageFood: ImageView = itemView.findViewById(R.id.imageFoodOrder)
        private val textFoodName: TextView = itemView.findViewById(R.id.textFoodName)
        private val textQuantity: TextView = itemView.findViewById(R.id.textQuantity)
        private val textPrice: TextView = itemView.findViewById(R.id.tv_prices)
        private val textTotalPrice: TextView = itemView.findViewById(R.id.tvTotalPricePerItem)

        fun bind(food: Food) {
            imageFood.setImageResource(food.imageResId)
            textFoodName.text = food.name
            textQuantity.text = food.quantity.toString()
            textPrice.text = food.price.toString()
            textTotalPrice.text = food.totalPerItem.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ordered_food, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = orderedItems[position]
        holder.bind(food)
    }

    override fun getItemCount(): Int {
        return orderedItems.size
    }
}