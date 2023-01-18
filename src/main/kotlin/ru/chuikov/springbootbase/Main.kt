package ru.chuikov.springbootbase

import ru.chuikov.springbootbase.config.Initializer
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
    runApplication<Initializer>(*args)
}