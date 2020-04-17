package com.irfanirawansukirman.androidsimplevisitorpattern.util

import android.view.View
import com.irfanirawansukirman.androidsimplevisitorpattern.base.BaseVH
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item.Companion.PRIMARY
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item.Companion.PRIMARY_VIEW
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item.Companion.SECONDARY
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item.Companion.SECONDARY_VIEW
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item.Companion.TERTIARY_VIEW
import com.irfanirawansukirman.androidsimplevisitorpattern.ui.presentation.main.banner.MainBannerVH
import com.irfanirawansukirman.androidsimplevisitorpattern.ui.presentation.main.category.MainCategoryVH
import com.irfanirawansukirman.androidsimplevisitorpattern.ui.presentation.main.promo.MainPromoVH

class ViewHolderTypeFactoryImp : ViewHolderTypeFactory {
    override fun create(parent: View, viewType: Int): BaseVH<Item> {
        return when (viewType) {
            PRIMARY_VIEW -> MainBannerVH(
                parent
            )
            SECONDARY_VIEW -> MainCategoryVH(
                parent
            )
            else -> MainPromoVH(
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
