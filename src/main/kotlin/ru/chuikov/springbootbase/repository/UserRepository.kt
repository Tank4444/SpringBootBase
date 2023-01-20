package ru.chuikov.springbootbase.repository

import ru.chuikov.springbootbase.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:JpaRepository<User,Int> {

    @Query("SELECT U FROM USER U where u.username = :name")
    fun findOneByUsername(@Param("name") username:String): User?
}