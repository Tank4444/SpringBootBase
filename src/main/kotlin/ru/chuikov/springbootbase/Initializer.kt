package ru.chuikov.springbootbase

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import ru.chuikov.springbootbase.entity.Role
import ru.chuikov.springbootbase.entity.User
import ru.chuikov.springbootbase.service.RoleService
import ru.chuikov.springbootbase.service.UserService


@SpringBootApplication
@ComponentScan("ru.chuikov.config","ru.chuikov.springbootbase.service","ru.chuikov.springbootbase.repository")
open class Initializer


fun main(args: Array<String>) {
    runApplication<Initializer>(*args)
}
