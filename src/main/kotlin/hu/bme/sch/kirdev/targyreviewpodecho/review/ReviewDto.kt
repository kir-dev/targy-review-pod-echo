package hu.bme.sch.kirdev.targyreviewpodecho.review

data class ReviewDto(
    var id: Long? = null,
    var comment: String = "",
    var targetType: ReviewTargetType = ReviewTargetType.SUBJECT,
    var targetId: Long = 0,
    var overallRating: Int? = null,
    var difficultyRating: Int? = null,
    var usefulnessRating: Int? = null,
    var teachingRating: Int? = null,
    var posterId: Long? = null,
    var anonymous: Boolean = false,
)