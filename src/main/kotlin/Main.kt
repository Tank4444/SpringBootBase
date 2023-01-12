import config.Initializer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.nio.file.Paths

fun main(args: Array<String>) {
    runApplication<Initializer>(*args)
}