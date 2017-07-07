package com.example.hsg.meterialdesignstudy.ui.view

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * Created by hsg on 22/06/2017.
 */
public class CallApi(val url: String) {
    public fun run(): ListResponse {
        val reponseJson = URL(url).readText()
        Log.v(javaClass.simpleName, reponseJson)
        return Gson().fromJson(reponseJson, ListResponse::class.java)
    }
}