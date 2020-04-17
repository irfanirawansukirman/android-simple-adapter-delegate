package com.irfanirawansukirman.androidsimpleadapterdelegate.ui.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.irfanirawansukirman.androidsimpleadapterdelegate.databinding.ActivityMainBinding
import com.irfanirawansukirman.androidsimpleadapterdelegate.model.Item

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        if (!::mainAdapter.isInitialized) {
            mainAdapter =
                MainAdapter()
            mainBinding.apply {
                recyclerMain.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    setHasFixedSize(true)
                    adapter = mainAdapter
                }
            }

            val itemsList = listOf(
                Item(
                    "Dog",
                    "Dog"
                ),
                Item(
                    "Car",
                    "Car"
                ),
                Item(
                    "Mouse",
                    "Mouse"
                ),
                Item(
                    "Dog",
                    "Dog"
                ),
                Item(
                    "Car",
                    "Car"
                ),
                Item(
                    "Mouse",
                    "Mouse"
                )
            )

            mainAdapter.setupItemsList(itemsList)
        }
    }
}
