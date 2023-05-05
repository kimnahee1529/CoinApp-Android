package com.example.coco.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.example.coco.service.PriceForegroundService

class BootReceiver : BroadcastReceiver() {

    //앱이 재실행되면 어떻게 할건지
    override fun onReceive(context: Context?, intent: Intent?) {

        if(intent?.action.equals("android.intent.action.BOOT_COMPLETED")) {

            val foreground = Intent(context, PriceForegroundService::class.java)
            foreground.action = "START"

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                context?.startForegroundService(foreground)
            }else{
                context?.startService(foreground)
            }
        }

    }

}