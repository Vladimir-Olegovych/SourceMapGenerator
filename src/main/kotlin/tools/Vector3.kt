package org.example.tools

data class Vector3(var x: Int,
                   var y: Int,
                   var z: Int){

    operator fun plus(vector3: Vector3): Vector3 {
        return Vector3(x + vector3.x, y + vector3.y, z + vector3.z)
    }

    companion object {
        fun getSized(size: Int): Vector3 = Vector3(size, size, size)
    }
}