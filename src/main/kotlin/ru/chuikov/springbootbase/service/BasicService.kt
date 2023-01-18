package ru.chuikov.springbootbase.service

import java.util.Optional

interface BasicService<T> {
    fun findById(id:Int):Optional<T>

    fun add(add:T)

    fun deleteById(id:Int)

    fun modify(t:T)
}