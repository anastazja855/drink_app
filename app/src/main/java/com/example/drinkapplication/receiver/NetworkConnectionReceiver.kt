package com.example.drinkapplication.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import com.example.drinkapplication.controller.NetworkController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class NetworkConnectionReceiver constructor(
    ): BroadcastReceiver() {

    @Inject
    lateinit var networkController: NetworkController

    override fun onReceive(context: Context?, intent: Intent?) {
        val cm: ConnectivityManager? =
            context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val netInfo = cm!!.activeNetworkInfo

        val isInternetConnected : Boolean =  netInfo != null && netInfo.isConnected
        GlobalScope.launch {
            networkController.isInternetConnected.emit(isInternetConnected)
        }

            Log.d("NetworkConnectionReceiver", "Network connected")
    }
}