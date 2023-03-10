package ru.chuikov.springbootbase.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore
import ru.chuikov.springbootbase.service.UserService
import javax.sql.DataSource

@Configuration
@EnableAuthorizationServer
class AuthServerConfig():AuthorizationServerConfigurerAdapter() {
    @Autowired
    lateinit var passwordEncoder: BCryptPasswordEncoder

    @Autowired
    lateinit var authenticationManager:AuthenticationManager

    @Autowired
    lateinit var dataSource: DataSource

    @Autowired
    lateinit var userService: UserService

    @Bean
    fun tokenStore():TokenStore = InMemoryTokenStore()

    override fun configure(security: AuthorizationServerSecurityConfigurer) {
        security.checkTokenAccess("isAuthenticated()")
    }

    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients.jdbc(dataSource).withClient("client")
            .secret(passwordEncoder.encode("secret"))
            .authorizedGrantTypes("refresh_token", "password", "client_credentials",)
            .scopes("user_info")
            .autoApprove(true)
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints.tokenStore(tokenStore())
            .userDetailsService(userService)
            .authenticationManager(authenticationManager)
    }
}