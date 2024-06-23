package org.example.tools

interface IdGenerator {
    fun next(): Int
    fun clear(int: Int)
}