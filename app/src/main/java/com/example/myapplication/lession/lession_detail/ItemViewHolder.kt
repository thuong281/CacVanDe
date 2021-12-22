package com.example.myapplication.lession.lession_detail

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.myapplication.databinding.*
import com.example.myapplication.model.*

sealed class ItemViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    class TextViewHolder(private val binding: TextInGroupBinding) : ItemViewHolder(binding) {
        fun bind(text: String) {
            binding.text.text = "\t\t\t\t$text"
        }
    }
    class PictureViewHolder(private val binding: ImageInGroupBinding) : ItemViewHolder(binding) {
        fun bind(picture: Picture) {
            binding.image.setImageResource(picture.imgSrc)
            binding.imageDescription.text = picture.imgDescription
        }
    }
    class GroupViewHolder(private val binding: GroupItemBinding) : ItemViewHolder(binding) {
        val rv = binding.rv
        val detail = binding.detail
        val group = binding.group
        fun bind(group: Group) {
            binding.title.text = group.name
        }
    }
}