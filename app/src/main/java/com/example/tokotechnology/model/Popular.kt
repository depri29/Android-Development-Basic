package com.example.tokotechnology.model

data class Popular(
    val title:String,
    val description:String,
    val picUrl:String,
    val review:Int,
    val score:Double,
    val numberInCart:Int,
    val price:Int
) :java.io.Serializable