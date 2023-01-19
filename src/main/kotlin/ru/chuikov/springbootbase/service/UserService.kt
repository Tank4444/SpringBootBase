package ru.chuikov.springbootbase.service

import org.springframework.beans.factory.annotation.Autowired
import ru.chuikov.springbootbase.entity.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import ru.chuikov.springbootbase.repository.UserRepository
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) :UserDetailsService,BasicService<User> {

    override fun loadUserByUsername(username: String?): User {
        if (username == null) throw Exception("username is null")
        return userRepository.findByUsername(username) ?: throw Exception("User with username $username not found")
    }
    override fun findById(id: Int): Optional<User> = userRepository.findById(id)
    

    override fun deleteById(id: Int) = userRepository.deleteById(id)

    override fun modify(t: User) {
        userRepository.saveAndFlush(t)
    }

    override fun add(add: User) {
        userRepository.saveAndFlush(add)
    }
}