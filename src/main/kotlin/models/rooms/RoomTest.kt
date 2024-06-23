package org.example.models.rooms

import org.example.models.world.Entity
import org.example.models.world.Solid
import org.example.tools.Room
import org.example.tools.Vector3

class RoomTest : Room {

    override fun getRoomSolid(position: Vector3): List<Solid> {
        return emptyList()
    }

    override fun getRoomEntity(position: Vector3): List<Entity> {
        return emptyList()
    }
}