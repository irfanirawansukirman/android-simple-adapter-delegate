package com.irfanirawansukirman.androidsimplevisitorpattern.ui.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.irfanirawansukirman.androidsimplevisitorpattern.base.BaseVH
import com.irfanirawansukirman.androidsimplevisitorpattern.model.Item
import com.irfanirawansukirman.androidsimplevisitorpattern.util.ViewHolderTypeFactory
import com.irfanirawansukirman.androidsimplevisitorpattern.util.ViewHolderTypeFactoryImp

class MainAdapter : RecyclerView.Adapter<BaseVH<Item>>() {

    private val typeFactory: ViewHolderTypeFactory = ViewHolderTypeFactoryImp()

    private val items = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH<Item> {
        return typeFactory.create(
            LayoutInflater
                .from(parent.context)
                .inflate(viewType, parent, false), viewType
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseVH<Item>, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type(typeFactory)
    }

    fun setupItemsList(data: List<Item>) {
        items.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

}