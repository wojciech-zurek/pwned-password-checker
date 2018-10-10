package eu.wojciechzurek.pwnedpasswordchecker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("eu.wojciechzurek.pwnedpasswordchecker")
class PwnedPasswordCheckerApplication

fun main(args: Array<String>) {
    runApplication<PwnedPasswordCheckerApplication>(*args)
}
