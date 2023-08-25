package com.example.shoppingmart

import android.app.Application

class ShoppingMartApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}