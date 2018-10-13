package eu.wojciechzurek.pwnedpasswordchecker

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "pwned_passwords", indexes = [Index(columnList = "prefix")])
data class PwnedPassword(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long?,
        @NotBlank
        val prefix: String,
        @NotBlank
        val suffix: String,
        @NotNull
        val count: Long
)