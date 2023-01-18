package ru.chuikov.springbootbase.repository

import ru.chuikov.springbootbase.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository:JpaRepository<Role,Int> {

    @Query("select r from Role r where r.name = :name")
    fun findRoleByName(@Param("name") name:String): Role?
}