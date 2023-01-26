package ru.chuikov.springbootbase.repository

import ru.chuikov.springbootbase.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RoleRepository:JpaRepository<Role,Int> {


    fun getByUsers_Roles_Name(name: String): Optional<Role>
}