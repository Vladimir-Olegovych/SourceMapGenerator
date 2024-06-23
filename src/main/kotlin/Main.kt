package org.example

import org.example.tools.Entities
import org.example.tools.Vector3
import java.io.File

fun main() {
    val generator = Generator()
    //val room = RoomTest()

    generator.addBlock(Vector3(0, 0, 0), Vector3(500, 64,  500), Materials.CONCRETE)
    generator.addEntity(Vector3(0, 20, 0), Entities.PLAYER)


    val world = generator.generateWorld()
    try {
        println(world)
        File("maps/output.vmf").bufferedWriter().use { out ->
            out.write(world)
        }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}