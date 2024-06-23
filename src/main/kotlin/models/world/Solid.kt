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

    private var vector3Position = Vector3(0, 0, 0)
    private var vector3Size = Vector3(0, 0, 0)
    private var material = NO_DRAW

    fun getPosition(): Vector3 = vector3Position
    fun getSize(): Vector3 = vector3Size
    fun getMaterial(): String = material

    fun set(vector3Position: Vector3,
            vector3Size: Vector3,
            material: String = NO_DRAW) {

        this.vector3Position = vector3Position
        this.vector3Size = vector3Size
        this.material = material

        val x1 = vector3Position.x - vector3Size.x / 2
        val y1 = vector3Position.z + vector3Size.z / 2
        val z1 = vector3Position.y + vector3Size.y / 2
        val x2 = vector3Position.x + vector3Size.x / 2
        val y2 = vector3Position.z - vector3Size.z / 2
        val z2 = vector3Position.y - vector3Size.y / 2

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