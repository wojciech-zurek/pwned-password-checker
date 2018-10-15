package eu.wojciechzurek.pwnedpasswordchecker

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/range/{prefix}")
class PwnedPasswordController(
        private val pwnedPasswordService: PwnedPasswordService
) {

    @GetMapping(produces = [MediaType.TEXT_PLAIN_VALUE])
    fun findByPrefixAsText(@PathVariable("prefix") prefix: String) =
            pwnedPasswordService.findByPrefixAsText(prefix.toInt(radix = 16))

    @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun findByPrefixAsTextStream(@PathVariable("prefix") prefix: String) =
            pwnedPasswordService.findByPrefixAsTextStream(prefix.toInt(radix = 16))

    @GetMapping(produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun findByPrefixStream(@PathVariable("prefix") prefix: String) =
            pwnedPasswordService.findByPrefixAsStream(prefix.toInt(radix = 16))

    @GetMapping(produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun findByPrefixAsFlux(@PathVariable("prefix") prefix: String) =
            pwnedPasswordService.findByPrefixAsFlux(prefix.toInt(radix = 16))

    @ExceptionHandler(NumberFormatException::class)
    fun handleNumberFormatException(): ResponseEntity<Mono<Error>> {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON_UTF8
        return ResponseEntity(Mono.just(Error("Use proper prefix!")), headers, HttpStatus.BAD_REQUEST)
    }

    data class Error(val message: String)

}