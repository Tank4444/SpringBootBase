package ru.chuikov.springbootbase.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import ru.chuikov.springbootbase.entity.Role
import ru.chuikov.springbootbase.entity.User
import ru.chuikov.springbootbase.service.RoleService
import ru.chuikov.springbootbase.service.UserService
import java.util.*


@SpringBootApplication
@ComponentScan("ru.chuikov.config",)
open class Initializer(
    private val userService: UserService,
    private val passwordEncoder: BCryptPasswordEncoder,
    private val roleService:RoleService,
):ApplicationRunner {


    override fun run(args: ApplicationArguments?) {
        roleService.add(Role(1,"ADMIN", listOf()))

        userService.add(User(
            id = 0,
            username = "admin",
            email = "admin@mail.ru",
            password = passwordEncoder.encode("admin"),
            roles = listOf(roleService.findById(1).orElse(null))
        ))
    }
}
