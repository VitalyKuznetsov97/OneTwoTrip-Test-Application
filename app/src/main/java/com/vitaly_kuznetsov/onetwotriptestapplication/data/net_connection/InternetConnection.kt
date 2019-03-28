package com.vitaly_kuznetsov.onetwotriptestapplication.data.net_connection

import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

object InternetConnection {

    fun hasInternetConnection(): Boolean {
        try {
            // Connect to Google DNS to check for connection
            val timeoutMs = 1500
            val socket = Socket()
            val socketAddress = InetSocketAddress("8.8.8.8", 53)

            socket.connect(socketAddress, timeoutMs)
            socket.close()

            return true
        }
        catch (e: IOException) {
            return false
        }
    }

}