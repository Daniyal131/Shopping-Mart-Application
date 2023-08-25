package com.example.shoppingmart.ui

import androidx.annotation.DrawableRes

object Utils {
    val category = listOf(
        Category(title = "Drink" , resId = androidx.core.R.drawable.ic_call_answer , id = 0),
        Category(title = "Vegetable" , resId = androidx.core.R.drawable.ic_call_answer , id = 1),
        Category(title = "Fruits" , resId = androidx.core.R.drawable.ic_call_answer , id = 2),
        Category(title = "Cleaning" , resId = androidx.core.R.drawable.ic_call_answer , id = 3),
        Category(title = "Electronic" , resId = androidx.core.R.drawable.ic_call_answer , id = 4),
        Category(title = "None" , resId = androidx.core.R.drawable.ic_call_answer , id = 10001),
    )
}

data class Category(
    @DrawableRes val resId: Int = -1,
    val title: String = "",
    val id: Int = -1
)