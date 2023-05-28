package com.timpot.myorderappv1

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrderSummaryActivity : AppCompatActivity() {
    private lateinit var recyclerViewOrderedItems: RecyclerView
    private lateinit var orderedItemsAdapter: OrderedItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_summary)
        supportActionBar?.title = "Order Summary"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.orange)))
        recyclerViewOrderedItems = findViewById(R.id.recyclerViewOrderedItems)
        recyclerViewOrderedItems.layoutManager = LinearLayoutManager(this)

        val orderedItems = intent.getParcelableArrayListExtra<Food>("ordered_items")
        val orderedItemsList = orderedItems?.toList() ?: emptyList()
        orderedItemsAdapter = OrderedItemsAdapter(orderedItemsList)
        recyclerViewOrderedItems.adapter = orderedItemsAdapter

        var totalPrices = 0;
        orderedItemsList.forEach { item ->
            if (item.quantity > 0)
                totalPrices += item.totalPerItem
        }

        val tvTotal: TextView = findViewById(R.id.tvTotalPrices)
        tvTotal.text = totalPrices.toString()
    }
}