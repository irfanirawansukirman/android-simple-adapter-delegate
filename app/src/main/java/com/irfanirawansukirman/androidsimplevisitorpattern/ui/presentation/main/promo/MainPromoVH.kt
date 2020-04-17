package com.irfanirawansukirman.androidsimplevisitorpattern.ui.presentation.main.promo

import android.view.View
import android.widget.TextView
import com.irfanirawansukirman.androidsimplevisitorpattern.R
import com.irfanirawansukirman.androidsimplevisitorpattern.base.BaseVH
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item

class MainPromoVH(private val view: View) : BaseVH<Item>(view) {
    override fun bind(item: Item) {
        val title = view.findViewById<TextView>(R.id.txtPromoTitle)
        title.text = item.name
    }
}