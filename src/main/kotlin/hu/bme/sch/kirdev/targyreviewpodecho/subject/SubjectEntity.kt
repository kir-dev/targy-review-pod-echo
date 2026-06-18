package hu.bme.sch.kirdev.targyreviewpodecho.subject

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "subject")
class SubjectEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @NotBlank
    var name: String = "",

    @Column(nullable = false)
    var semester: Int = 0,

    @Enumerated(EnumType.STRING)
    var major: MajorType = MajorType.MERNOK_INFO,

    @Column(unique = true, nullable = false)
    var bmeId: String = "",

    @Column(columnDefinition = "TEXT")
    var description: String = ""
)

enum class MajorType{
    MERNOK_INFO,
    VILLAMOS_MERNOK
}