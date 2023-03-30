package com.org.d3if3025.assessment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = ArrayList()

        foodList.add(Food(R.drawable.bakso , "Bakso"))
        foodList.add(Food(R.drawable.rendang , "Rendang"))
        foodList.add(Food(R.drawable.sate , "Sate"))
        foodList.add(Food(R.drawable.soto , "Soto"))
        foodList.add(Food(R.drawable.nasi_goreng , "Nasi goreng"))

        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter

        foodAdapter.onItemClick = {
            val intent = Intent(this , DetailedActivity::class.java)
            intent.putExtra("food", it)
            startActivity(intent)
        }
    }
}