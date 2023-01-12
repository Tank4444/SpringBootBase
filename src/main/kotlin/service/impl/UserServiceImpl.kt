package service.impl

import entity.Role
import entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.RoleRepository
import repository.UserRepository
import service.UserService

@Service
class UserServiceImpl(
    @Autowired
    val userRepository: UserRepository,
    @Autowired
    val roleRepository: RoleRepository
) :UserService {

    override fun loadUserByUsername(username: String?): User {
        return User()
    }
}