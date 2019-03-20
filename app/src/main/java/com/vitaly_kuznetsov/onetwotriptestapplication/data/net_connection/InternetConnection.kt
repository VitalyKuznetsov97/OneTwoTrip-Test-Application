package com.vitaly_kuznetsov.onetwotriptestapplication.data.net_connection

import io.reactivex.Single
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

object InternetConnection {

    fun hasInternetConnection(): Single<Boolean> {
        return Single.fromCallable {
            try {
                // Connect to Google DNS to check for connection
                val timeoutMs = 1500
                val socket = Socket()
                val socketAddress = InetSocketAddress("8.8.8.8", 53)

                socket.connect(socketAddress, timeoutMs)
                socket.close()

                true
            }
            catch (e: IOException) {
                e.printStackTrace()
                false
            }
        }
    }

}