package config

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import java.nio.file.Paths
import java.util.*


@SpringBootApplication(
    //exclude = [SecurityAutoConfiguration::class]
)
open class Initializer:ApplicationRunner {


    override fun run(args: ApplicationArguments?) {

    }
}
