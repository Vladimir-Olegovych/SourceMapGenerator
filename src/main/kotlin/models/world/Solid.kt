package org.example.models.world

import org.example.Materials.NO_DRAW
import org.example.models.HammerObject
import org.example.tools.Vector3

class Solid: HammerObject("solid") {
    val editor = HammerObject("editor").apply {
        put("color", "0 0 0")
        put("visgroupshown", "1")
        put("visgroupautoshown", "1")
    }

    val sides = Array(6) { Side() }
    init {
        for (i in 0..1) sides[i].apply {
            put("uaxis", "[1 0 0 0] 0.25")
            put("vaxis", "[0 -1 0 0] 0.25")
        }
        for (i in 2..3) sides[i].apply {
            put("uaxis", "[0 1 0 0] 0.25")
            put("vaxis", "[0 0 -1 0] 0.25")
        }
        for (i in 4..5) sides[i].apply {
            put("uaxis", "[1 0 0 0] 0.25")
            put("vaxis", "[0 0 -1 0] 0.25")
        }
    }


    fun set(position: Vector3,
            size: Vector3,
            material: String = NO_DRAW) {

        val x1 = position.x - size.x / 2
        val y1 = position.z + size.z / 2
        val z1 = position.y + size.y / 2
        val x2 = position.x + size.x / 2
        val y2 = position.z - size.z / 2
        val z2 = position.y - size.y / 2

        sides[0].set(
            x1, y2, z2,
            x2, y2, z2,
            x2, y1, z2,
            material
        )
        sides[1].set(
            x1, y1, z1,
            x2, y1, z1,
            x2, y2, z1,
            material
        )

        sides[2].set(
            x1, y2, z2,
            x1, y1, z2,
            x1, y1, z1,
            material
        )
        sides[3].set(
            x2, y2, z1,
            x2, y1, z1,
            x2, y1, z2,
            material
        )

        sides[4].set(
            x2, y2, z2,
            x1, y2, z2,
            x1, y2, z1,
            material
        )
        sides[5].set(
            x2, y1, z1,
            x1, y1, z1,
            x1, y1, z2,
            material
        )
    }
}