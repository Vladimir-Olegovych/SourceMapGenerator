package org.example.models.world

import org.example.models.HammerObject
import org.example.tools.IdGenerator
import org.example.tools.Room
import org.example.tools.SequenceIdGenerator
import org.example.tools.Vector3

class World(private val generator: IdGenerator = SequenceIdGenerator()): HammerObject("world") {

    val entityArrayList = ArrayList<Entity>()

    init {
        put("id", generator.next().toString())
        put("mapversion", "11")
        put("classname", "worldspawn")
        put("detailmaterial", "detail/detailsprites")
        put("detailvbsp", "detail.vbsp")
        put("maxpropscreenwidth", "-1")
        put("skyname", "sky_day01_05")
    }

    fun add(solid: Solid) {
        solid.put("id", generator.next().toString())
        solid.sides.forEach { it.put("id", generator.next().toString()) }
        solid.sides.forEach { solid.addContainer(it) }
        solid.addContainer(solid.editor)
        super.addContainer(solid)
    }

    fun add(entity: Entity) {
        entity.put("id", generator.next().toString())
        entity.addContainer(entity.editor)
        entityArrayList.add(entity)
    }

    fun add(room: Room, vector3: Vector3){
        room.setVector(this, vector3)
    }

    fun clearWorld(){
        entityArrayList.clear()
        generator.clear(0)
    }
}