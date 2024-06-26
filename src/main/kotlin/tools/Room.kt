package org.example.tools

import org.example.models.world.World

interface Room {
    fun setVector(world: World, vector3: Vector3)
}