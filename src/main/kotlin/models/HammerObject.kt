package org.example.models

open class HammerObject(
    private val name: String
) {
    private val properties = HashMap<String, String>()
    private val container = ArrayList<HammerObject>()


    fun put(key: String, value: String) {
        properties[key] = value
    }

    fun addContainer(hammerObject: HammerObject) {
        container.add(hammerObject)
    }

    fun clearContainer() {
        container.clear()
    }

    private val stringBuilder = StringBuilder()
    fun getContainer(): String {
        try {
            stringBuilder.append(name).append("{")
            stringBuilder.append(getPropertiesString(properties))
            getHammerObjectContainer(this)
            stringBuilder.append("\n}\n")
            return stringBuilder.toString()
        } finally {
            stringBuilder.clear()
        }
    }
    private fun getHammerObjectContainer(hammerObject: HammerObject) {
        for (containerHammerObject in hammerObject.container) {
            stringBuilder.append(containerHammerObject.name).append("{")
            stringBuilder.append(getPropertiesString(containerHammerObject.properties))
            if (containerHammerObject.container.size != 0) getHammerObjectContainer(containerHammerObject)
            stringBuilder.append("\n}\n")
        }
    }

    private fun getPropertiesString(properties: HashMap<String, String>): String {
        val stringBuilder = StringBuilder()
        properties.forEach { (key, value) -> stringBuilder.append("\n\"$key\" ").append("\"$value\"") }
        return stringBuilder.toString()

    }
}