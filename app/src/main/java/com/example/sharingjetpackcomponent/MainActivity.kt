package com.example.sharingjetpackcomponent

import android.app.PendingIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            ClickedShareSheet() //Share data by using ShareSheet
//            ClickedbyIntentResolver() //Share data by using IntentResolver(if single application will available in suggestion list it will run,no need to choose)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun ClickedShareSheet() {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, editTextMessage.getText().toString())
            type = "text/plain"
        }

        val pi = PendingIntent.getBroadcast(
            applicationContext, 100,
            Intent(applicationContext, MyBroadcastReceiver::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val share = Intent.createChooser(intent, null, pi.intentSender)
        startActivity(share)
    }

    fun ClickedbyIntentResolver(){
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, editTextMessage.getText().toString())
            type = "text/plain"
        }
        startActivity(sendIntent)
    }

}