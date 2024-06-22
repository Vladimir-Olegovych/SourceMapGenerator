package org.example

import org.example.Materials.BLOCK
import org.example.models.settings.*
import org.example.models.world.Solid
import org.example.models.world.World
import org.example.tools.IdGenerator
import org.example.tools.SequenceIdGenerator
import org.example.tools.Vector3
import kotlin.random.Random


class Generator(seed: Int) {

    private val generator: IdGenerator = SequenceIdGenerator()
    private val random = Random(seed)

    fun generateWorld(): String {
        val stringBuilder = StringBuilder()
        val world = World(generator)

        val x = 0
        val y = 0
        val z = 0


        val solid = Solid()
        solid.set(Vector3(x, y, z), 32, 32, 32, BLOCK)
        world.add(solid)


        stringBuilder.append(VersionInfo().getContainer())
        stringBuilder.append(VisibleGroups().getContainer())
        stringBuilder.append(ViewSettings().getContainer())
        stringBuilder.append(world.getContainer())
        stringBuilder.append(Cameras().getContainer())
        stringBuilder.append(Cordon().getContainer())

        return stringBuilder.toString()
    }

}