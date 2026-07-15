package hu.bme.sch.kirdev.targyreviewpodecho.subject

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/subjects")
@CrossOrigin("*")
class SubjectController(private val subjectService: SubjectService) {

    @GetMapping
    fun getAllSubjects(): ResponseEntity<List<SubjectDto>> {
        return ResponseEntity.ok(subjectService.getAllSubjects())
    }

    @GetMapping("/{id}")
    fun getSubjectById(@PathVariable id: Long): ResponseEntity<SubjectDto> {
        return ResponseEntity.ok(subjectService.getSubject(id))
    }

    @PostMapping
    fun createSubject(@Valid @RequestBody subject: SubjectDto): ResponseEntity<SubjectDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.createSubject(subject))
    }

    @PutMapping("/{id}")
    fun updateSubject(@PathVariable id: Long, @Valid @RequestBody subject: SubjectDto): ResponseEntity<SubjectDto> {
        return ResponseEntity.ok(subjectService.updateSubject(subject, id))
    }

    @DeleteMapping("/{id}")
    fun deleteSubject(@PathVariable id: Long): ResponseEntity<Unit> {
        subjectService.deleteSubject(id)
        return ResponseEntity.noContent().build()
    }
}