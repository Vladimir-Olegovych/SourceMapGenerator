package org.example.models.settings

import org.example.models.HammerObject

class Cameras: HammerObject("cameras") {
    init {
        put("activecamera", "-1")
    }
}