package com.example.recyclerview01_2025

import androidx.annotation.DrawableRes

data class Model(
    var marca: String,
    val modelo: String,
    @DrawableRes var foto: Int
)

