package eu.wojciechzurek.pwnedpasswordchecker

import org.springframework.data.jpa.repository.JpaRepository

interface PwnedPasswordRepository : JpaRepository<PwnedPassword, Long> {

    fun findByPrefix(prefix: String): List<PwnedPassword>
}