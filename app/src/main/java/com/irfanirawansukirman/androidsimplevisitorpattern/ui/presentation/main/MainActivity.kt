package com.irfanirawansukirman.androidsimplevisitorpattern.ui.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.irfanirawansukirman.androidsimplevisitorpattern.databinding.ActivityMainBinding
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Banner
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

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

            val bannerList = listOf(
                Banner("https://pbs.twimg.com/profile_images/742658185102807040/o4gJSvNZ_400x400.jpg"),
                Banner("https://vignette.wikia.nocookie.net/iron-helix/images/5/53/Winterpeak.jpg/revision/latest/scale-to-width-down/340?cb=20140618075437"),
                Banner("https://cdn140.picsart.com/323208540329201.jpg?type=webp&to=crop&r=256")
            )

            val json = Json(JsonConfiguration.Stable)
            val bannerListAsString = json.stringify(Banner.serializer().list, bannerList)

            val itemsList = listOf(
                Item(
                    "Dog",
                    "Dog",
                    bannerListAsString
                ),
                Item(
                    "Car",
                    "Car",
                    "data"
                ),
                Item(
                    "Mouse",
                    "Mouse",
                    "data"
                )
            )

            mainAdapter.setupItemsList(itemsList)
        }
    }
}

