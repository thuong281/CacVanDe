package com.example.myapplication.model

data class Group(
    val name: String,
) {
    val items: List<Any> = ArrayList()
    var isSelected: Boolean = true
}
