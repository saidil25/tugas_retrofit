package com.example.tugas_retrofit.model

import com.google.gson.annotations.SerializedName

data class ListModel(
    @SerializedName("result")
    val `result`:List<ListData>
)

data class ListData(
    @SerializedName("id")
    val`id`: Int,
    @SerializedName("title")
    val`title`: String,
    @SerializedName("image")
    val`image`: String

)
