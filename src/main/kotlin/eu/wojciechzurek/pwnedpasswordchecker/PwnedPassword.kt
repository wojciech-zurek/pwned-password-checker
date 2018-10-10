package eu.wojciechzurek.passwordchecker

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*
import javax.validation.constraints.NotBlank

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "pwned_passwords")
data class PwnedPassword(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long?,
        @NotBlank
        val prefix: String,
        @NotBlank
        val suffix: String,
        val count: Long
)