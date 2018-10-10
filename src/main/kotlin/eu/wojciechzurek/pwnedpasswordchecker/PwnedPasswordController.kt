package eu.wojciechzurek.passwordchecker

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
    fun text(@PathVariable("prefix") prefix: String) =
            pwnedPasswordService.findByPrefixAsText(prefix.toUpperCase())

    @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun textStream(@PathVariable("prefix") prefix: String) =
            pwnedPasswordService.findByPrefixAsTextStream(prefix.toUpperCase())

    @GetMapping(produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun json(@PathVariable("prefix") prefix: String) =
            pwnedPasswordService.findByPrefixStream(prefix.toUpperCase())

    @GetMapping(produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun streamJson(@PathVariable("prefix") prefix: String) =
            pwnedPasswordService.findByPrefixAsFlux(prefix.toUpperCase())
}