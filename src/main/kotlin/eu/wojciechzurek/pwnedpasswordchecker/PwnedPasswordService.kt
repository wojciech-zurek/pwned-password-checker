package eu.wojciechzurek.passwordchecker

import reactor.core.publisher.Flux
import java.util.stream.Stream

interface PwnedPasswordService {

    fun findByPrefixStream(prefix: String): Stream<PwnedPasswordResponse>
    fun findByPrefixAsText(prefix: String): String
    fun findByPrefixAsTextStream(prefix: String): Flux<String>
    fun findByPrefixAsFlux(prefix: String): Flux<PwnedPasswordResponse>
}