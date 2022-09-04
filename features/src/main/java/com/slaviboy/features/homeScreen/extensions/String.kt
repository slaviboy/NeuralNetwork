package com.slaviboy.features.homeScreen.extensions

import java.util.*

fun String.capitalizeWords(): String {
    return split(" ").joinToString(" ") { string ->
        string.replaceFirstChar {
            if (it.isLowerCase()) {
                it.titlecase(Locale.ENGLISH)
            } else {
                it.toString()
            }
        }
    }
}