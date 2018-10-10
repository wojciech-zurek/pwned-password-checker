package eu.wojciechzurek.passwordchecker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("eu.wojciechzurek.passwordchecker")
class PasswordCheckerApplication

fun main(args: Array<String>) {
    runApplication<PasswordCheckerApplication>(*args)
}
