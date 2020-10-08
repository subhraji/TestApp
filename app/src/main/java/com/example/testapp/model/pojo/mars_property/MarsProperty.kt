package com.example.testapp.model.pojo.mars_property


import com.google.gson.annotations.SerializedName

data class MarsProperty(
    @SerializedName("id")
    val id: String,
    @SerializedName("img_src")
    val imgSrc: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("type")
    val type: String
)