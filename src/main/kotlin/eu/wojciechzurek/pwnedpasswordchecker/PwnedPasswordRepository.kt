package eu.wojciechzurek.pwnedpasswordchecker

import org.springframework.data.jpa.repository.JpaRepository
import java.util.stream.Stream

interface PwnedPasswordRepository : JpaRepository<PwnedPassword, Long> {

    fun findByPrefix(prefix: String): Stream<PwnedPassword>
}