# SharingJetPackComponent
Impleentation of ShareSheet and Intent Resolver in Android.


fun ClickedShareSheet(){
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
    } // This function is use for share content by using ShareSheet.
    
    
    fun ClickedbyIntentResolver(){
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, editTextMessage.getText().toString())
            type = "text/plain"
        }
        startActivity(sendIntent)
    }// This function is use for share content by using Intent Resolver(No need of createChooser).
    
    
    
   MainActivity.kt class is used for sharing the content.
   
   Receiver.kt is used for receiving the content.
