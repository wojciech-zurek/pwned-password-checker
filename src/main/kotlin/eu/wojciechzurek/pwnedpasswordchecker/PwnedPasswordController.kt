package eu.wojciechzurek.pwnedpasswordchecker

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/password/{prefix}")
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
            pwnedPasswordService.findByPrefixStream(prefix.toInt(radix = 16))

    @GetMapping(produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun findByPrefixAsFlux(@PathVariable("prefix") prefix: String) =
            pwnedPasswordService.findByPrefixAsFlux(prefix.toInt(radix = 16))
}