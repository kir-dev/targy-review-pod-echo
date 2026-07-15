package hu.bme.sch.kirdev.targyreviewpodecho.review

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewController (private val reviewService: ReviewService) {

    @PostMapping("/subject/{id}/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    fun createForSubject(
        @PathVariable id: Long,
        @RequestBody dto: CreateReviewDto
    ): ReviewDto = reviewService.create(dto, ReviewTargetType.SUBJECT, id)

    @PostMapping("/lecturer/{id}/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    fun createForLecturer(
        @PathVariable id: Long,
        @RequestBody dto: CreateReviewDto
    ): ReviewDto = reviewService.create(dto, ReviewTargetType.LECTURER, id)


    @GetMapping("/review/{id}")
    fun getById(@PathVariable id: Long): ReviewDto = reviewService.getById(id)

    @GetMapping("/review")
    fun list(
        @RequestParam(required = false) targetType: ReviewTargetType?,
        @RequestParam(required = false) targetId: Long?,
        @RequestParam(required = false) posterId: Long?,
    ): List<ReviewDto> = when {
        targetType != null && targetId != null ->
            reviewService.getByTarget(targetType, targetId)
        posterId != null ->
            reviewService.getByPoster(posterId)
        else ->
            emptyList()
    }

    @PutMapping("/review/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: ReviewDto): ReviewDto =
        reviewService.update(id, dto)

    @DeleteMapping("/review/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) =
        reviewService.delete(id)

}