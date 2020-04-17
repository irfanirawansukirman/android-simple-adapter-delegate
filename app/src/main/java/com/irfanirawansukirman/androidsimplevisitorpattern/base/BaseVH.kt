package com.irfanirawansukirman.androidsimplevisitorpattern.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseVH<in T>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T)
}