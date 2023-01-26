package ru.chuikov.springbootbase.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor
import org.hibernate.Hibernate
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "account")
class User:UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Int = 0

    @get:JvmName("getName")
    var username:String = ""

    var email:String = ""

    @get:JvmName("getPass")
    var password:String = ""

    @ManyToMany(cascade = [CascadeType.REFRESH])
    @JoinTable(
        name = "user_role",
        joinColumns = [JoinColumn(
            name = "role_id",
            referencedColumnName = "id"
        )],
        inverseJoinColumns = [JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
        )]
    )
    @JsonIgnoreProperties("users")
    var roles: MutableList<Role> = mutableListOf()

    var confirmed:Boolean = false
    private val isEnabled: Boolean = true
    private val isCredentialsNonExpired: Boolean = true
    private val isAccountNonExpired: Boolean = true
    private val isAccountNonLocked: Boolean = true

    @Transient
    private val rolePrefix = "ROLE_"

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val list = ArrayList<GrantedAuthority>()

        for (role in roles) {
            list.add(SimpleGrantedAuthority(rolePrefix + role.name))
        }

        return list
    }

    override fun getPassword(): String  = password

    override fun getUsername(): String = username


    override fun isAccountNonExpired(): Boolean = isAccountNonExpired

    override fun isAccountNonLocked(): Boolean = isAccountNonLocked

    override fun isCredentialsNonExpired(): Boolean = isCredentialsNonExpired

    override fun isEnabled(): Boolean = isEnabled

}