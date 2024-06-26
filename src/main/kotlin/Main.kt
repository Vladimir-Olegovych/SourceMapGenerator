package org.example


import org.example.models.rooms.RoomTest
import org.example.tools.Vector3
import java.io.File

fun main() {
    val generator = Generator()
    val room = RoomTest()

    val world = generator.getWorld()

    for (y in -4 until 4) {
        for (x in -4 until 4) {
            for (z in -4 until 4) {
                world.add(room, Vector3(x * room.side, y * room.side, z * room.side))
            }
        }
    }
    val generatedWorld = generator.generateWorld()

    try {
        println(generatedWorld)
        File("maps/output.vmf").bufferedWriter().use { out ->
            out.write(generatedWorld)
        }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}