package hu.bme.sch.kirdev.targyreviewpodecho.subject

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class SubjectControllers(subjectService: SubjectService)
