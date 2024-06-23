package org.example.models.world

import org.example.models.HammerObject
import org.example.tools.Vector3

class Entity(className: String): HammerObject("entity") {
    init {
        put("angles", "0 0 0")
        put("classname", className)
    }

    fun set(vector3: Vector3) {
        put(
            "origin", StringBuilder().append(vector3.x).append(' ').append(vector3.z).append(' ').append(vector3.y).toString()
        )
    }

    val editor = HammerObject("editor").apply {
        put("color", "0 255 0")
        put("visgroupshown", "1")
        put("visgroupautoshown", "1")
        put("logicalpos", "[0 0]")
    }
}
