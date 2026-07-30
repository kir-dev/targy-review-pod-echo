package hu.bme.sch.kirdev.targyreviewpodecho.review

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewController (private val reviewService: ReviewService) {

    @PostMapping("/subject/{id}/reviews")
    fun createForSubject(
        @PathVariable id: Long,
        @RequestBody dto: CreateReviewDto
    ): ResponseEntity<ReviewDto> {
        val created = reviewService.create(dto, ReviewTargetType.SUBJECT, id)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.status(HttpStatus.CREATED).body(created)
    }

    @PostMapping("/lecturer/{id}/reviews")
    fun createForLecturer(
        @PathVariable id: Long,
        @RequestBody dto: CreateReviewDto
    ): ResponseEntity<ReviewDto> {
        val created = reviewService.create(dto, ReviewTargetType.LECTURER, id)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.status(HttpStatus.CREATED).body(created)
    }

    @GetMapping("/review/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<ReviewDto> {
        val review = reviewService.getById(id)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.status(HttpStatus.OK).body(review)
    }

    @GetMapping("/review")
    fun list(
        @RequestParam(required = false) targetType: ReviewTargetType?,
        @RequestParam(required = false) targetId: Long?,
        @RequestParam(required = false) posterId: Long?,
    ): ResponseEntity<List<ReviewDto>> {
        val result = when {
            targetType != null && targetId != null ->
                reviewService.getByTarget(targetType, targetId)

            posterId != null ->
                reviewService.getByPoster(posterId)

            else ->
                emptyList()
        }
        return ResponseEntity.ok(result)
    }

    @PutMapping("/review/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: ReviewDto): ResponseEntity<ReviewDto> {
        val updated = reviewService.update(id, dto)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updated)
    }

    @DeleteMapping("/review/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (reviewService.delete(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

}