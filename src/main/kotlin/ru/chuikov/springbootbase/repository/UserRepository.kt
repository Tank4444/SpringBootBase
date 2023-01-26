package ru.chuikov.springbootbase.repository

import ru.chuikov.springbootbase.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository:JpaRepository<User,Int> {


    fun findByUsername(username: String): Optional<User>
}