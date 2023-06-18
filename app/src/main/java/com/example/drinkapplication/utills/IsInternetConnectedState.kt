package com.example.drinkapplication.utills

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.drinkapplication.controller.NetworkController


@Composable
fun IsInternetConnectedState(networkController: NetworkController): Boolean {
    val isInternetConnectedState by networkController.isInternetConnected.collectAsState()
    return isInternetConnectedState
}