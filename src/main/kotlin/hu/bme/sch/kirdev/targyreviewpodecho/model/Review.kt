package hu.bme.sch.kirdev.targyreviewpodecho.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "reviews")
class Review(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    // comment
    @Column(columnDefinition = "TEXT")
    var comment: String = "",

    // subject or lecturer
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var targetType: ReviewTargetType = ReviewTargetType.SUBJECT,

    @Column(nullable = false)
    var targetId: Long = 0,

    var overallRating: Int? = null,

    var difficultyRating: Int? = null,

    var usefulnessRating: Int? = null,

    var teachingRating: Int? = null,

    /*
     IDE MAJD BE KELL KÖTNI A USER ENTITYT, HA MÁR LESZ
     */
    var posterId: Long? = null,

    //if the poster want to stay anonymous
    @Column(nullable = false)
    var anonymous: Boolean = false,
)