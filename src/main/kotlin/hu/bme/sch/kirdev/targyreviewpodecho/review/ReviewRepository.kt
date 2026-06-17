package hu.bme.sch.kirdev.targyreviewpodecho.review

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<Review, Long> {
    fun findByTargetTypeAndTargetId(targetType: ReviewTargetType, targetId: Long): List<Review>

    fun findByPosterId(posterId: Long): List<Review>

}
