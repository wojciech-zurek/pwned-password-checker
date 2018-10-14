package eu.wojciechzurek.pwnedpasswordchecker

import reactor.core.publisher.Flux
import java.util.stream.Stream

interface PwnedPasswordService {

    fun findByPrefix(prefix: Int): Stream<PwnedPassword>
    fun findByPrefixStream(prefix: Int): Stream<PwnedPasswordResponse>
    fun findByPrefixAsText(prefix: Int): String
    fun findByPrefixAsTextStream(prefix: Int): Flux<String>
    fun findByPrefixAsFlux(prefix: Int): Flux<PwnedPasswordResponse>
}