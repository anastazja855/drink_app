package com.example.drinkapplication.controller

import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkController @Inject constructor() {
    val isInternetConnected = MutableStateFlow<Boolean>(true)
}