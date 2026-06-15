package hu.bme.sch.kirdev.targyreviewpodecho.repository

import hu.bme.sch.kirdev.targyreviewpodecho.model.Review
import hu.bme.sch.kirdev.targyreviewpodecho.model.ReviewTargetType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<Review, Long> {
    fun findByTargetTypeAndTargetId(targetType: ReviewTargetType, targetId: Long): List<Review>

    fun findByPosterId(posterId: Long): List<Review>

}
