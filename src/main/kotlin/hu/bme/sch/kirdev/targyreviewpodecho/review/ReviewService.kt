package hu.bme.sch.kirdev.targyreviewpodecho.review

import org.springframework.stereotype.Service

@Service
class ReviewService (
    private val reviewRepository: ReviewRepository,
    private val reviewMapper: ReviewMapper,
){
    fun create(dto: ReviewDto): ReviewDto {
        val entity = reviewMapper.toEntity(dto)
        val saved = reviewRepository.save(entity)
        return reviewMapper.toDto(saved)
    }

    fun getById(id: Long): ReviewDto {
        val entity = reviewRepository.findById(id).orElseThrow { NoSuchElementException("Review not found: $id") }
        return reviewMapper.toDto(entity)
    }

    fun getByTarget(targetType: ReviewTargetType, targetId: Long): List<ReviewDto>  =
        reviewRepository.findByTargetTypeAndTargetId(targetType, targetId)
            .map { reviewMapper.toDto(it) }

    fun getByPoster(posterId: Long): List<ReviewDto> =
            reviewRepository.findByPosterId(posterId)
            .map { reviewMapper.toDto(it) }

    fun update(id: Long, dto: ReviewDto): ReviewDto {
        val entity = reviewRepository.findById(id).orElseThrow { NoSuchElementException("Review not found: $id") }

        reviewMapper.updateEntityFromDto(entity, dto)
        val saved = reviewRepository.save(entity)
        return reviewMapper.toDto(saved)
    }

    fun delete(id: Long) {
        if(!reviewRepository.existsById(id)) {
            throw NoSuchElementException("Review not found: $id")
        }
        reviewRepository.deleteById(id)
    }
}
