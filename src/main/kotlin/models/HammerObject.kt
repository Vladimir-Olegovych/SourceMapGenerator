package org.example.models

import org.example.models.world.Solid
import org.example.models.world.World

open class HammerObject(
    val name: String
) {
    val properties = HashMap<String, String>()
    val container = ArrayList<HammerObject>()

    fun put(key: String, value: String) {
        properties[key] = value
    }

    fun addForContainer(solid: Solid) {
        container.add(solid)
    }

    fun getPropertiesString(properties: HashMap<String, String>): String {
        val stringBuilder = StringBuilder()
        properties.forEach { (key, value) ->
            stringBuilder.append("\"$key\" ").append("\"$value\"\n")
        }
        return stringBuilder.toString()
    }

    fun getContainer(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append(name).append("{")
        stringBuilder.append(getPropertiesString(properties))
        when(this) {
            is World -> stringBuilder.append(getWorldContainer())
            is Solid -> stringBuilder.append(getSolidContainer())
        }

        stringBuilder.append("}")
        return stringBuilder.toString()
    }

}