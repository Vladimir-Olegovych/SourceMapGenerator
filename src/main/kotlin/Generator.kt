package org.example

import org.example.models.settings.*
import org.example.models.world.Entity
import org.example.models.world.Solid
import org.example.models.world.World
import org.example.tools.IdGenerator
import org.example.tools.Room
import org.example.tools.SequenceIdGenerator
import org.example.tools.Vector3


class Generator {

    private val generator: IdGenerator = SequenceIdGenerator()
    private val stringBuilder = StringBuilder()

    private val entityArrayList = ArrayList<Entity>()
    private var world = World(generator)

    fun generateWorld(): String {
        try {
            stringBuilder.append(VersionInfo().getContainer())
            stringBuilder.append(VisibleGroups().getContainer())
            stringBuilder.append(ViewSettings().getContainer())
            stringBuilder.append(world.getContainer())
            entityArrayList.forEach { stringBuilder.append(it.getContainer()) }
            stringBuilder.append(Cameras().getContainer())
            stringBuilder.append(Cordon().getContainer())
            return stringBuilder.toString()
        }finally {
            stringBuilder.clear()
        }
    }

    fun addRoom(room: Room, position: Vector3){
        room.getRoomSolid(position).forEach {
            world.add(it)
        }
        room.getRoomEntity(position).forEach {
            entityArrayList.add(it)
        }
    }

    fun addBlock(vector3Position: Vector3,
                 vector3Size: Vector3,
                 material: String = "tools/toolsnodraw"){
        val solid = Solid()
        solid.set(vector3Position, vector3Size, material)
        world.add(solid)
    }

    fun addEntity(vector3Position: Vector3, className: String){
        val entity = Entity(className)
        entity.set(vector3Position)
        entityArrayList.add(entity)
    }

    fun clear() {
        world.clear()
        entityArrayList.clear()
    }

}