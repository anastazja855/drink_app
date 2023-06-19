package com.example.drinkapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.drinkapplication.navigation.Navigation
import com.example.drinkapplication.ui.theme.DrinkApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var receiver: NetworkConnectionReceiver

//    private lateinit var networkConnectionReceiver: NetworkConnectionReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Navigation(navController)
                }
            }
        }
        //receiver = NetworkConnectionReceiver()
//        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
//        this.registerReceiver(NetworkConnectionReceiver(), filter)
    }
//    override fun onDestroy() {
//        super.onDestroy()
//       unregisterReceiver(networkConnectionReceiver)
//    }
}
