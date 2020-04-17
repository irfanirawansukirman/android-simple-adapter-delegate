package com.irfanirawansukirman.androidsimplevisitorpattern.util

import android.view.View
import com.irfanirawansukirman.androidsimplevisitorpattern.base.BaseVH
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item

interface ViewHolderTypeFactory {
    fun type(item: Item): Int
    fun create(parent: View, viewType: Int): BaseVH<Item>
}