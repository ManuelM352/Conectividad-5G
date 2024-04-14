package com.example.conectividad5g

import android.content.Context
import android.telephony.TelephonyManager
import androidx.lifecycle.ViewModel

class ConnectivityViewModel : ViewModel() {
    fun is5GConnected(context: Context): Boolean {
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val networkType = telephonyManager.networkType
        return when (networkType) {
            TelephonyManager.NETWORK_TYPE_NR -> true // 5G
            else -> false
        }
    }
}