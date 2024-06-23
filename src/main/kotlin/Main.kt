package org.example

import java.io.File

fun main() {
    val generator = Generator(2141)
    val world = generator.generateWorld()
    try {
        println(world)
        File("maps/output1.vmf").bufferedWriter().use { out ->
            out.write(world)
        }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}