package entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.hibernate.Hibernate
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Int,
    @get:JvmName("getName")
    var username:String,
    var email:String,
    @get:JvmName("getPass")
    var password:String,
    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
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
    var roles:List<Role>,
    var confirmed:Boolean,
    private val isEnabled: Boolean,
    private val isCredentialsNonExpired: Boolean,
    private val isAccountNonExpired: Boolean,
    private val isAccountNonLocked: Boolean,

):UserDetails{
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val result:MutableList<GrantedAuthority> = mutableListOf()
        roles.forEach{
            result.add(SimpleGrantedAuthority(it.name))
        }
        return result
    }

    override fun getPassword(): String  = password

    override fun getUsername(): String = username


    override fun isAccountNonExpired(): Boolean = isAccountNonExpired

    override fun isAccountNonLocked(): Boolean = isAccountNonLocked

    override fun isCredentialsNonExpired(): Boolean = isCredentialsNonExpired

    override fun isEnabled(): Boolean = isEnabled

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , username = $username , email = $email , password = $password )"
    }

}