package hu.bme.sch.kirdev.targyreviewpodecho.review

import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class ReviewService (
    private val reviewRepository: ReviewRepository,
    // TODO: inject when available
    //private val subjectRepository: SubjectRepository,
    //private val lecturerRepository: LecturerRepository,
){
    fun create(dto: CreateReviewDto, targetType: ReviewTargetType, targetId: Long): ReviewDto {

        if(!validateTargetExists(targetType, targetId)){
            throw EntityNotFoundException("Target type $targetType with id $targetId not found")
        }

        val entity = Review(
            comment = dto.comment,
            targetType = targetType,
            targetId = targetId,
            overallRating = dto.overallRating,
            difficultyRating = dto.difficultyRating,
            usefulnessRating = dto.usefulnessRating,
            teachingRating = dto.teachingRating,
            posterId = dto.posterId,
            anonymous = dto.anonymous,
        )
        val saved = reviewRepository.save(entity)
        return ReviewDto(saved)
    }

    private fun validateTargetExists(targetType: ReviewTargetType,targetId: Long): Boolean {
        // TODO: implement when Subject and Lecturer repositories are available
        /*return when (targetType) {
            ReviewTargetType.SUBJECT -> subjectRepository.existsById(targetId)
            ReviewTargetType.LECTURER -> lecturerRepository.existsById(targetId)
        }*/
        return true
    }

    fun getById(id: Long): ReviewDto {
        val entity = reviewRepository.findById(id).orElseThrow { EntityNotFoundException("Review not found: $id") }
        return ReviewDto(entity)
    }

    fun getByTarget(targetType: ReviewTargetType, targetId: Long): List<ReviewDto>  =
        reviewRepository.findByTargetTypeAndTargetId(targetType, targetId)
            .map { ReviewDto(it) }

    fun getByPoster(posterId: Long): List<ReviewDto> =
            reviewRepository.findByPosterId(posterId)
            .map { ReviewDto(it) }

    fun update(id: Long, dto: ReviewDto): ReviewDto {
        val entity = reviewRepository.findById(id).orElseThrow { EntityNotFoundException("Review not found: $id") }

        if (dto.targetType != entity.targetType || dto.targetId != entity.targetId) {
            throw EntityNotFoundException("Cannot change review target")
        }

        updateEntityFromDto(entity, dto)
        val saved = reviewRepository.save(entity)
        return ReviewDto(saved)
    }

    fun delete(id: Long) {
        if(!reviewRepository.existsById(id)) {
            throw EntityNotFoundException("Review not found: $id")
        }
        reviewRepository.deleteById(id)
    }

    private fun updateEntityFromDto(entity: Review, dto: ReviewDto) {
        entity.comment = dto.comment
        entity.overallRating = dto.overallRating
        entity.difficultyRating = dto.difficultyRating
        entity.usefulnessRating = dto.usefulnessRating
        entity.teachingRating = dto.teachingRating
        entity.anonymous = dto.anonymous
    }
}
