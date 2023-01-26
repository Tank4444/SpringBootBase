package ru.chuikov.springbootbase.service

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.chuikov.springbootbase.entity.Role
import ru.chuikov.springbootbase.repository.RoleRepository
import java.util.*

@Service
class RoleService:BasicService<Role> {
    @Autowired
    lateinit var roleRepository: RoleRepository

    override fun findById(id: Int): Optional<Role>  = roleRepository.findById(id)

    override fun deleteById(id: Int) {
        roleRepository.deleteById(id)
    }

    override fun modify(t: Role) {
        roleRepository.saveAndFlush(t)
    }

    override fun add(add: Role) {
        roleRepository.saveAndFlush(add)
    }

    @PostConstruct
    private fun onStart(){
        //roleRepository.saveAndFlush()
    }
}