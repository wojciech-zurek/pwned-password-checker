package eu.wojciechzurek.pwnedpasswordchecker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class PwnedPasswordCheckerApplication

fun main(args: Array<String>) {
    runApplication<PwnedPasswordCheckerApplication>(*args)
}
