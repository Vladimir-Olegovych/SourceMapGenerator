package org.example.models.settings

import org.example.models.HammerObject

class Cordon: HammerObject("cordon") {
    init {
        put("mins", "(-1024 -1024 -1024)")
        put("maxs", "(1024 1024 1024)")
        put("active", "0")
    }
}