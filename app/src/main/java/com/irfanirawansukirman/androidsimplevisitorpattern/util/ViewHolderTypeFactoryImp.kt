package com.irfanirawansukirman.androidsimplevisitorpattern.util

import android.view.View
import com.irfanirawansukirman.androidsimplevisitorpattern.base.BaseVH
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item.Companion.PRIMARY
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item.Companion.PRIMARY_VIEW
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item.Companion.SECONDARY
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item.Companion.SECONDARY_VIEW
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item.Companion.TERTIARY_VIEW
import com.irfanirawansukirman.androidsimplevisitorpattern.ui.viewholder.CarVH
import com.irfanirawansukirman.androidsimplevisitorpattern.ui.viewholder.DogVH
import com.irfanirawansukirman.androidsimplevisitorpattern.ui.viewholder.MouseVH

class ViewHolderTypeFactoryImp : ViewHolderTypeFactory {
    override fun create(parent: View, viewType: Int): BaseVH<Item> {
        return when (viewType) {
            PRIMARY_VIEW -> DogVH(
                parent
            )
            SECONDARY_VIEW -> CarVH(
                parent
            )
            else -> MouseVH(
                parent
            )
        }
    }

    override fun type(item: Item): Int {
        return when (item.type) {
            PRIMARY -> PRIMARY_VIEW
            SECONDARY -> SECONDARY_VIEW
            else -> TERTIARY_VIEW
        }
    }
}
