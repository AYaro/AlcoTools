package com.example.alcotools.ui.dashboard

import androidx.annotation.DrawableRes
import java.io.Serializable

data class DashElement (
    val title: String,
    @DrawableRes val image: Int,
    val description: String,
    val place: Int
) : Serializable