package hu.bme.sch.kirdev.targyreviewpodecho.review

class CreateReviewDto(
    var comment: String = "",
    var overallRating: Int? = null,
    var difficultyRating: Int? = null,
    var usefulnessRating: Int? = null,
    var teachingRating: Int? = null,
    var posterId: Long? = null,
    var anonymous: Boolean = false,
)