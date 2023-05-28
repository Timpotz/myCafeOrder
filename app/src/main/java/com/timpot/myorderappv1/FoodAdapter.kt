import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.timpot.myorderappv1.R

class FoodAdapter(private val foodList: List<Food>,private val orderedItems: MutableList<Food>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageFood: ImageView = itemView.findViewById(R.id.imageFood)
        val textFoodName: TextView = itemView.findViewById(R.id.textFoodName)
        val textFoodDescription: TextView = itemView.findViewById(R.id.textFoodDescription)
        val buttonMinus: ImageButton = itemView.findViewById(R.id.buttonMinus)
        val textQuantity: TextView = itemView.findViewById(R.id.textQuantity)
        val buttonPlus: ImageButton = itemView.findViewById(R.id.buttonPlus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = foodList[position]
        holder.imageFood.setImageResource(food.imageResId)
        holder.textFoodName.text = food.name
        holder.textFoodDescription.text = food.description
        holder.textQuantity.text = food.quantity.toString()

        holder.buttonMinus.setOnClickListener {
            if (food.quantity > 0) {
                food.quantity--
                notifyItemChanged(position)
            }
        }

        holder.buttonPlus.setOnClickListener {
            food.quantity++
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun setOrderedItems() {
        foodList.forEach { item ->
            if (item.quantity > 0)
                orderedItems.add(Food(item.imageResId, item.name, item.description, item.quantity))
        }
    }

    fun getOrderedItems(): List<Food> {
        return orderedItems.toList()
    }
}