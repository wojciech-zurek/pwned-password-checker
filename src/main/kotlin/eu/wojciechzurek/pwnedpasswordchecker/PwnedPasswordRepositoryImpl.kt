package eu.wojciechzurek.pwnedpasswordchecker

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.rowset.SqlRowSet
import org.springframework.stereotype.Repository
import java.util.*
import java.util.stream.Stream
import java.util.stream.StreamSupport
import java.util.NoSuchElementException


@Repository
class PwnedPasswordRepositoryImpl(private val jdbcTemplate: NamedParameterJdbcTemplate) : PwnedPasswordRepository {

    override fun findByPrefix(prefix: String): Stream<PwnedPassword> {
        return queryForStream(
                "SELECT suffix, count FROM pwned_passwords WHERE prefix = :prefix",
                { PwnedPassword(it.getString("suffix"), it.getInt("count")) },
                mapOf("prefix" to prefix))
    }

    private fun <T : Any> queryForStream(sql: String, converter: (SqlRowSet) -> T, args: Map<String, Any>): Stream<T> =
            jdbcTemplate.queryForRowSet(sql, args)
                    .let { rs -> iterator(rs, converter) }
                    .let { Spliterators.spliteratorUnknownSize(it, Spliterator.IMMUTABLE) }
                    .let { StreamSupport.stream(it, false) }

    private fun <T : Any> iterator(rowSet: SqlRowSet, converter: (SqlRowSet) -> T): Iterator<T> =
            object : Iterator<T> {
                override fun hasNext(): Boolean {
                    return !rowSet.isLast
                }

                override fun next(): T {
                    if (!rowSet.next()) {
                        throw NoSuchElementException()
                    }

                    return converter.invoke(rowSet)
                }
            }
}