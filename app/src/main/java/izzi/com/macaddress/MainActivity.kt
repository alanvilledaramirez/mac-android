package izzi.com.macaddress

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.net.wifi.WifiInfo
import android.content.Context.WIFI_SERVICE
import android.net.wifi.WifiManager
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetData.setOnClickListener(this)
        btnLimpiar.setOnClickListener(this)
    }

    fun getMacId():String {

        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val wifiInfo = wifiManager.connectionInfo


        return if (wifiInfo.bssid!= null) {
            txtData.text = wifiInfo.toString()
            txtMac.text = "MAC: "+ wifiInfo.bssid
            wifiInfo.bssid
        }else{
            ""
        }
    }

    override fun onClick(p0: View?) {
        if (p0 == btnGetData){
            getMacId()
        }else{
            txtData.text = ""
            txtMac.text = ""
        }
    }
}
