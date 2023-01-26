package ru.chuikov.springbootbase.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {
    @RequestMapping(value = ["/public"], method = [(RequestMethod.GET)])
    fun getPublicOK(): ResponseEntity<Any> =
        ResponseEntity.ok(mapOf("Status" to "OK"))

    @RequestMapping(value = ["/private"], method = [(RequestMethod.GET)])
    fun getPrivateOk(): ResponseEntity<Any> =
        ResponseEntity.ok(mapOf("Status" to "OK"))
}
