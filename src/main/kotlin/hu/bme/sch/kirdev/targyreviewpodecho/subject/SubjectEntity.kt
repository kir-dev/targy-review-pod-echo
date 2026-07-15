package hu.bme.sch.kirdev.targyreviewpodecho.subject

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

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

    @NotNull
    @Enumerated(EnumType.STRING)
    var major: MajorType? = null,

    @Column(unique = true, nullable = false)
    var bmeId: String = "",

    @Column(columnDefinition = "TEXT")
    var description: String = ""
)