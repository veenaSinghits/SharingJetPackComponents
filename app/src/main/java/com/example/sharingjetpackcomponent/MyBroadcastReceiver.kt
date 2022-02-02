package com.example.sharingjetpackcomponent

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.Intent.EXTRA_CHOSEN_COMPONENT
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

class MyBroadcastReceiver : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    override fun onReceive(p0: Context?, p1: Intent?) {
        val clickedComponent : ComponentName? = p1?.getParcelableExtra(EXTRA_CHOSEN_COMPONENT);
        Log.d("Veena",clickedComponent.toString())
        if(clickedComponent.toString().contains("com.example.sharingjetpackcomponent"))
        {
            Log.d("Veena",clickedComponent.toString())
            val i = Intent()
            if (p0 != null) {
                i.setClass(p0,Receiver::class.java)
            }
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            p0?.startActivity(i)
        }


    }
}