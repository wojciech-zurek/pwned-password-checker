package eu.wojciechzurek.pwnedpasswordchecker

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.stream.Collectors
import java.util.stream.Stream
import kotlin.streams.toList

const val DELIMITER = ":"

@Service
class PwnedPasswordServiceImpl(
        private val pwnedPasswordRepository: PwnedPasswordRepository
) : PwnedPasswordService {

    override fun findByPrefix(prefix: String) = pwnedPasswordRepository.findByPrefix(prefix)

    override fun findByPrefixStream(prefix: String): Stream<PwnedPasswordResponse> =
            findByPrefix(prefix).map { PwnedPasswordResponse.from(it) }

    override fun findByPrefixAsText(prefix: String): String =
            findByPrefix(prefix)
                    .map { "${it.suffix}$DELIMITER${it.count}" }
                    .collect(Collectors.joining("\n"))

    override fun findByPrefixAsTextStream(prefix: String) =
            Flux.fromStream(findByPrefix(prefix).map { "${it.suffix}$DELIMITER${it.count}" })

    fun findByPrefixAsList(prefix: String) =
            findByPrefix(prefix).map { PwnedPasswordResponse.from(it) }.toList()

    override fun findByPrefixAsFlux(prefix: String) =
            Flux.fromStream(findByPrefix(prefix).map { PwnedPasswordResponse.from(it) })
}