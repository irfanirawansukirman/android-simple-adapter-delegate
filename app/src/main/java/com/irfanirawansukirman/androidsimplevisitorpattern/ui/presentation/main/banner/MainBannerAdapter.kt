package com.irfanirawansukirman.androidsimplevisitorpattern.ui.presentation.main.banner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.irfanirawansukirman.androidsimplevisitorpattern.R
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Banner
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso

class MainBannerAdapter : SliderViewAdapter<MainBannerAdapter.BannerViewHolder>() {

    val bannersList = arrayListOf<Banner>()

    fun setupBannerList(data: List<Banner>) {
        bannersList.apply {
            clear()
            addAll(data)
        }

        notifyDataSetChanged()
    }

    class BannerViewHolder(private val view: View) : SliderViewAdapter.ViewHolder(view) {
        fun bindItem(imageUrl: String) {
            val imgBanner = view.findViewById<ImageView>(R.id.imgBannerContent)
            Picasso.get().load(imageUrl).into(imgBanner)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?): BannerViewHolder {
        return BannerViewHolder(
            LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_banner_content, parent, false)
        )
    }

    override fun getCount(): Int = bannersList.size

    override fun onBindViewHolder(viewHolder: BannerViewHolder?, position: Int) {
        viewHolder?.bindItem(bannersList[position].imageUrl)
    }

}