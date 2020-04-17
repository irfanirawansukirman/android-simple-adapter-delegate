package com.irfanirawansukirman.androidsimplevisitorpattern.ui.presentation.main.banner

import android.graphics.Color
import android.view.View
import com.irfanirawansukirman.androidsimplevisitorpattern.R
import com.irfanirawansukirman.androidsimplevisitorpattern.base.BaseVH
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Banner
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

class MainBannerVH(private val view: View) : BaseVH<Item>(view) {

    private lateinit var mainBannerAdapter: MainBannerAdapter

    @ImplicitReflectionSerializer
    override fun bind(item: Item) {
        val bannerSlider = view.findViewById<SliderView>(R.id.bannerSlider)
        if (!::mainBannerAdapter.isInitialized) {
            mainBannerAdapter =
                MainBannerAdapter()
        }

        bannerSlider.apply {
            setSliderAdapter(mainBannerAdapter)
            setIndicatorAnimation(IndicatorAnimations.COLOR) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
            setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
            indicatorSelectedColor = Color.WHITE
            indicatorUnselectedColor = Color.GRAY
            scrollTimeInSec = 3
            startAutoCycle()
        }

        if (item.type == "Dog") {
            val json = Json(JsonConfiguration.Stable)
            val bannersAsArray = json.parse(Banner.serializer().list, item.data)
            mainBannerAdapter.setupBannerList(bannersAsArray)
        }
    }
}