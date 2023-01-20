package ru.chuikov.springbootbase.service

import org.springframework.beans.factory.annotation.Autowired
import ru.chuikov.springbootbase.entity.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ru.chuikov.springbootbase.repository.UserRepository
import java.lang.IllegalArgumentException
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) :UserDetailsService,BasicService<User> {

    override fun loadUserByUsername(username: String?): User = userRepository.findOneByUsername(
        username
            ?: throw IllegalArgumentException("Argument not found"))
                ?: throw UsernameNotFoundException("user with username $username not found")
    override fun findById(id: Int): Optional<User> = userRepository.findById(id)
    

    override fun deleteById(id: Int) = userRepository.deleteById(id)

    override fun modify(t: User) {

        userRepository.saveAndFlush(t)
    }

    override fun add(add: User) {
        add.password = passwordEncoder.encode(add.password)
        userRepository.saveAndFlush(add)
    }
}