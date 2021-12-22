package com.example.myapplication.model

import android.content.Context

data class Group(
    val name: String,
) {
    val items: MutableList<Any> = ArrayList()
    var isSelected: Boolean = true

    fun addImageRange(start: Int, end: Int, context: Context) {
        for (i in start..end ){
            val name = "p$i"
            val id: Int = context.resources.getIdentifier(name, "drawable", context.packageName)
            items.add(Picture(id, "Hình $i"))
        }
    }
}
