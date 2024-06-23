package org.example.tools

class SequenceIdGenerator: IdGenerator {

    private var id = 0
    override fun next() = id++
    override fun clear(int: Int) { id = int }

}