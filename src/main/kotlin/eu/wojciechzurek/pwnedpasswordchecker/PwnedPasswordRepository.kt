package eu.wojciechzurek.passwordchecker

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Stream

interface PwnedPasswordRepository : JpaRepository<PwnedPassword, Long> {

    @Transactional(readOnly = true)
    fun findByPrefix(prefix: String): Stream<PwnedPassword>
}