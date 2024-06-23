package org.example.tools

import org.example.models.world.Entity
import org.example.models.world.Solid

interface Room {
    fun getRoomSolid(position: Vector3): List<Solid>
    fun getRoomEntity(position: Vector3): List<Entity>
}