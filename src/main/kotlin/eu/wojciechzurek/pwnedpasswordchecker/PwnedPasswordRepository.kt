package eu.wojciechzurek.pwnedpasswordchecker

import java.util.stream.Stream

interface PwnedPasswordRepository {

    fun findByPrefix(prefix: Int): Stream<PwnedPassword>
}