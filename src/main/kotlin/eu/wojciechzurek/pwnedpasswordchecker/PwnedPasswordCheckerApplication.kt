package eu.wojciechzurek.pwnedpasswordchecker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PwnedPasswordCheckerApplication

fun main(args: Array<String>) {
    runApplication<PwnedPasswordCheckerApplication>(*args)
}
