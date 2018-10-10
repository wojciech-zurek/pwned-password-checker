package eu.wojciechzurek.pwnedpasswordchecker

import reactor.core.publisher.Flux
import java.util.stream.Stream

interface PwnedPasswordService {

    fun findByPrefix(prefix: String): Stream<PwnedPassword>
    fun findByPrefixStream(prefix: String): Stream<PwnedPasswordResponse>
    fun findByPrefixAsText(prefix: String): String
    fun findByPrefixAsTextStream(prefix: String): Flux<String>
    fun findByPrefixAsFlux(prefix: String): Flux<PwnedPasswordResponse>
}