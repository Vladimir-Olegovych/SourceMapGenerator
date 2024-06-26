package org.example

import org.example.models.settings.*
import org.example.models.world.World
import org.example.tools.IdGenerator
import org.example.tools.SequenceIdGenerator


class Generator {

    private val generator: IdGenerator = SequenceIdGenerator()

    private val stringBuilder = StringBuilder()
    private var world = World(generator)

    fun generateWorld(): String {
        try {
            stringBuilder.append(VersionInfo().getContainer())
            stringBuilder.append(VisibleGroups().getContainer())
            stringBuilder.append(ViewSettings().getContainer())
            stringBuilder.append(world.getContainer())
            world.entityArrayList.forEach { stringBuilder.append(it.getContainer()) }
            stringBuilder.append(Cameras().getContainer())
            stringBuilder.append(Cordon().getContainer())
            return stringBuilder.toString()
        }finally {
            stringBuilder.clear()
        }
    }

    fun getWorld(): World = world

    fun clear() {
        world.clearContainer()
        world.entityArrayList.clear()
    }

}