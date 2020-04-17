package com.irfanirawansukirman.androidsimpleadapterdelegate.model

import com.irfanirawansukirman.androidsimpleadapterdelegate.R
import com.irfanirawansukirman.androidsimpleadapterdelegate.util.ViewHolderTypeFactory
import com.irfanirawansukirman.androidsimpleadapterdelegate.util.ViewModel

data class Item(
    val name: String,
    val type: String
): ViewModel {
    override fun type(viewHolderTypeFactory: ViewHolderTypeFactory): Int {
        return viewHolderTypeFactory.type(this)
    }

    companion object {
        const val PRIMARY = "Dog"
        const val SECONDARY = "Car"
        const val TERTIARY = "Mouse"
        const val PRIMARY_VIEW = R.layout.item_dog
        const val SECONDARY_VIEW = R.layout.item_car
        const val TERTIARY_VIEW = R.layout.item_mouse
    }

}