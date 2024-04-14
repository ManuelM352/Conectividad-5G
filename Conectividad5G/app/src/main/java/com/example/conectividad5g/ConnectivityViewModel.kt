package com.example.conectividad5g

import android.content.Context
import android.net.ConnectivityManager
import android.net.TrafficStats
import android.telephony.TelephonyManager
import androidx.lifecycle.ViewModel

class ConnectivityViewModel : ViewModel() {
    fun is5GConnected(context: Context): Boolean {
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val networkType = telephonyManager.networkType
        return networkType == TelephonyManager.NETWORK_TYPE_NR // 5G
    }

    fun getNetworkUsage(): Long {
        return TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes()
    }

    fun getEstimatedBandwidth(context: Context): Int {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return -1

        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return -1

        return capabilities.linkDownstreamBandwidthKbps * 1024
    }
}