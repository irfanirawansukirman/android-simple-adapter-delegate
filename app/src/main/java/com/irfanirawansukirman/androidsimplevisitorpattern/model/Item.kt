package com.irfanirawansukirman.androidsimplevisitorpattern.model

import com.irfanirawansukirman.androidsimplevisitorpattern.R
import com.irfanirawansukirman.androidsimplevisitorpattern.util.ViewHolderTypeFactory
import com.irfanirawansukirman.androidsimplevisitorpattern.util.ViewModel

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