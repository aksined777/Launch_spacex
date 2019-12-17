package com.example_dk.exchange.myapplication.utlils.extention

fun String?.toStrDate():String {
    var result = ""
    this?.let {
        if (it.length > 10)
            result = it.substring(0,10)
    }
    return result
}