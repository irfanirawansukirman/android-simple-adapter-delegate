package com.irfanirawansukirman.androidsimpleadapterdelegate.util

import android.view.View
import com.irfanirawansukirman.androidsimpleadapterdelegate.base.BaseVH
import com.irfanirawansukirman.androidsimpleadapterdelegate.model.Item

interface ViewHolderTypeFactory {
    fun type(item: Item): Int
    fun create(parent: View, viewType: Int): BaseVH<Item>
}