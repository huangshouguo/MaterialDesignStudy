package com.example.hsg.meterialdesignstudy.ui.view

/**
 * Created by hsg on 22/06/2017.
 */
public class LvjinApiService() {
    companion object {
        private val BASE_URL = "http://139.196.34.53:8090/"
    }

    public fun getGroupRecomment(): String {
        val PATH = "groups/recommend";
        return BASE_URL + PATH;
    }
}