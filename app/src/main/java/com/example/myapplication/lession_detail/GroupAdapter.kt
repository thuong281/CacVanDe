package com.example.myapplication.lession_detail

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.GroupItemBinding
import com.example.myapplication.model.Group

class GroupAdapter(private val listener: ClickListener) : RecyclerView.Adapter<ItemViewHolder.GroupViewHolder>() {
    
    var items = listOf<Group>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ItemViewHolder.GroupViewHolder {
        return ItemViewHolder.GroupViewHolder(
            GroupItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
    
    override fun onBindViewHolder(holder: ItemViewHolder.GroupViewHolder, position: Int) {
        holder.bind(items[position])
        var adapter = holder.rv.adapter
        if (items[position].isSelected) {
            holder.rv.visibility = View.VISIBLE
            holder.detail.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
        } else {
            holder.rv.visibility = View.GONE
            holder.detail.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24)
        }
        if (adapter == null) {
            holder.rv.adapter = ItemInGroupAdapter()
            (holder.rv.adapter as ItemInGroupAdapter).items = items[position].items
        } else {
            (adapter as ItemInGroupAdapter).items = items[position].items
        }
        holder.group.setOnClickListener {
            listener.onGroupClick(items[position], position)
        }
    }
    
    override fun getItemCount() = items.size
    
    interface ClickListener {
        fun onGroupClick( group: Group, position: Int)
    }
}