package com.irfanirawansukirman.androidsimplevisitorpattern.ui.presentation.main.category

import android.view.View
import android.widget.TextView
import com.irfanirawansukirman.androidsimplevisitorpattern.R
import com.irfanirawansukirman.androidsimplevisitorpattern.base.BaseVH
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item

class MainCategoryVH(private val view: View) : BaseVH<Item>(view) {
    override fun bind(item: Item) {
        val title = view.findViewById<TextView>(R.id.txtCategoryTitle)
        title.text = item.name
    }
}