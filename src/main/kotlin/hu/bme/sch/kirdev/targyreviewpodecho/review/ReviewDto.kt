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
) {
    constructor(entity: Review) : this(
        id = entity.id,
        comment = entity.comment,
        targetType = entity.targetType,
        targetId = entity.targetId,
        overallRating = entity.overallRating,
        difficultyRating = entity.difficultyRating,
        usefulnessRating = entity.usefulnessRating,
        teachingRating = entity.teachingRating,
        posterId = if(entity.anonymous) null else entity.posterId,
        anonymous = entity.anonymous,
    )
}