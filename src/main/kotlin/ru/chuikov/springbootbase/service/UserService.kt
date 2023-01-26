package ru.chuikov.springbootbase.service

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import ru.chuikov.springbootbase.entity.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.chuikov.springbootbase.config.MyPasswordEncoder
import ru.chuikov.springbootbase.entity.Role
import ru.chuikov.springbootbase.repository.RoleRepository
import ru.chuikov.springbootbase.repository.UserRepository
import java.lang.IllegalArgumentException
import java.util.*

@Service("userDetailsService")
class UserService :UserDetailsService,BasicService<User> {
    @Autowired
    private lateinit var userRepository:UserRepository
    @Autowired
    private lateinit var roleRepository: RoleRepository

    override fun loadUserByUsername(username: String?): User =
        userRepository.findByUsername(
        username
            ?: throw IllegalArgumentException("Argument not found"))
            .orElseThrow{
                UsernameNotFoundException("user with username $username not found")
            }
    override fun findById(id: Int): Optional<User> = userRepository.findById(id)
    

    override fun deleteById(id: Int) = userRepository.deleteById(id)

    override fun modify(t: User) {

        userRepository.saveAndFlush(t)
    }

    override fun add(add: User) {
        add.password = MyPasswordEncoder.getPasswordEncoder().encode(add.password)
        userRepository.saveAndFlush(add)
    }

    @PostConstruct
    private fun postConstractInit(){
        var role = roleRepository.saveAndFlush(Role(0,"ADMIN", emptyList()))
        userRepository.saveAndFlush(User().apply {
            username = "admin"
            email = "admin@admin@admin.ru"
            password = MyPasswordEncoder.getPasswordEncoder().encode("admin")
            roles = mutableListOf(role)
        })
    }
}