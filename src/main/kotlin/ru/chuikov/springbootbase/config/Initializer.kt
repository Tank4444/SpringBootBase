package ru.chuikov.springbootbase.config

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.crypto.password.PasswordEncoder
import ru.chuikov.springbootbase.entity.User
import ru.chuikov.springbootbase.service.UserService
import java.util.*


@SpringBootApplication
@ComponentScan("ru.chuikov.config",)
open class Initializer(
    var passwordEncoder: PasswordEncoder,
    var userService: UserService
):ApplicationRunner {


    override fun run(args: ApplicationArguments?) {
    userService.add(

    )
    }
}
