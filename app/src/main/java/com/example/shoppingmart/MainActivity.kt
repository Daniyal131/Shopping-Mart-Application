package com.example.shoppingmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoppingmart.ui.ShoppingMartNavigation
import com.example.shoppingmart.ui.home.HomeScreen
import com.example.shoppingmart.ui.theme.ShoppingMartTheme


/* delete functionality needs to implement
https://www.youtube.com/watch?v=-Kx9D54laqU&list=PLUPcj46QWTDWlxtIwE3A6VEWUFEO8nh0Z&index=6
duration 1:30:00
* */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingMartTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShoppingMartApp()
                }
            }
        }
    }

    @Composable
    fun ShoppingMartApp() {
        ShoppingMartNavigation()
    }
}