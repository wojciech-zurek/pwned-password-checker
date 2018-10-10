package eu.wojciechzurek.passwordchecker

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import java.util.stream.Collectors
import java.util.stream.Stream
import kotlin.streams.toList

@Service
class PwnedPasswordServiceImpl(
        private val pwnedPasswordRepository: PwnedPasswordRepository
) : PwnedPasswordService {

    @Transactional(readOnly = true)
    private fun findByPrefix(prefix: String) = pwnedPasswordRepository.findByPrefix(prefix)

    @Transactional(readOnly = true)
    override fun findByPrefixStream(prefix: String): Stream<PwnedPasswordResponse> =
            findByPrefix(prefix).map { PwnedPasswordResponse.from(it) }

    @Transactional(readOnly = true)
    override fun findByPrefixAsText(prefix: String): String =
            findByPrefix(prefix)
                    .map { "${it.suffix}, ${it.count}" }
                    .collect(Collectors.joining("\n"))

    @Transactional(readOnly = true)
    override fun findByPrefixAsTextStream(prefix: String) =
            Flux.fromStream(findByPrefix(prefix).map { "${it.suffix}, ${it.count}" })

    fun findByPrefixAsList(prefix: String) =
            findByPrefix(prefix).map { PwnedPasswordResponse.from(it) }.toList()

    @Transactional(readOnly = true)
    override fun findByPrefixAsFlux(prefix: String) =
            Flux.fromStream(findByPrefix(prefix).map { PwnedPasswordResponse.from(it) })
}