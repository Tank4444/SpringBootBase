package ru.chuikov.springbootbase.service

import ru.chuikov.springbootbase.entity.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import ru.chuikov.springbootbase.repository.UserRepository
import java.util.*

@Service
class UserService(
    val userRepository: UserRepository,
) :UserDetailsService,BasicService<User> {

    override fun loadUserByUsername(username: String?): User {
        if (username == null) throw Exception("username is null")
        return userRepository.findByUsername(username) ?: throw Exception("User with username $username not found")
    }
    override fun findById(id: Int): Optional<User> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun modify(t: User) {
        TODO("Not yet implemented")
    }

    override fun add(add: User) {
        TODO("Not yet implemented")
    }
}