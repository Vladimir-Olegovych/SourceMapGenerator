package org.example.models.world

import org.example.models.HammerObject
import org.example.tools.IdGenerator
import org.example.tools.SequenceIdGenerator

class World(private val generator: IdGenerator = SequenceIdGenerator()): HammerObject("world") {
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
        super.addForContainer(solid)
    }

    fun getWorldContainer(): String {
        val stringBuilder = StringBuilder()
        for (containerHammerObject in container) {
            stringBuilder.append(containerHammerObject.name).append("{")
            stringBuilder.append(getPropertiesString(containerHammerObject.properties))
            when(containerHammerObject) {
                is Solid -> {
                    for(side in containerHammerObject.sides){
                        stringBuilder.append(side.name).append("{")
                        stringBuilder.append(getPropertiesString(side.properties))
                        stringBuilder.append("}\n")
                    }
                    stringBuilder.append(containerHammerObject.editor.name).append("{")
                    stringBuilder.append(getPropertiesString(containerHammerObject.editor.properties))
                    stringBuilder.append("}\n")
                }
            }
            stringBuilder.append("}\n")
        }
        return stringBuilder.toString()
    }
}