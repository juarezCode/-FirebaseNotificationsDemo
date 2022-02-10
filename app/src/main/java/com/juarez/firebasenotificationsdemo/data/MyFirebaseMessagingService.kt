package com.juarez.firebasenotificationsdemo.data

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * la notificacion siempre llega en segundo plano, cuando esta en primer plano se debe manejar
 * por nosotros mismos.
 */
class MyFirebaseMessagingService : FirebaseMessagingService() {

    //handle notification in foreground
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Looper.prepare()
        Handler().post {
            Toast.makeText(baseContext, remoteMessage.notification?.title, Toast.LENGTH_LONG).show()
        }
        Looper.loop()
    }
}