package hu.bme.sch.kirdev.targyreviewpodecho.teacher

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "teacher")
class TeacherEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var name: String = ""

    /*subjectEntity needed to be merged
    @ManyToOne
    var subject: SubjectEntity? = null*/
)