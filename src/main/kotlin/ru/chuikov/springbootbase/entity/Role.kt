package ru.chuikov.springbootbase.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity
@Table
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Int,
    var name:String,
    @ManyToMany
    @JsonIgnoreProperties("roles")
    var users:List<User>
)