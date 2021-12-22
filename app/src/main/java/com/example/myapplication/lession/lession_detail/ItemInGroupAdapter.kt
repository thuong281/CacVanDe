package com.example.myapplication.lession.lession_detail

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.*
import com.example.myapplication.model.Picture

class ItemInGroupAdapter : RecyclerView.Adapter<ItemViewHolder>() {
    
    var items = listOf<Any>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when (viewType) {
            R.layout.text_in_group -> {
                ItemViewHolder.TextViewHolder(
                    TextInGroupBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            R.layout.image_in_group -> {
                ItemViewHolder.PictureViewHolder(
                    ImageInGroupBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw IllegalArgumentException("Invalid ViewType")
        }
    }
    
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder.TextViewHolder -> {
                holder.bind(items[position] as String)
            }
            is ItemViewHolder.PictureViewHolder -> {
                holder.bind(items[position] as Picture)
            }
        }
    }
    
    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is String -> R.layout.text_in_group
            is Picture -> R.layout.image_in_group
            else -> throw IllegalArgumentException("Invalid ViewType")
        }
    }
    
    override fun getItemCount() = items.size
}