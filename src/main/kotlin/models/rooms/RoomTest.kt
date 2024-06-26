package org.example.models.rooms

import org.example.Materials
import org.example.models.world.Entity
import org.example.models.world.Solid
import org.example.models.world.World
import org.example.tools.Entities
import org.example.tools.Room
import org.example.tools.Vector3
import kotlin.random.Random

class RoomTest : Room {

    private val random = Random(12425)
    private val size = 64 * 4
    val side = size * 3

    override fun setVector(world: World, vector3: Vector3) {
        val array = arrayListOf(
            Solid().apply { set(Vector3(0, size, 0) + vector3,  Vector3(size , size, size), Materials.BLOCK) },
            Solid().apply { set(Vector3(0, -size, 0) + vector3, Vector3(size, size, size), Materials.BLOCK) },
        )
        val int = random.nextInt(-50, 50)
        if (int >= 0) {
            array.add(Solid().apply { set(Vector3(size, 0, 0) + vector3,  Vector3(size, side, side), Materials.BLOCK) })
            array.add(Solid().apply { set(Vector3(-size, 0, 0) + vector3, Vector3(size, side, side), Materials.BLOCK) })
        } else if (int in -25..25) {
            array.add(Solid().apply { set(Vector3(-size, 0, 0) + vector3, Vector3(size, side, side), Materials.BLOCK) })
            array.add(Solid().apply { set(Vector3(0, 0, -size) + vector3, Vector3(side, side, size), Materials.BLOCK) })
        } else {
            array.add(Solid().apply { set(Vector3(0, 0, size) + vector3,  Vector3(side, side, size), Materials.BLOCK) })
        }
        array.forEach {
            world.add(Entity(Entities.PLAYER).apply { set(Vector3(0, 0, 0) + vector3) })
            world.add(it)
        }
    }


}