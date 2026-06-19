package hu.bme.sch.kirdev.targyreviewpodecho.review

import org.springframework.stereotype.Component

@Component
class ReviewMapper {

    fun toDto(entity: Review): ReviewDto = ReviewDto(
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

    fun toEntity(dto: ReviewDto): Review = Review(
        id = dto.id,
        comment = dto.comment,
        targetType = dto.targetType,
        targetId = dto.targetId,
        overallRating = dto.overallRating,
        difficultyRating = dto.difficultyRating,
        usefulnessRating = dto.usefulnessRating,
        teachingRating = dto.teachingRating,
        posterId = dto.posterId,
        anonymous = dto.anonymous,
    )

    fun updateEntityFromDto(entity: Review, dto: ReviewDto) {
        entity.comment = dto.comment
        entity.overallRating = dto.overallRating
        entity.difficultyRating = dto.difficultyRating
        entity.usefulnessRating = dto.usefulnessRating
        entity.teachingRating = dto.teachingRating
        entity.anonymous = dto.anonymous
    }
}