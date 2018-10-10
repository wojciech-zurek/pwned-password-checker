package eu.wojciechzurek.pwnedpasswordchecker

data class PwnedPasswordResponse (
        val suffix: String,
        val count: Long
){
    companion object {
        fun from(pwnedPassword: PwnedPassword) = PwnedPasswordResponse(pwnedPassword.suffix, pwnedPassword.count)
    }
}