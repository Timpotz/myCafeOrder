package com.timpot.myorderappv1

import Food
import FoodAdapter
import android.os.Bundle
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.system.exitProcess

class OrderFoodActivity : AppCompatActivity() {
    private lateinit var buttonOrder: Button
    private lateinit var recyclerViewFood: RecyclerView
    private lateinit var foodAdapter: FoodAdapter
    private val orderedItems: MutableList<Food> = mutableListOf() // List to store the ordered items

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_food)
        supportActionBar?.title = "Menu"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.orange)))
        buttonOrder = findViewById(R.id.buttonOrder)
        buttonOrder.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))

        recyclerViewFood = findViewById(R.id.recyclerViewFood)
        recyclerViewFood.layoutManager = LinearLayoutManager(this)

        val foodList = getFoodList()
        foodAdapter = FoodAdapter(foodList,orderedItems)
        recyclerViewFood.adapter = foodAdapter

        foodAdapter = FoodAdapter(foodList, orderedItems) // Pass the orderedItems list to the adapter
        recyclerViewFood.adapter = foodAdapter

        val buttonPlaceOrder = findViewById<Button>(R.id.buttonOrder)
        buttonPlaceOrder.setOnClickListener {
            // set ordered food item
            foodAdapter.setOrderedItems()

            // Get the list of ordered items
            val orderedItemsList = foodAdapter.getOrderedItems()
            println(orderedItemsList)

            // Start the OrderSummaryActivity and pass the ordered items
            val intent = Intent(this, OrderSummaryActivity::class.java)
            intent.putParcelableArrayListExtra("ordered_items", ArrayList(orderedItems))
            startActivity(intent)
        }

    }

    private fun getFoodList(): List<Food> {
        val foodList = mutableListOf<Food>()
        foodList.add(Food(R.drawable.burger1, "Burger", "Delicious burger with juicy beef patty"))
        foodList.add(Food(R.drawable.pizza, "Pizza", "Classic pizza with a variety of toppings"))
        foodList.add(Food(R.drawable.pasta, "Pasta", "Homemade pasta cooked al dente with a choice of rich sauces and toppings"))
        foodList.add(Food(R.drawable.saksang, "Saksang", "Experience the fiery flavors of North Sumatra with our authentic Saksang - tender pork infused with a blend of aromatic spices, creating a tantalizing dish that will transport your taste buds to the heart of Indonesia."))
        foodList.add(Food(R.drawable.coffee, "Coffee", "Freshly brewed coffee made from premium beans for an aromatic experience"))
        foodList.add(Food(R.drawable.tea, "Tea", "Wide selection of fine teas from around the world, offering a soothing taste"))
        foodList.add(Food(R.drawable.smoothie, "Smoothie", "Refreshing and nutritious smoothies made from a blend of fresh fruits and yogurt"))
        foodList.add(Food(R.drawable.cocacola, "CocaCola", "Refreshing taste of Coca Cola"))
        foodList.add(Food(R.drawable.tuak, "Tuak", "Indulge in the exotic allure of Tuak, a tantalizing traditional brew that awakens your senses with its rich flavors"))
        // Add more food items here

        return foodList
    }
}

