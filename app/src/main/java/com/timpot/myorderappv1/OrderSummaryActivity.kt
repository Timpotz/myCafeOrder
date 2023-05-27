package com.timpot.myorderappv1

import Food
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrderSummaryActivity : AppCompatActivity() {
    private lateinit var recyclerViewOrderedItems: RecyclerView
    private lateinit var orderedItemsAdapter: OrderedItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_summary)
        supportActionBar?.title = "Order Summary"

        recyclerViewOrderedItems = findViewById(R.id.recyclerViewOrderedItems)
        recyclerViewOrderedItems.layoutManager = LinearLayoutManager(this)

        val orderedItems = intent.getParcelableArrayListExtra<Food>("ordered_items")
        val orderedItemsList = orderedItems?.toList() ?: emptyList()
        orderedItemsAdapter = OrderedItemsAdapter(orderedItemsList)
        recyclerViewOrderedItems.adapter = orderedItemsAdapter
    }
}