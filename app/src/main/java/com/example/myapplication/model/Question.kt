package com.example.myapplication.model

data class Question(
    val question: String,
    val imgSrc: String,
    val firstAns: Pair<String, Boolean>,
    val secondAns: Pair<String, Boolean>,
    val thirdAns: Pair<String, Boolean>,
    val fourthAns: Pair<String, Boolean>,
)
