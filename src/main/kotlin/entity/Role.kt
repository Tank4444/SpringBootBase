package entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table
class Role(
    @Id
    var id:Int,
    var name:String,
    @ManyToMany(mappedBy = "user")
    @JsonIgnoreProperties("roles")
    var users:List<User>
)