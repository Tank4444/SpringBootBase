package ru.chuikov.springbootbase.config

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

object MyPasswordEncoder {
    private val encoder= BCryptPasswordEncoder()
    fun getPasswordEncoder():PasswordEncoder = encoder
}